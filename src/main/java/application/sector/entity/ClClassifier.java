package application.sector.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cl_classifier")
public class ClClassifier  extends AbstractEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String code;
  private String name;
  private String description;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "classifier_id")
  private List<ClElement> elements = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<ClElement> getElements() {
    return elements;
  }

  public void setElements(List<ClElement> elements) {
    this.elements = elements;
  }
}
