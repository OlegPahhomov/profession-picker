package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V5__Add_form_table implements SpringJdbcMigration {
  @Override
  public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
    jdbcTemplate.update("CREATE TABLE FO_FORM (\n" +
            "  id      BIGSERIAL PRIMARY KEY                  NOT NULL,\n" +
            "  name    TEXT                                   NOT NULL,\n" +
            "  user_name    TEXT                                   NOT NULL,\n" +
            "  agreement    boolean                           NOT NULL\n" +
            ");"
    );

    jdbcTemplate.update("comment on column FO_FORM.id is 'unique identifier, PK'");
    jdbcTemplate.update("comment on column FO_FORM.name is 'name of the form'");
    jdbcTemplate.update("comment on column FO_FORM.user_name is 'name of the user'");
    jdbcTemplate.update("comment on column FO_FORM.agreement is 'does the user accept? yes/no'");
  }
}
