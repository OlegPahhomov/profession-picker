package application.sector.controller;

import application.sector.MessageContainer;
import application.sector.dto.FormDto;
import application.sector.dto.StructureClElementDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class SectorValidator {

  public MessageContainer validateForm(@RequestBody FormDto dto) {
    MessageContainer container = new MessageContainer();
    if (StringUtils.isBlank(dto.getUserName())){
      container.addError("please fill the name");
    }
    long countOfSelected = dto.getElements().stream().filter(StructureClElementDto::isSelected).count();
    if (countOfSelected == 0){
      container.addError("no sector is chosen");
    } else if (countOfSelected > 5){
      container.addError("choose up to 5 sectors");
    }
    if (!dto.isAgreement()){
      container.addError("you must agree to the terms");
    }
    return container;
  }
}
