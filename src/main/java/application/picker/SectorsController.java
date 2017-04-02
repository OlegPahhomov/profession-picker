package application.picker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
