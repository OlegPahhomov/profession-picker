package application.sector.dto;

import application.sector.MessageContainer;

import java.util.ArrayList;
import java.util.List;

public class FormDto {

  private Long id;
  private String name;
  private String userName;
  private boolean agreement;
  private List<StructureClElementDto> elements;
  private MessageContainer container;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public boolean isAgreement() {
    return agreement;
  }

  public void setAgreement(boolean agreement) {
    this.agreement = agreement;
  }

  public List<StructureClElementDto> getElements() {
    if (elements == null){
      elements = new ArrayList<>();
    }
    return elements;
  }

  public void setElements(List<StructureClElementDto> elements) {
    this.elements = elements;
  }

  public MessageContainer getContainer() {
    return container;
  }

  public void setContainer(MessageContainer container) {
    this.container = container;
  }
}
