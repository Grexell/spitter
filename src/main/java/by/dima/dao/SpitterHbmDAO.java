package by.dima.dao;

import by.dima.model.entity.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class SpitterHbmDAO implements SpitterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String GET_BY_ID = "from Spitter where id_spitter=:id";
    private static final String GET_BY_USERNAME = "from Spitter where username=:username";
    private static final String GET_ALL = "from Spitter";

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void addSpitter(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();

        spitter.setId((int) session.save(spitter));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void updateSpitter(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();

        session.update(spitter);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    public void deleteSpitter(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(spitter);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Spitter getSpitterById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_BY_ID, Spitter.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Spitter getSpitterByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_BY_USERNAME, Spitter.class).setParameter("username", username).getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Spitter> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_ALL, Spitter.class).list();
    }
}