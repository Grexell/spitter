package by.dima.dao;

import by.dima.model.entity.Spitter;
import by.dima.model.entity.Spittle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class SpittleHbmDAO implements SpittleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String GET_BY_ID = "from Spittle where id=:id";
    private static final String GET_BY_SPITTER_ID = "select spittle from Spittle as spittle inner join spittle.spitter as spitter where spitter.id=:spitterId";
    private static final String GET_ALL = "from Spittle";
    private static final String GET_LAST = "from Spittle order by id desc";

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addSpittle(Spittle spittle) {
        Session session = sessionFactory.getCurrentSession();

        spittle.setId((int) session.save(spittle));
    }

    @Override
    @Transactional
    public void updateSpittle(Spittle spittle) {
        Session session = sessionFactory.getCurrentSession();

        session.update(spittle);
    }

    @Override
    @Transactional
    public void deleteSpittle(Spittle spittle) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(spittle);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public Spittle getSpittleById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_BY_ID, Spittle.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Spittle> getAll() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_ALL, Spittle.class).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
        public List<Spittle> getAllBySpitter(Spitter spitter) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_BY_SPITTER_ID, Spittle.class).setParameter("spitterId", spitter.getId()).list();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
    public List<Spittle> getLast(int amount) {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery(GET_LAST, Spittle.class).setMaxResults(amount).list();
    }
}