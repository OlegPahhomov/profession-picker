package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V1__Add_files_table implements SpringJdbcMigration {
    public void migrate(JdbcTemplate jdbcTemplate) throws Exception {

    }
}
