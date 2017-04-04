package application.picker;

import org.springframework.web.bind.annotation.*;
import application.picker.dto.FormDto;

import static application.picker.Result.ok;
import static application.picker.Result.nok;

@RequestMapping("/sectors")
@RestController
public class SectorsController{

  @RequestMapping(method = RequestMethod.GET)
  public Result get(){
    FormDto form = new FormDto();
    form.setName("12313");
    return ok(form);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Result post(@RequestBody FormDto dto){
    FormDto form = new FormDto();
    form.setName("12313");
    return ok(form);
  }
}
