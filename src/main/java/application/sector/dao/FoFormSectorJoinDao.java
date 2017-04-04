package application.sector.dao;

import application.sector.entity.FoForm;
import application.sector.entity.FoFormSectorJoin;
import org.springframework.stereotype.Repository;

@Repository
public class FoFormSectorJoinDao extends BaseDao {

  public FoFormSectorJoin getById(Long id){
    return id == null ? null : getById(FoFormSectorJoin.class, id);
  }
}
