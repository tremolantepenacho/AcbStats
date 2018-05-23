package org.hecarap.acbstats;


import org.hecarap.acbstats.modelo.Jugador;
import org.hecarap.acbstats.scrap.*;
import org.hecarap.hibernate.HibernateUtil;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args ){
    	
    	
     	
    	new org.hibernate.tool.hbm2ddl.SchemaExport(HibernateUtil.getConfiguration()).setOutputFile("script.sql").setDelimiter(";").create(true, true);
    	HibernateUtil.buildSessionFactory();
    	
    	         try {
    	            HibernateUtil.openSessionAndBindToThread();
    	
    	            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    	            ScrapPaginaWeb prueba=new ScrapPaginaWeb("http://www.acb.com/jugador.php?id=217");
    	         	ScrapJugador djublevic=new ScrapJugador(prueba.getHtmlDocument());
    	         	Jugador dubi= djublevic.getJugador();
    	            session.beginTransaction();
    	         	session.save(dubi);
    	         	session.getTransaction().commit();
    	         } finally {
    	             HibernateUtil.closeSessionAndUnbindFromThread();
    	         }    	         
    	         
    	         HibernateUtil.closeSessionFactory();
    	     }
    
}
