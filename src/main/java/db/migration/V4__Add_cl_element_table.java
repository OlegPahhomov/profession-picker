package db.migration;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.jdbc.core.JdbcTemplate;

public class V4__Add_cl_element_table implements SpringJdbcMigration {
  @Override
  public void migrate(JdbcTemplate jdbcTemplate) throws Exception {
    int i = 1;
  insertElement(jdbcTemplate, 1, "Manufacturing", 1, i++);
	insertElement(jdbcTemplate, 19, "Construction materials", 2, i++);
	insertElement(jdbcTemplate, 18, "Electronics and Optics", 2, i++);
	insertElement(jdbcTemplate, 6, "Food and Beverage", 2, i++);
	insertElement(jdbcTemplate, 342, "Bakery & confectionery products", 3, i++);
	insertElement(jdbcTemplate, 43, "Beverages", 3, i++);
	insertElement(jdbcTemplate, 42, "Fish &amp; fish products", 3, i++);
	insertElement(jdbcTemplate, 40, "Meat &amp; meat products", 3, i++);
	insertElement(jdbcTemplate, 39, "Milk &amp; dairy products", 3, i++);
	insertElement(jdbcTemplate, 437, "Other", 3, i++);
	insertElement(jdbcTemplate, 378, "Sweets &amp; snack food", 3, i++);
	insertElement(jdbcTemplate, 13, "Furniture", 2, i++);
	insertElement(jdbcTemplate, 389, "Bathroom/sauna", 3, i++);
	insertElement(jdbcTemplate, 385, "Bedroom", 3, i++);
	insertElement(jdbcTemplate, 390, "Children’s room", 3, i++);
	insertElement(jdbcTemplate, 98, "Kitchen", 3, i++);
	insertElement(jdbcTemplate, 101, "Living room", 3, i++);
	insertElement(jdbcTemplate, 392, "Office", 3, i++);
	insertElement(jdbcTemplate, 394, "Other (Furniture)", 3, i++);
	insertElement(jdbcTemplate, 341, "Outdoor", 3, i++);
	insertElement(jdbcTemplate, 99, "Project furniture", 3, i++);
	insertElement(jdbcTemplate, 12, "Machinery", 2, i++);
	insertElement(jdbcTemplate, 94, "Machinery components", 3, i++);
	insertElement(jdbcTemplate, 91, "Machinery equipment/tools", 3, i++);
	insertElement(jdbcTemplate, 224, "Manufacture of machinery", 3, i++);
	insertElement(jdbcTemplate, 97, "Maritime", 3, i++);
	insertElement(jdbcTemplate, 271, "Aluminium and steel workboats ", 4, i++);
	insertElement(jdbcTemplate, 269, "Boat/Yacht building", 1, i++);
	insertElement(jdbcTemplate, 230, "Ship repair and conversion", 1, i++);
	insertElement(jdbcTemplate, 93, "Metal structures", 3, i++);
	insertElement(jdbcTemplate, 508, "Other", 3, i++);
	insertElement(jdbcTemplate, 227, "Repair and maintenance service", 3, i++);
	insertElement(jdbcTemplate, 11, "Metalworking", 2, i++);
	insertElement(jdbcTemplate, 67, "Construction of metal structures", 3, i++);
	insertElement(jdbcTemplate, 263, "Houses and buildings", 3, i++);
	insertElement(jdbcTemplate, 267, "Metal products", 3, i++);
	insertElement(jdbcTemplate, 542, "Metal works", 3, i++);
	insertElement(jdbcTemplate, 75, "CNC-machining", 4, i++);
	insertElement(jdbcTemplate, 62, "Forgings, Fasteners", 4, i++);
	insertElement(jdbcTemplate, 69, "Gas, Plasma, Laser cutting", 4, i++);
	insertElement(jdbcTemplate, 66, "MIG, TIG, Aluminum welding", 4, i++);
	insertElement(jdbcTemplate, 9, "Plastic and Rubber", 2, i++);
	insertElement(jdbcTemplate, 54, "Packaging", 3, i++);
	insertElement(jdbcTemplate, 556, "Plastic goods", 3, i++);
	insertElement(jdbcTemplate, 559, "Plastic processing technology", 3, i++);
	insertElement(jdbcTemplate, 55, "Blowing", 4, i++);
	insertElement(jdbcTemplate, 57, "Moulding", 4, i++);
	insertElement(jdbcTemplate, 53, "Plastics welding and processing", 4, i++);
	insertElement(jdbcTemplate, 560, "Plastic profiles", 3, i++);
	insertElement(jdbcTemplate, 5, "Printing", 2, i++);
	insertElement(jdbcTemplate, 148, "Advertising", 3, i++);
	insertElement(jdbcTemplate, 150, "Book/Periodicals printing", 3, i++);
	insertElement(jdbcTemplate, 145, "Labelling and packaging printing", 3, i++);
	insertElement(jdbcTemplate, 7, "Textile and Clothing", 2, i++);
	insertElement(jdbcTemplate, 44, "Clothing", 3, i++);
	insertElement(jdbcTemplate, 45, "Textile", 3, i++);
	insertElement(jdbcTemplate, 8, "Wood", 2, i++);
	insertElement(jdbcTemplate, 337, "Other (Wood)", 3, i++);
	insertElement(jdbcTemplate, 51, "Wooden building materials", 3, i++);
	insertElement(jdbcTemplate, 47, "Wooden houses", 3, i++);
	insertElement(jdbcTemplate, 3, "Other", 1, i++);
	insertElement(jdbcTemplate, 37, "Creative industries", 2, i++);
	insertElement(jdbcTemplate, 29, "Energy technology", 2, i++);
	insertElement(jdbcTemplate, 33, "Environment", 2, i++);
	insertElement(jdbcTemplate, 2, "Service", 1, i++);
	insertElement(jdbcTemplate, 25, "Business services", 2, i++);
	insertElement(jdbcTemplate, 35, "Engineering", 2, i++);
	insertElement(jdbcTemplate, 28, "Information Technology and Telecommunications", 2, i++);
	insertElement(jdbcTemplate, 581, "Data processing, Web portals, E-marketing", 3, i++);
	insertElement(jdbcTemplate, 576, "Programming, Consultancy", 3, i++);
	insertElement(jdbcTemplate, 121, "Software, Hardware", 3, i++);
	insertElement(jdbcTemplate, 122, "Telecommunications", 2, i++);
	insertElement(jdbcTemplate, 22, "Tourism", 2, i++);
	insertElement(jdbcTemplate, 141, "Translation services", 2, i++);
	insertElement(jdbcTemplate, 21, "Transport and Logistics", 2, i++);
	insertElement(jdbcTemplate, 111, "Air", 3, i++);
	insertElement(jdbcTemplate, 114, "Rail", 3, i++);
	insertElement(jdbcTemplate, 112, "Road", 3, i++);
	insertElement(jdbcTemplate, 113, "Water", 3, i++);
  }

  private void insertElement(JdbcTemplate jdbcTemplate, Integer id, String codeAndName, Integer level, Integer order) {
    jdbcTemplate.update("INSERT INTO CL_ELEMENT(id, classifier_id, code, name, description, order_nr, level_nr) VALUES (?, 1, ?, ?, NULL , ?, ?)",
            id, codeAndName, codeAndName, order, level);
  }
}
