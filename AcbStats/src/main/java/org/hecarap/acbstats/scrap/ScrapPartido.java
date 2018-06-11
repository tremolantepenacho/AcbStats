package org.hecarap.acbstats.scrap;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.hecarap.acbstats.modelo.Partido;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class ScrapPartido {
	
	private Document web;
	private String id;
	private int temporada;
	private int jornada;
	private Date fecha;
	private Time hora;
	private String pabellon;
	private int publico;
	private String datosPartido;
	private String equipoLocal;
	private String equipoVisitante;
	private int puntosLocal;
	private int puntosVisitante;
	
	public ScrapPartido(Document partido) {
		this.web=partido;
		String[] aux=partido.location().split("LACB");
		this.id=aux[1].substring(0,aux[1].indexOf('.'));
		String temp=aux[1].substring(0,2);
		temporada=Integer.parseInt(temp);
	}	
	
	
	
	public String getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(String local) {
		this.equipoLocal = local;
	}
	public String getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(String visitante) {
		this.equipoVisitante = visitante;
	}
	public int getPuntosLocal() {
		return puntosLocal;
	}
	public void setPuntosLocal(int puntosLocal) {
		this.puntosLocal = puntosLocal;
	}
	public int getPuntosVisitante() {
		return puntosVisitante;
	}
	public void setPuntosVisitante(int puntosVisitante) {
		this.puntosVisitante = puntosVisitante;
	}
	public int getTemporada() {
		return temporada;
	}
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	public int getJornada() {
		return jornada;
	}
	public void setJornada(int jornada) {
		this.jornada = jornada;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getPabellon() {
		return pabellon;
	}
	public void setPabellon(String pabellon) {
		this.pabellon = pabellon;
	}
	public int getPublico() {
		return publico;
	}
	public void setPublico(int publico) {
		this.publico = publico;
	}
	
	
	public Partido obtenPartido() {
			
				
		datosPartido=obtenDatosPartido();
		jornada=obtenJornada(datosPartido);
		fecha=obtenFechaPartido(datosPartido);
		hora=obtenHoraPartido(datosPartido);
		pabellon=obtenNombrePabellon(datosPartido);
		publico=obtenPublicoAsistente(datosPartido);
		equipoLocal=obtenLocal();
		equipoVisitante=obtenVisitante();
		puntosLocal=obtenPuntosLocal();
		puntosVisitante=obtenPuntosVisitante();
		System.out.println("************jornada"+jornada);
		
		return new Partido(id,equipoLocal,puntosLocal,equipoVisitante,puntosVisitante,temporada,jornada,fecha,hora,pabellon,publico);
	}
	
	private String obtenLocal() {
		String local=null;
		Elements entradas = web.getElementsByClass("estverdel");
		Element datos=entradas.get(0);
		for (Node child : datos.childNodes()) {
		    if (child instanceof TextNode) {
		        String equipo=((TextNode)child).text();
		        local=equipo.replaceAll("[^\\sA-Za-z]", "");
		        }
		}
		
		
		return local.trim();
		
	}
	
	private int obtenPuntosLocal() {
		String local=null;
		Elements entradas = web.getElementsByClass("estverdel");
		Element datos=entradas.get(0);
		for (Node child : datos.childNodes()) {
		    if (child instanceof TextNode) {
		        String equipo=((TextNode)child).text();
		        local=equipo.replaceAll("[^0-9]*", "");
		        }
		}
		
		
		return Integer.parseInt(local);
		
	}
	
	private int obtenPuntosVisitante() {
		String visitante=null;
		Elements entradas = web.getElementsByClass("estverdel");		
		Element datos=entradas.get(1);
		for (Node child : datos.childNodes()) {
		    if (child instanceof TextNode) {
		        String equipo=((TextNode)child).text();
		        visitante=equipo.replaceAll("[^0-9]", "");
		        }
		}
		
		
		return Integer.parseInt(visitante);
	}
	
	private String obtenVisitante() {
		String visitante=null;
		Elements entradas = web.getElementsByClass("estverdel");
		
		Element datos=entradas.get(1);
		for (Node child : datos.childNodes()) {
		    if (child instanceof TextNode) {
		        String equipo=((TextNode)child).text();
		        visitante=equipo.replaceAll("[^\\sA-Za-z]", "");
		        }
		}
		
		
		return visitante.trim();
	}
	private String obtenDatosPartido() {
		
		String datos=null;
		Elements entradas = web.getElementsByClass("estnegro");
		
		for (Element elem : entradas) {
					List<Node> nodos=elem.childNodes();
					Node nodo=nodos.get(1);
					for (Node child : nodo.childNodes()) {
					    if (child instanceof TextNode) {
					        datos=((TextNode)child).text();
					        }
					}
				}
		
		return datos;
		
	}
	
	private int obtenJornada(String datosPartido) {
		int res=0;
		String[] aux=datosPartido.split("\\|");
		String[] temp=aux[0].split("J");
		res=Integer.parseInt(temp[1].trim());
		return res;
		}
	
	@SuppressWarnings("deprecation")
	private Date obtenFechaPartido(String datosPartido) {
		String[] aux=datosPartido.split("\\|");
		String[] fechas= aux[1].split("/");
		return new Date(Integer.parseInt(fechas[2].trim())-1900,Integer.parseInt(fechas[1].trim())-1,Integer.parseInt(fechas[0].trim().trim()));
		
	}
	
	@SuppressWarnings("deprecation")
	private Time obtenHoraPartido(String datosPartido) {
		String[] aux=datosPartido.split("\\|");
		String[] horas= (aux[2].trim()).split(":");
		return new Time(Integer.parseInt(horas[0]),Integer.parseInt(horas[1]),0);
		
	}
	private String obtenNombrePabellon(String datosPartido) {
		String[] aux=datosPartido.split("\\|");
		return aux[3].trim();
	}
	private int obtenPublicoAsistente(String datosPartido) {
		String[] aux=datosPartido.split("\\|");
		String[] temp=aux[4].split(":");
		return Integer.parseInt(temp[1].trim());		
	}
}
