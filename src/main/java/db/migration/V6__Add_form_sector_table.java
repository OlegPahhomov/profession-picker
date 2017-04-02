package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V6__Add_form_sector_table implements SpringJdbcMigration {
  @Override
  public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
    jdbcTemplate.update("CREATE TABLE FO_FORM_SECTOR_JOIN (\n" +
            "  id      BIGSERIAL PRIMARY KEY                  NOT NULL,\n" +
            "  form_id      BIGSERIAL REFERENCES FO_FORM (id) NOT NULL,\n" +
            "  sector_kl_id      BIGSERIAL REFERENCES CL_ELEMENT (id) NOT NULL,\n" +
            "  description TEXT                               NULL\n" +
            ");"
    );

    jdbcTemplate.update("comment on column FO_FORM_SECTOR_JOIN.id is 'unique identifier, PK'");
    jdbcTemplate.update("comment on column FO_FORM_SECTOR_JOIN.form_id is 'FK on FO_FORM'");
    jdbcTemplate.update("comment on column FO_FORM_SECTOR_JOIN.sector_kl_id is 'FK on CL_ELEMENT'");
    jdbcTemplate.update("comment on column FO_FORM_SECTOR_JOIN.description is 'description'");
  }
}
