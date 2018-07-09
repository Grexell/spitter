package by.dima.dao;

import by.dima.model.entity.Spitter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static org.junit.Assert.*;

public class SpitterHbmDAOTest {
    private static SessionFactory sessionFactory;
    private static SpitterHbmDAO spitterHbmDAO;
    private static Spitter spitter;

    @BeforeClass
    public static void setUpclass() throws Exception {
        sessionFactory = new Configuration().configure().buildSessionFactory();
//        spitterHbmDAO = new ClassPathXmlApplicationContext("dao-context.xml").getBean("spitterHbmDAO", SpitterHbmDAO.class);

        spitterHbmDAO = new SpitterHbmDAO();
        spitterHbmDAO.setSessionFactory(sessionFactory);

        spitter = new Spitter();

        spitter.setEmail("demesh.dima.dd@gmail.com");
        spitter.setUsername("dima");
        spitter.setPassword("123456");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {

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
    public void addSpitter() {
        int amount = spitterHbmDAO.getAll().size();
        spitterHbmDAO.addSpitter(spitter);
        int newAmount = spitterHbmDAO.getAll().size();

        assertEquals(amount + 1, newAmount);

        spitterHbmDAO.deleteSpitter(spitter);
    }

    @Test
    public void updateSpitter() {
        spitterHbmDAO.addSpitter(spitter);

        spitter.setPassword(spitter.getPassword() + "2");
        spitterHbmDAO.updateSpitter(spitter);

        assertEquals(spitter, spitterHbmDAO.getSpitterById(spitter.getId()));

        spitterHbmDAO.deleteSpitter(spitter);
    }

    @Test
    public void deleteSpitter() {
        spitterHbmDAO.addSpitter(spitter);
        int amount = spitterHbmDAO.getAll().size();
        spitterHbmDAO.deleteSpitter(spitter);
        int newAmount = spitterHbmDAO.getAll().size();

        assertEquals(amount - 1, newAmount);
    }

    @Test
    public void getSpitterById() {
        spitterHbmDAO.addSpitter(spitter);

        assertEquals(spitter, spitterHbmDAO.getSpitterById(spitter.getId()));

        spitterHbmDAO.deleteSpitter(spitter);
    }

    @Test
    public void getSpitterByUsername() {
        spitterHbmDAO.addSpitter(spitter);

        assertEquals(spitter, spitterHbmDAO.getSpitterByUsername(spitter.getUsername()));

        spitterHbmDAO.deleteSpitter(spitter);
    }

    @Test
    public void getAll() {
        spitterHbmDAO.addSpitter(spitter);

        List<Spitter> spitters = spitterHbmDAO.getAll();

        assertNotNull(spitters);
        assertTrue(spitters.size() > 0);

        spitterHbmDAO.deleteSpitter(spitter);
    }
}