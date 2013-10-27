package app.orm.test;

import app.orm.dao.CampoDAO;
import app.orm.dao.LocalDAO;
import app.orm.model.Campo;
import app.orm.model.Local;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    public static void main(String[] args) {
        //AppTest.getAll();
        //AppTest.addCampo();
        AppTest.listCampo();
    }

    public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("h_database.xml");

        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        List<Local> locales = localDAO.list();
        for (Local local : locales) {
            System.out.println(local.getDescripcion() + " " + local.getTelefono());
        }
    }
    
    public static void addCampo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("h_database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");
        
        
        Local local = localDAO.get(new Local(13l));
        
        Campo campo = new Campo();
        campo.setCostoHora(12D);
        campo.setDescripcion("Campod de Basket");
        campo.setLocal(local);
        campoDAO.save(campo);
        
        System.out.println(campo.getId() +" " + campo.getDescripcion());
    }
    
    public static void listCampo(){
        ApplicationContext context = new ClassPathXmlApplicationContext("h_database.xml");
        CampoDAO campoDAO = (CampoDAO) context.getBean("campoDAO");
        
        
        Campo campo = campoDAO.get(new Campo(1l));
        
        System.out.println(campo.getId() +" " + campo.getDescripcion()
                + " "+ campo.getLocal().getDescripcion());
    }
    
    

}
