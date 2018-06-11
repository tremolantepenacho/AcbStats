package org.hecarap.acbstats.modelo;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Partido")
public class Partido {

	@Id
	@Column(name="Id")
	private String id;
	
	@Column(name="temporada")
	private int temporada;
	
	@Column(name="jornada")
	private int jornada;
	
	@Column(name="fecha")
	private Date fecha;
	
	@Column(name="hora")
	private Time hora;
	
	@Column(name="pabellon")
	private String pabellon;
	
	@Column(name="publico")
	private int publico;
	
	@Column(name="local")
	private String local;
	
	@Column(name="visitante")
	private String visitante;
	
	@Column(name="puntosLocal")
	private int puntosLocal;
	
	@Column(name="puntosVisitante")
	private int puntosVisitante;
	
	@OneToMany(mappedBy="partido",cascade= CascadeType.ALL)
	private Set<PartidoJugador> jugadores;
	
	public Partido() {
	}
	
	public Partido(String id,String local, int puntosLocal, String visitante, int puntosVisitante, int temporada,int jornada, Date fecha, Time hora, String pabellon, int publico) {
		this.id=id;
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Set<PartidoJugador> getJugadores() {
		return jugadores;
	}
	public void setJugadores(Set<PartidoJugador> jugadores) {
		this.jugadores = jugadores;
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
