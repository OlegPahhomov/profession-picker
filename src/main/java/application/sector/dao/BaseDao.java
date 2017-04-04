package application.sector.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

  @Autowired
  private SessionFactory sessionFactory;

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }
}
