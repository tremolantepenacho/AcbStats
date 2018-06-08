package org.hecarap.acbstats.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PartidoJugador")
public class PartidoJugador implements Serializable {

	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="idJugador",unique=true)
	private String idJugador;
	
	@Column(name="minutos")
	private Date minutos;
	
	@Column(name="puntos")
	private int puntos;
	
	@Column(name="intentosUno")
	private int intentosUno;
	
	@Column(name="canastasUno")
	private int canastasUno;
	
	@Column(name="intentosDos")
	private int intentosDos;
	
	@Column(name="canastasDps")
	private int canastasDos;
	
	@Column(name="intentosTres")
	private int intentosTres;
	
	@Column(name="canastasTres")
	private int canastasTres;
	
	@Column(name="rebotesOfensivos")
	private int rebotesOfensivos;
	
	@Column(name="rebotesDefensivos")
	private int rebotesDefensivos;
	
	@Column(name="rebotes")
	private int rebotes;
	
	@Column(name="asistencias")
	private int asistencias;
	
	@Column(name="robos")
	private int robos;
	
	@Column(name="perdidas")
	private int perdidas;
	
	@Column(name="taponesFavor")
	private int taponesFavor;
	
	@Column(name="taponesContra")
	private int taponesContra;
	
	@Column(name="faltasFavor")
	private int faltasFavor;
	
	@Column(name="faltasContra")
	private int faltasContra;
	
	@Column(name="valoracion")
	private int valoracion;
	
	@ManyToOne
	@JoinColumn(name="jugador")
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumn(name="partido")
	private Partido partido;
	
		
	public PartidoJugador() {
		super();
	}
	public PartidoJugador(String idJugador, Date minutos, int puntos, int intentosUno, int canastasUno, int intentosDos,
			int canastasDos, int intentosTres, int canastasTres, int rebotesOfensivos, int rebotesDefensivos,
			int asistencias, int robos, int perdidas, int taponesFavor, int taponesContra, int faltasFavor,
			int faltasContra, int valoracion) {
		super();
		this.idJugador = idJugador;
		this.minutos = minutos;
		this.puntos = puntos;
		this.intentosUno = intentosUno;
		this.canastasUno = canastasUno;
		this.intentosDos = intentosDos;
		this.canastasDos = canastasDos;
		this.intentosTres = intentosTres;
		this.canastasTres = canastasTres;
		this.rebotesOfensivos = rebotesOfensivos;
		this.rebotesDefensivos = rebotesDefensivos;
		this.asistencias = asistencias;
		this.robos = robos;
		this.perdidas = perdidas;
		this.taponesFavor = taponesFavor;
		this.taponesContra = taponesContra;
		this.faltasFavor = faltasFavor;
		this.faltasContra = faltasContra;
		this.valoracion = valoracion;
	}
	public String getJugador() {
		return idJugador;
	}
	public void setJugador(String jugador) {
		this.idJugador = jugador;
	}
	public Date getMinutos() {
		return minutos;
	}
	public void setMinutos(Date minutos) {
		this.minutos = minutos;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getIntentosUno() {
		return intentosUno;
	}
	public void setIntentosUno(int intentosUno) {
		this.intentosUno = intentosUno;
	}
	public int getCanastasUno() {
		return canastasUno;
	}
	public void setCanastasUno(int canastasUno) {
		this.canastasUno = canastasUno;
	}
	public int getIntentosDos() {
		return intentosDos;
	}
	public void setIntentosDos(int intentosDos) {
		this.intentosDos = intentosDos;
	}
	public int getCanastasDos() {
		return canastasDos;
	}
	public void setCanastasDos(int canastasDos) {
		this.canastasDos = canastasDos;
	}
	public int getIntentosTres() {
		return intentosTres;
	}
	public void setIntentosTres(int intentosTres) {
		this.intentosTres = intentosTres;
	}
	public int getCanastasTres() {
		return canastasTres;
	}
	public void setCanastasTres(int canastasTres) {
		this.canastasTres = canastasTres;
	}
	public int getRebotesOfensivos() {
		return rebotesOfensivos;
	}
	public void setRebotesOfensivos(int rebotesOfensivos) {
		this.rebotesOfensivos = rebotesOfensivos;
	}
	public int getRebotesDefensivos() {
		return rebotesDefensivos;
	}
	public void setRebotesDefensivos(int rebotesDefensivos) {
		this.rebotesDefensivos = rebotesDefensivos;
	}
	public int getRebotes() {
		return rebotes;
	}
	public void setRebotes(int rebotes) {
		this.rebotes = rebotes;
	}
	public int getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(int asistencias) {
		this.asistencias = asistencias;
	}
	public int getRobos() {
		return robos;
	}
	public void setRobos(int robos) {
		this.robos = robos;
	}
	public int getPerdidas() {
		return perdidas;
	}
	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}
	public int getTaponesFavor() {
		return taponesFavor;
	}
	public void setTaponesFavor(int taponesFavor) {
		this.taponesFavor = taponesFavor;
	}
	public int getTaponesContra() {
		return taponesContra;
	}
	public void setTaponesContra(int taponesContra) {
		this.taponesContra = taponesContra;
	}
	public int getFaltasFavor() {
		return faltasFavor;
	}
	public void setFaltasFavor(int faltasFavor) {
		this.faltasFavor = faltasFavor;
	}
	public int getFaltasContra() {
		return faltasContra;
	}
	public void setFaltasContra(int faltasContra) {
		this.faltasContra = faltasContra;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public String toString() {
		String aux="";
		aux+="********************************************************\n";
		aux+="*  Id="+idJugador+"\n";
		aux+="*  Minutos="+minutos+"\n";
		aux+="*  Puntos="+puntos+"\n";
		aux+="*  T1="+intentosUno+"\n";
		aux+="*  C1="+canastasUno+"\n";
		aux+="*  T2="+intentosDos+"\n";
		aux+="*  C2="+canastasDos+"\n";
		aux+="*  T3="+intentosTres+"\n";
		aux+="*  C3="+canastasTres+"\n";
		aux+="*  Ofensivos="+rebotesOfensivos+"\n";
		aux+="*  Defensivos="+rebotesDefensivos+"\n";
		aux+="*  Rebotes="+rebotes+"\n";
		aux+="*  Asistencias="+asistencias+"\n";
		aux+="*  Robos="+robos+"\n";
		aux+="*  Pérdidas="+perdidas+"\n";
		aux+="*  Tapones a favor="+taponesFavor+"\n";
		aux+="*  Tapones en contra="+taponesContra+"\n";
		aux+="*  Faltas cometidas="+faltasFavor+"\n";
		aux+="*  Faltas recibidas="+faltasContra+"\n";
		aux+="*  Valoración="+valoracion+"\n";
		return aux;
	
		
	}
	
	
}
