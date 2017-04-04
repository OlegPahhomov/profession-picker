package application.sector.dao;

import application.sector.entity.ClElement;
import application.sector.entity.FoForm;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FoFormDao extends BaseDao {

  public FoForm getById(Long id){
    return id == null ? null : getById(FoForm.class, id);
  }

  public FoForm getByName(String name){
    return (FoForm) getCurrentSession().createCriteria(FoForm.class)
            .add(Restrictions.eq("name", name))
            .uniqueResult();
  }

  public List<FoForm> findAll(){
    return getCurrentSession().createCriteria(FoForm.class).list();
  }
}
