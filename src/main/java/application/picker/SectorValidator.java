package application.picker;

import application.picker.dto.FormDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class SectorValidator {

  public MessageContainer validateForm(@RequestBody FormDto dto) {
    MessageContainer container = new MessageContainer();
    if (StringUtils.isBlank(dto.getName())){
      container.addError("please fill the name");
    }
//    todo add validation for list
    if (!dto.isAgreement()){
      container.addError("you must agree to the terms");
    }
    return container;
  }
}
