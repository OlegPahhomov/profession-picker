package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import javax.sql.DataSource;

@SpringBootApplication
public class Application {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}