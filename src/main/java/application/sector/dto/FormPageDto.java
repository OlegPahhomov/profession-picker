package application.sector.dto;

import application.sector.MessageContainer;
import application.sector.entity.ClElement;

import java.util.List;

public class FormPageDto {

  private MessageContainer container;
  private List<FormDto> forms;

  public FormPageDto(List<FormDto> forms) {
    this.forms = forms;
  }

  public FormPageDto() {
  }

  public MessageContainer getContainer() {
    return container;
  }

  public void setContainer(MessageContainer container) {
    this.container = container;
  }

  public List<FormDto> getForms() {
    return forms;
  }

  public void setForms(List<FormDto> forms) {
    this.forms = forms;
  }

}
