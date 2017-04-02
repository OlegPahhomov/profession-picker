package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V1__Add_classifiers_table implements SpringJdbcMigration {
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.update("CREATE TABLE CL_CLASSIFIER (\n" +
                "  id      BIGSERIAL PRIMARY KEY                  NOT NULL,\n" +
                "  code    TEXT CHECK (code <> '')  UNIQUE        NOT NULL,\n" +
                "  name    TEXT CHECK (name <> '')                NOT NULL,\n" +
                "  description TEXT                               NULL\n" +
                ");"
        );

        jdbcTemplate.update("comment on column CL_CLASSIFIER.id is 'unique identifier, PK'");
        jdbcTemplate.update("comment on column CL_CLASSIFIER.code is 'code of the classifier'");
        jdbcTemplate.update("comment on column CL_CLASSIFIER.name is 'name of the classifier'");
        jdbcTemplate.update("comment on column CL_CLASSIFIER.description is 'description'");
    }
}
