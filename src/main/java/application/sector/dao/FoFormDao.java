package application.sector.dao;

import application.sector.entity.FoForm;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoFormDao extends BaseDao {

  public List<FoForm> findAll(){
    return getCurrentSession().createCriteria(FoForm.class).list();
  }
}
