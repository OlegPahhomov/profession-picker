package application.sector.controller;

import application.sector.MessageContainer;
import application.sector.Result;
import application.sector.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import application.sector.dto.FormDto;

import static application.sector.Result.ok;
import static application.sector.Result.nok;

@RequestMapping("/sectors")
@RestController
public class SectorController {

  @Autowired
  private SectorValidator validator;
  @Autowired
  private SectorService sectorService;

  @RequestMapping(method = RequestMethod.GET)
  public Result get(){
    return ok(sectorService.getDtos());
  }

  @RequestMapping(method = RequestMethod.POST)
  public Result post(@RequestBody FormDto dto){
    MessageContainer container = validator.validateForm(dto);
    if (container.hasErrors()){
      return nok(container);
    }
    FormDto savedDto = sectorService.saveOrUpdate(dto);
    savedDto.setContainer(successContainer());
    return ok(savedDto);
  }

  private MessageContainer successContainer() {
    MessageContainer messageContainer = new MessageContainer();
    messageContainer.addSuccess("Successfully saved");
    return messageContainer;
  }
}
