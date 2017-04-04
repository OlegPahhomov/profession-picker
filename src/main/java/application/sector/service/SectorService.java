package application.sector.service;

import application.sector.dao.ClElementDao;
import application.sector.dao.FoFormDao;
import application.sector.dao.FoFormSectorJoinDao;
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

@Service
@Transactional
public class SectorService {

  @Autowired
  private ClElementDao clElementDao;
  @Autowired
  private FoFormDao foFormDao;
  @Autowired
  private FoFormSectorJoinDao foFormSectorJoinDao;
  @Autowired
  private SectorConverter sectorConverter;

  public FormPageDto getDtos() {
    List<ClElement> sectorElements = clElementDao.getByKlfCode("SECTOR");
    List<FoForm> foForms = foFormDao.findAll();

    FormPageDto dtos = new FormPageDto();
    if (foForms.isEmpty()) {
      dtos.setForms(Arrays.asList(emptyForm(sectorElements)));
    } else {
      dtos.setForms(sectorConverter.conver(sectorElements, foForms));
    }
    return dtos;
  }

  public FormDto save(FormDto dto) {
    FoForm form = saveOrUpdateForm(dto);
    List<StructureClElementDto> elements = dto.getElements();
    for (StructureClElementDto element : elements) {
      if (element.isSelected() && element.getId() == null) {
        FoFormSectorJoin newJoin = new FoFormSectorJoin();
        newJoin.setFormId(form);
        newJoin.setSectorKlId(clElementDao.getById(element.getElId()));
        foFormDao.save(newJoin);
      } else if (!element.isSelected() && element.getId() != null) {
        foFormDao.delete(foFormSectorJoinDao.getById(element.getId()));
      }
    }
    return dto;
  }

  private FoForm saveOrUpdateForm(FormDto dto) {
    if (dto.getId() == null) {
      FoForm form = new FoForm();
      form.setAgreement(dto.isAgreement());
      form.setUserName(dto.getUserName());
      form.setName("ver1");
      foFormDao.save(form);
      dto.setId(form.getId());
      return form;
    }
    FoForm form = foFormDao.getById(dto.getId());
    form.setAgreement(dto.isAgreement());
    form.setUserName(dto.getUserName());
    form.setName(dto.getName());
    return form;
  }

  private FormDto emptyForm(List<ClElement> sector) {
    FormDto formDto = new FormDto();
    formDto.setElements(sectorConverter.convert(sector, new ArrayList<>()));
    return formDto;
  }
}
