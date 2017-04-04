package application.sector.dto;

import java.util.ArrayList;
import java.util.List;

public class FormDto {

  private Long id;
  private String name;
  private String userName;
  private boolean agreement;
  private List<StructureClElementDto> elemendid;

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

  public List<StructureClElementDto> getElemendid() {
    if (elemendid == null){
      elemendid = new ArrayList<>();
    }
    return elemendid;
  }

  public void setElemendid(List<StructureClElementDto> elemendid) {
    this.elemendid = elemendid;
  }
}
