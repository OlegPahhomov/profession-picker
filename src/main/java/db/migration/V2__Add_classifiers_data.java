package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V2__Add_classifiers_data implements SpringJdbcMigration {

    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
        jdbcTemplate.update("INSERT INTO CL_CLASSIFIER(id, code, name, description) VALUES (1, 'SECTOR', 'Sector', null)");
    }
}
