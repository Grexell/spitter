package by.dima.dao;

import by.dima.model.entity.Spitter;
import by.dima.model.entity.Spittle;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SpittleHbmDAOTest {
    private static SessionFactory sessionFactory;
    private static SpittleHbmDAO spittleHbmDAO;
    private static Spittle spittle;
    private static Spitter spitter;
    private static SpitterHbmDAO spitterHbmDAO;

    @BeforeClass
    public static void setUpClass() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

        spittleHbmDAO = new SpittleHbmDAO();
        spittleHbmDAO.setSessionFactory(sessionFactory);

        spittle = new Spittle("test message", new Date());
        spitter = new Spitter();

        spitter.setEmail("demesh.dima.dd@gmail.com");
        spitter.setUsername("dima");
        spitter.setPassword("123456");
        spittle.setSpitter(spitter);

        sessionFactory.getCurrentSession().beginTransaction();

        spitterHbmDAO = new SpitterHbmDAO();
        spitterHbmDAO.setSessionFactory(sessionFactory);
        spitterHbmDAO.addSpitter(spitter);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @AfterClass
    public static void teadDownClass(){
        sessionFactory.getCurrentSession().beginTransaction();
        spitterHbmDAO.deleteSpitter(spitter);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Before
    public void setUp() throws Exception {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    @After
    public void tearDown() throws Exception {
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Test
    public void addSpittle() {
        int amount = spittleHbmDAO.getAll().size();
        spittleHbmDAO.addSpittle(spittle);
        int newAmount = spittleHbmDAO.getAll().size();

        assertEquals(amount + 1, newAmount);

        spittleHbmDAO.deleteSpittle(spittle);
    }

    @Test
    public void updateSpittle() {
        spittleHbmDAO.addSpittle(spittle);

        spittle.setMessage(spittle.getMessage() + "2");
        spittleHbmDAO.updateSpittle(spittle);

        assertEquals(spittle, spittleHbmDAO.getSpittleById(spittle.getId()));

        spittleHbmDAO.deleteSpittle(spittle);
    }

    @Test
    public void deleteSpittle() {
        spittleHbmDAO.addSpittle(spittle);
        int amount = spittleHbmDAO.getAll().size();
        spittleHbmDAO.deleteSpittle(spittle);
        int newAmount = spittleHbmDAO.getAll().size();

        assertEquals(amount - 1, newAmount);
    }

    @Test
    public void getSpittleById() {
        spittleHbmDAO.addSpittle(spittle);

        assertEquals(spittle, spittleHbmDAO.getSpittleById(spittle.getId()));

        spittleHbmDAO.deleteSpittle(spittle);
    }

    @Test
    public void getAll() {
        spittleHbmDAO.addSpittle(spittle);

        List<Spittle> spittles = spittleHbmDAO.getAll();

        assertNotNull(spittles);
        assertTrue(spittles.size() > 0);

        spittleHbmDAO.deleteSpittle(spittle);
    }

    @Test
    public void getLast() {

        Spittle spittle1 = new Spittle("spittle1", new Date());
        Spittle spittle2 = new Spittle("spittle2", new Date());

        spittle1.setSpitter(spitter);
        spittle2.setSpitter(spitter);

        spittleHbmDAO.addSpittle(spittle);
        spittleHbmDAO.addSpittle(spittle1);
        spittleHbmDAO.addSpittle(spittle2);

        List<Spittle> spittles = spittleHbmDAO.getLast(2);

        assertNotNull(spittles);
        assertTrue(spittles.size() == 2);
        assertEquals(spittle1, spittles.get(1));
        assertEquals(spittle2, spittles.get(0));

        spittleHbmDAO.deleteSpittle(spittle);
        spittleHbmDAO.deleteSpittle(spittle1);
        spittleHbmDAO.deleteSpittle(spittle2);
    }
}