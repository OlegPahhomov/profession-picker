package application.sector.dao;

import application.sector.entity.ClClassifier;
import application.sector.entity.ClElement;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

@Repository
public class ClElementDao extends BaseDao{

  public ClElement getById(Long id){
    return id == null ? null : getById(ClElement.class, id);
  }

  public ClClassifier getClfById(Long id){
    return id == null ? null : getById(ClClassifier.class, id);
  }

  public List<ClElement> getByKlfCode(String klfCode){
    return getCurrentSession().createCriteria(ClElement.class)
            .createAlias("classifier", "clf")
            .add(eq("clf.code", klfCode))
            .addOrder(Order.asc("orderNr"))
            .list();
  }
}
