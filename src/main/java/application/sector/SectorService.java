package application.sector;

import application.sector.entity.ClClassifier;
import application.sector.entity.ClElement;
import application.sector.entity.FoForm;
import application.sector.entity.FoFormSectorJoin;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SectorService {

  @Autowired
  private SessionFactory sessionFactory;

  public List<ClClassifier> getAll(){
    return sessionFactory.getCurrentSession().createCriteria(ClClassifier.class)
            .list();
  }

  public List<ClElement> getAll2(){
    return sessionFactory.getCurrentSession().createCriteria(ClElement.class)
            .list();
  }

  public List<FoForm> getAll23(){
    return sessionFactory.getCurrentSession().createCriteria(FoForm.class)
            .list();
  }

  public List<FoFormSectorJoin> getAll22(){
    return sessionFactory.getCurrentSession().createCriteria(FoFormSectorJoin.class)
            .list();
  }
}
