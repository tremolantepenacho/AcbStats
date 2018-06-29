package org.hecarap.acbstats.controlador;

import java.util.Date;
import java.util.List;

import org.hecarap.acbstats.modelo.Jugador;
import org.hecarap.acbstats.modelo.Partido;
import org.hecarap.acbstats.modelo.PartidoJugador;
import org.hecarap.acbstats.modelo.TemporadaJugador;
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

public static void insertaTemporadaJugador(TemporadaJugador nuevo) {
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
	
	public static void insertaTemporada(String enlaceTemporada) {
		ScrapPaginaWeb prueba=new ScrapPaginaWeb(enlaceTemporada);
     	ScrapTemporada tempScrap=new ScrapTemporada(prueba.getHtmlDocument());	
     	tempScrap.obtenPartidos();
     	creaTemporadaJugador(tempScrap.obtenNumTemporada());
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
		try {
            HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            return (Partido)session.get(Partido.class, id);
         } finally {
             HibernateUtil.closeSessionAndUnbindFromThread();
         }    	        
	}
	
	public static void creaTemporadaJugador(int temporada) {
		try {
			HibernateUtil.openSessionAndBindToThread();
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            String consulta="SELECT count(pj.jugador), pj.jugador.id, sum(pj.minutos), sum(pj.segundos), sum(pj.puntos), sum(pj.intentosUno), sum(pj.canastasUno),";
            consulta+="sum(pj.intentosDos), sum(pj.canastasDos),sum(pj.intentosTres), sum(pj.canastasTres), sum(pj.rebotesOfensivos), sum(pj.rebotesDefensivos),";
            consulta+="sum(pj.asistencias), sum(pj.robos), sum(pj.perdidas), sum(pj.taponesFavor), sum(pj.taponesContra), sum(pj.faltasFavor), sum(pj.faltasContra), sum(pj.valoracion)";
            consulta+="FROM PartidoJugador pj GROUP BY pj.jugador";
            Query query = session.createQuery(consulta);
    		List<Object[]> partidosJugadores = query.list();
    		for (Object[] partidoJugador : partidosJugadores) {
    		    //System.out.println("Partidos="+partidoJugador[0]+" "+partidoJugador[1]+" Minutos="+partidoJugador[2]+" Segundos="+partidoJugador[3]+" "+TemporadaJugador.calculaMinutosMedios(((Long)partidoJugador[2]).intValue(), ((Long)partidoJugador[3]).intValue(),((Long) partidoJugador[0]).intValue())+":"+TemporadaJugador.calculaSegundosMedios(((Long)partidoJugador[2]).intValue(), ((Long)partidoJugador[3]).intValue(), ((Long)partidoJugador[0]).intValue()));
    			TemporadaJugador nuevo=obtenTemporadaJugador(partidoJugador);
    			System.out.println(nuevo);
    			insertaTemporadaJugador(nuevo);
    			
    			
    		 }
		} finally {
            HibernateUtil.closeSessionAndUnbindFromThread();
        }   
		
	}
	
	private static TemporadaJugador obtenTemporadaJugador(Object[] datos) {
		
		int partidos=((Long) datos[0]).intValue();
		String idJugador=datos[1].toString();
		int minutos=((Long) datos[2]).intValue();
		int segundos=((Long) datos[3]).intValue();
		int puntos=((Long) datos[4]).intValue();
		int intentosUno=((Long) datos[5]).intValue();
		int canastasUno=((Long) datos[6]).intValue();
		int intentosDos=((Long) datos[7]).intValue();
		int canastasDos=((Long) datos[8]).intValue();
		int intentosTres=((Long) datos[9]).intValue();
		int canastasTres=((Long) datos[10]).intValue();
		int rebotesOfensivos=((Long) datos[11]).intValue();
		int rebotesDefensivos=((Long) datos[12]).intValue();
		int asistencias=((Long) datos[13]).intValue();
		int robos=((Long) datos[14]).intValue();
		int perdidas=((Long) datos[15]).intValue();
		int taponesFavor=((Long) datos[16]).intValue();
		int taponesContra=((Long) datos[17]).intValue();
		int faltasFavor=((Long) datos[18]).intValue();
		int faltasContra=((Long) datos[19]).intValue();
		int valoracion=((Long) datos[20]).intValue();
		
		minutos=calculaMinutosAcumulados(minutos,segundos);
		segundos=calculaSegundosAcumulados(segundos);
		return new  TemporadaJugador(idJugador, partidos, minutos, segundos, puntos, intentosUno,canastasUno, intentosDos, canastasDos, intentosTres, canastasTres, rebotesOfensivos,
				rebotesDefensivos, asistencias, robos, perdidas, taponesFavor, taponesContra, faltasFavor, faltasContra, valoracion,Controlador.obtenJugador(idJugador));
				
	}

	private static int calculaMinutosAcumulados(int minutos, int segundos) {
		return minutos+segundos/60;
	}
	private static int calculaSegundosAcumulados(int segundos) {
		return segundos%60;
	}
}
