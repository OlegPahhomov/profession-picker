package application.picker.dto;

import application.picker.MessageContainer;

import java.util.List;

public class FormPageDto {

  private MessageContainer container;
  private List<FormDto> forms;

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
