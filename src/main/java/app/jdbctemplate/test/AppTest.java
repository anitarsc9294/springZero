package app.jdbctemplate.test;

import app.jdbctemplate.dao.LocalDAO;
import app.jdbctemplate.model.Local;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        // AppTest.saveLocal();
        AppTest.getAll();
        // AppTest.getLocal(new Local(13));
    }

    public static void saveLocal() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");

        Local local = new Local();
        local.setDescripcion("Local Chosica");
        local.setDireccion("Av. Arriola 3455");
        local.setEstado(1);
        local.setTelefono("01-123454");

        localDAO.save(local);
    }

    public static void getLocal(Local local) {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");

        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local localFull = localDAO.get(local);
        System.out.println(localFull.getDescripcion() + " " + localFull.getTelefono());
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc_database.xml");

        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        List<Local> locales = localDAO.list();
        for (Local local : locales) {
            System.out.println(local.getDescripcion() + " " + local.getTelefono());
        }
    }
    
    

}
