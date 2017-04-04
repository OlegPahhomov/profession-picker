package application.picker;

import application.picker.entity.ClClassifier;
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
}
