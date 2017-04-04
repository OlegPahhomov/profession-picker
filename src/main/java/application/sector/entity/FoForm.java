package application.sector.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fo_form")
public class FoForm extends AbstractEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String userName;
  private boolean agreement;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "form_id")
  private List<FoFormSectorJoin> formSectors = new ArrayList<>();

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

  public List<FoFormSectorJoin> getFormSectors() {
    return formSectors;
  }

  public void setFormSectors(List<FoFormSectorJoin> formSectors) {
    this.formSectors = formSectors;
  }
}
