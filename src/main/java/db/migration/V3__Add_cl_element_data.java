package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V3__Add_cl_element_data implements SpringJdbcMigration {
  @Override
  public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
    jdbcTemplate.update("CREATE TABLE CL_ELEMENT (\n" +
            "  id      BIGSERIAL PRIMARY KEY                   NOT NULL,\n" +
            "  classifier_id      BIGSERIAL REFERENCES CL_CLASSIFIER (id) NOT NULL,\n" +
            "  code    TEXT CHECK (code <> '')                 NOT NULL,\n" +
            "  name    TEXT CHECK (NAME <> '')                 NOT NULL,\n" +
            "  description TEXT                                NULL,\n" +
            "  order_nr   INTEGER                                 NULL,\n" +
            "  level_nr   INTEGER                                 NULL" +
            ");"
    );

    jdbcTemplate.update("comment on column CL_ELEMENT.id is 'unique identifier, PK'");
    jdbcTemplate.update("comment on column CL_ELEMENT.classifier_id is 'Classifier, what the element belongs to. FK on CL_CLASSIFIER'");
    jdbcTemplate.update("comment on column CL_ELEMENT.code is 'code of the element'");
    jdbcTemplate.update("comment on column CL_ELEMENT.name is 'name of the element'");
    jdbcTemplate.update("comment on column CL_ELEMENT.description is 'description'");
    jdbcTemplate.update("comment on column CL_ELEMENT.order_nr is 'custom order of the elements'");
    jdbcTemplate.update("comment on column CL_ELEMENT.level_nr is 'for expressing hierarchy'");
  }
}
