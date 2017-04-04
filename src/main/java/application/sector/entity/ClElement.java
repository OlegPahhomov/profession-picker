package application.sector.entity;

import javax.persistence.*;

@Entity
@Table(name = "cl_element")
public class ClElement {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "classifier_id")
  private ClClassifier classifier;
  private String code;
  private String name;
  private String description;
  private Integer orderNr;
  private Integer levelNr;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ClClassifier getClassifier() {
    return classifier;
  }

  public void setClassifier(ClClassifier classifier) {
    this.classifier = classifier;
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

  public Integer getOrderNr() {
    return orderNr;
  }

  public void setOrderNr(Integer orderNr) {
    this.orderNr = orderNr;
  }

  public Integer getLevelNr() {
    return levelNr;
  }

  public void setLevelNr(Integer levelNr) {
    this.levelNr = levelNr;
  }
}
