package org.hecarap.acbstats.controlador;

import java.util.List;

import org.hecarap.acbstats.modelo.Jugador;
import org.hecarap.acbstats.modelo.Partido;
import org.hecarap.acbstats.modelo.PartidoJugador;
import org.hecarap.acbstats.scrap.ScrapPaginaWeb;
import org.hecarap.acbstats.scrap.ScrapPartido;
import org.hecarap.acbstats.scrap.ScrapPartidoJugador;
import org.hecarap.acbstats.scrap.ScrapTemporada;
import org.hecarap.hibernate.HibernateUtil;
import org.hibernate.Query;
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
	
	public static void insertaJornada(String enlaceTemporada) {
		ScrapPaginaWeb prueba=new ScrapPaginaWeb(enlaceTemporada);
     	ScrapTemporada tempScrap=new ScrapTemporada(prueba.getHtmlDocument());
     	tempScrap.obtenPartidos();
					
	}
	
	public static boolean existeJugador(String id) {
		if (id==null) return false;
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Query query = session.createQuery("SELECT j FROM Jugador j WHERE id='"+id+"'");
            List<Jugador> resultado = query.list();
            HibernateUtil.closeSessionAndUnbindFromThread();
            return !resultado.isEmpty();          
    		
	}
	
	public static Jugador obtenJugador(String id) {
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
             return (Jugador)session.get(Jugador.class, id);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }    	        
	}
	public static Partido obtenPartido(String id) {
		System.out.println("______________________"+id);
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            System.out.println("!!!!!!!!!!!!!!!!!!!"+((Partido)session.get(Partido.class, id)).getId());
            return (Partido)session.get(Partido.class, id);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }    	        
	}
	
}


