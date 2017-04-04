package application.sector.entity;

import javax.persistence.*;

@Entity
@Table(name = "fo_form")
public class FoFormSectorJoin {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "form_id")
  private FoForm formId;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sector_kl_id")
  private ClElement sectorKlId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public FoForm getFormId() {
    return formId;
  }

  public void setFormId(FoForm formId) {
    this.formId = formId;
  }

  public ClElement getSectorKlId() {
    return sectorKlId;
  }

  public void setSectorKlId(ClElement sectorKlId) {
    this.sectorKlId = sectorKlId;
  }
}
