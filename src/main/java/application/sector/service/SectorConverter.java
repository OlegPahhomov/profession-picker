package application.sector.service;

import application.sector.dto.FormDto;
import application.sector.dto.StructureClElementDto;
import application.sector.entity.ClElement;
import application.sector.entity.FoForm;
import application.sector.entity.FoFormSectorJoin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectorConverter {

  public List<FormDto> convertForms(List<ClElement> sector, List<FoForm> foForms) {
    return foForms.stream().map(form -> convertForm(sector, form)).collect(Collectors.toList());
  }

  private FormDto convertForm(List<ClElement> sector, FoForm form) {
    FormDto dto = new FormDto();
    dto.setId(form.getId());
    dto.setName(form.getName());
    dto.setUserName(form.getUserName());
    dto.setAgreement(form.isAgreement());
    dto.setElements(convertElements(sector, form.getFormSectors()));
    return dto;
  }

  public List<StructureClElementDto> convertElements(List<ClElement> sector, List<FoFormSectorJoin> formSectors) {
    return sector.stream().map(sec -> convertElement(sec, formSectors)).collect(Collectors.toList());
  }

  private StructureClElementDto convertElement(ClElement sec, List<FoFormSectorJoin> formSectors) {
    StructureClElementDto dto = new StructureClElementDto();
    Optional<Long> formSectorId = formSectors.stream().filter(m -> m.getSectorKlId().getId().equals(sec.getId()))
            .findAny()
            .flatMap(x -> Optional.of(x.getId()));
    formSectorId.ifPresent(dto::setId);
    dto.setSelected(formSectorId.isPresent());
    dto.setElId(sec.getId());
    dto.setName(sec.getName());
    dto.setLevel(sec.getLevelNr());
    dto.setOrder(sec.getOrderNr());
    return dto;
  }

}
