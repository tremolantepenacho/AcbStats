package org.hecarap.acbstats.controlador;

import org.hecarap.acbstats.modelo.Jugador;
import org.hecarap.acbstats.modelo.Partido;
import org.hecarap.acbstats.modelo.PartidoJugador;
import org.hecarap.acbstats.scrap.ScrapPaginaWeb;
import org.hecarap.acbstats.scrap.ScrapPartido;
import org.hecarap.acbstats.scrap.ScrapPartidoJugador;
import org.hecarap.hibernate.HibernateUtil;
import org.hibernate.Session;

public class Controlador {

	public static void inicia() {
		HibernateUtil.buildSessionFactory();
	}
	public static void finaliza() {
		HibernateUtil.closeSessionFactory();
	}
	public static void insertaJugador(Jugador nuevo) {
		
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
         	session.save(nuevo);
         	session.getTransaction().commit();
         	System.out.println("Insertado el jugador:");
    		System.out.println(nuevo);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }        
	}
	
	public static void insertaPartido(Partido nuevo) {
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
         	session.save(nuevo);
         	session.getTransaction().commit();
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }    	                  
	}
	
public static void insertaPartidoJugador(PartidoJugador nuevo) {
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
         	session.save(nuevo);
         	session.getTransaction().commit();
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }    	         
    }
	
		
	public static void insertaPartido(String enlacePartido) {
		ScrapPaginaWeb prueba=new ScrapPaginaWeb(enlacePartido);
     	ScrapPartido partScrap=new ScrapPartido(prueba.getHtmlDocument());
     	Partido partidoNuevo=partScrap.obtenPartido();
     	Controlador.insertaPartido(partidoNuevo);
     	
	}
	
	public static void creaEsquema() {
		new org.hibernate.tool.hbm2ddl.SchemaExport(HibernateUtil.getConfiguration()).setOutputFile("script.sql").setDelimiter(";").create(true, true);
	}
	
	public static void insertaJornada(String enlaceJornada) {
		
		Controlador.insertaPartido("http://www.acb.com/fichas/LACB62001.php");
		ScrapPaginaWeb prueba=new ScrapPaginaWeb("http://www.acb.com/fichas/LACB62001.php");
     	ScrapPartidoJugador partidoJugador=new ScrapPartidoJugador(prueba.getHtmlDocument());
     	partidoJugador.obtenPartidosJugadores();
		
		
	}
}


