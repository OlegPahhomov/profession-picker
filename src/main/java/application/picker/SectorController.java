package application.picker;

import application.picker.entity.ClClassifier;
import org.apache.commons.lang.StringUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import application.picker.dto.FormDto;

import java.util.List;

import static application.picker.Result.ok;
import static application.picker.Result.nok;

@RequestMapping("/sectors")
@RestController
public class SectorController {

  @Autowired
  private SectorValidator validator;
  @Autowired
  private SectorService sectorService;

  @RequestMapping(method = RequestMethod.GET)
  public Result get(){
    List<ClClassifier> all = sectorService.getAll();
    FormDto form = new FormDto();
    form.setName("12313");
    return ok(form);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Result post(@RequestBody FormDto dto){
    MessageContainer container = validator.validateForm(dto);
    if (container.hasErrors()){
      return nok(container);
    }
//    todo save
    return ok();
  }
}
