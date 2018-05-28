package org.hecarap.acbstats.modelo;

import java.sql.Time;
import java.util.Date;

public class Partido {

	private int temporada;
	private int jornada;
	private Date fecha;
	private Time hora;
	private String pabellon;
	private int publico;
	private String local;
	private String visitante;
	private int puntosLocal;
	private int puntosVisitante;
	
	public Partido(String local, int puntosLocal, String visitante, int puntosVisitante, int temporada,int jornada, Date fecha, Time hora, String pabellon, int publico) {
		this.local=local;
		this.visitante=visitante;
		this.puntosLocal=puntosLocal;
		this.puntosVisitante=puntosVisitante;
		this.temporada=temporada;
		this.jornada = jornada;
		this.fecha = fecha;
		this.hora = hora;
		this.pabellon = pabellon;
		this.publico = publico;
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
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
	
	public String toString() {
		String aux="";
		aux+="********************************************************\n";
		aux+="*  Local:"+local+" "+puntosLocal+"\n";
		aux+="*  Visitante:"+visitante+" "+puntosVisitante+"\n";
		aux+="*  Temporada:"+temporada+"\n";
		aux+="*  Jornada:"+jornada+"\n";
		aux+="*  Fecha:"+fecha+"\n";
		aux+="*  Hora:"+hora+"\n";
		aux+="*  Pabellón:"+pabellon+"\n";
		aux+="*  Espectadores:"+publico+"\n";
		aux+="********************************************************\n";
		return aux;
	}
	
	
}
