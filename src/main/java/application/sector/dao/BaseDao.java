package application.sector.dao;

import application.sector.entity.AbstractEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public abstract class BaseDao {

  @Autowired
  private SessionFactory sessionFactory;

  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
  }

  public <CE extends AbstractEntity> Serializable save(CE entity) {
    return getCurrentSession().save(entity);
  }

  public <CE extends AbstractEntity> CE getById(final Class<CE> clazz, Serializable id) {
    return (CE) getCurrentSession().get(clazz, id);
  }

  public <CE extends AbstractEntity> void delete(CE entity) {
    getCurrentSession().delete(entity);
  }
}
