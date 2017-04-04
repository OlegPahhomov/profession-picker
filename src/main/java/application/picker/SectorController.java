package application.picker;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import application.picker.dto.FormDto;

import static application.picker.Result.ok;
import static application.picker.Result.nok;

@RequestMapping("/sectors")
@RestController
public class SectorController {

  @Autowired
  private SectorValidator validator;

  @RequestMapping(method = RequestMethod.GET)
  public Result get(){
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
