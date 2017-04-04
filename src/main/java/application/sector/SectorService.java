package application.sector;

import application.sector.dao.ClElementDao;
import application.sector.dao.FoFormDao;
import application.sector.dto.ClElementDto;
import application.sector.dto.FormDto;
import application.sector.dto.FormPageDto;
import application.sector.dto.StructureClElementDto;
import application.sector.entity.ClElement;
import application.sector.entity.FoForm;
import application.sector.entity.FoFormSectorJoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SectorService {

  @Autowired
  private ClElementDao clElementDao;
  @Autowired
  private FoFormDao foFormDao;

  public FormPageDto getDtos() {
    List<ClElement> sectorElements = clElementDao.getByKlfCode("SECTOR");
    List<FoForm> foForms = foFormDao.findAll();

    FormPageDto dtos = new FormPageDto();
    if (foForms.isEmpty()){
      dtos.setForms(Arrays.asList(emptyForm(sectorElements)));
    } else {
      dtos.setForms(conver(sectorElements, foForms));
    }
    return dtos;
  }

  private List<ClElementDto> convert(List<ClElement> sector) {
    return sector.stream().map(this::convert).collect(Collectors.toList());
  }

  private List<FormDto> conver(List<ClElement> sector, List<FoForm> foForms) {
    return foForms.stream().map(form -> convert231(sector, form)).collect(Collectors.toList());
  }

  private FormDto convert231(List<ClElement> sector, FoForm form) {
    FormDto dto = new FormDto();
    dto.setId(form.getId());
    dto.setName(form.getName());
    dto.setUserName(form.getUserName());
    dto.setAgreement(form.isAgreement());
    dto.setElements(convert(sector, form.getFormSectors()));
    return dto;
  }

  private List<StructureClElementDto> convert(List<ClElement> sector, List<FoFormSectorJoin> formSectors) {
    return sector.stream().map(sec -> convert(sec, formSectors)).collect(Collectors.toList());
  }

  private StructureClElementDto convert(ClElement sec, List<FoFormSectorJoin> formSectors) {
    StructureClElementDto dto = new StructureClElementDto();
    Optional<Long> sectorId = formSectors.stream().filter(m -> m.getSectorKlId().getId().equals(sec.getId()))
            .findAny()
            .flatMap(x -> Optional.of(x.getId()));
    sectorId.ifPresent(dto::setId);
    dto.setSelected(sectorId.isPresent());
    dto.setName(sec.getName());
    dto.setLevel(sec.getLevelNr());
    dto.setOrder(sec.getOrderNr());
    return dto;
  }

  private ClElementDto convert(ClElement sec) {
    ClElementDto dto = new ClElementDto();
    dto.setName(sec.getName());
    dto.setLevel(sec.getLevelNr());
    dto.setOrder(sec.getOrderNr());
    return dto;
  }

  private FormDto emptyForm(List<ClElement> sector) {
    FormDto formDto = new FormDto();
    formDto.setElements(convert(sector, new ArrayList<>()));
    return formDto;
  }
}
