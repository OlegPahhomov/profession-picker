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
import java.util.Collections;
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
    return new FormPageDto(convertForms(clElementDao.getByKlfCode("SECTOR"), foFormDao.findAll()));
  }

  public FormDto save(FormDto dto) {
    FoForm form = saveOrUpdateForm(dto);
    List<StructureClElementDto> elements = dto.getElements();
    for (StructureClElementDto element : elements) {
      if (element.isSelected() && element.getId() == null) {
        saveNew(form, element);
      } else if (!element.isSelected() && element.getId() != null) {
        deleteOld(element);
      }
    }
    return dto;
  }

  private List<FormDto> convertForms(List<ClElement> sectorElements, List<FoForm> foForms) {
    return foForms.isEmpty() ? Collections.singletonList(emptyForm(sectorElements)) : sectorConverter.convertForms(sectorElements, foForms);
  }

  private void saveNew(FoForm form, StructureClElementDto element) {
    FoFormSectorJoin newJoin = new FoFormSectorJoin();
    newJoin.setFormId(form);
    newJoin.setSectorKlId(clElementDao.getById(element.getElId()));
    foFormDao.save(newJoin);
    element.setId(newJoin.getId());
  }

  private FoForm saveOrUpdateForm(FormDto dto) {
    if (dto.getId() == null) {
      FoForm form = new FoForm();
      form.setAgreement(dto.isAgreement());
      form.setUserName(dto.getUserName());
      form.setName(dto.getName());
      foFormDao.save(form);
      dto.setId(form.getId());
      return form;
    }
    FoForm form = foFormDao.getById(dto.getId());
    form.setAgreement(dto.isAgreement());
    form.setUserName(dto.getUserName());
    return form;
  }

  private FormDto emptyForm(List<ClElement> sector) {
    FormDto formDto = new FormDto();
    formDto.setElements(sectorConverter.convertElements(sector, new ArrayList<>()));
    formDto.setName("ver1");
    return formDto;
  }

  private void deleteOld(StructureClElementDto element) {
    FoFormSectorJoin byId = foFormSectorJoinDao.getById(element.getId());
    foFormDao.delete(byId);
    foFormDao.flush();
    element.setId(null);
  }
}
