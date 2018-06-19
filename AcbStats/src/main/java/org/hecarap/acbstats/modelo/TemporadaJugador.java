package org.hecarap.acbstats.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TemporadaJugador")
public class TemporadaJugador implements Serializable{
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="idJugador")
	private String idJugador;
	
	@Column(name="partidos")
	private int partidos;
	
	@Column(name="minutos")
	private Date minutos;
	
	@Column(name="minutosPorPartido")
	private double minutosPorPartido;
	
	@Column(name="puntos")
	private int puntos;
	
	@Column(name="puntosPorPartido")
	private double puntosPorPartido;
	
	@Column(name="intentosUno")
	private int intentosUno;
	
	@Column(name="intentosUnoPorPartido")
	private double intentosUnoPorPartido;
	
	@Column(name="canastasUno")
	private int canastasUno;
	
	@Column(name="canastasUnoPorPartido")
	private double canastasUnoPorPartido;
	
	@Column(name="intentosDos")
	private int intentosDos;
	
	@Column(name="intentosDosPorPartido")
	private double intentosDosPorPartido;
	
	@Column(name="canastasDos")
	private int canastasDos;
	
	@Column(name="canastasDosPorPartido")
	private double canastasDosPorPartido;
	
	@Column(name="intentosTres")
	private int intentosTres;
	
	@Column(name="intentosTresPorPartido")
	private double intentosTresPorPartido;
	
	@Column(name="canastasTres")
	private int canastasTres;
	
	@Column(name="canastasTresPorPartido")
	private double canastasTresPorPartido;
	
	@Column(name="rebotesOfensivos")
	private int rebotesOfensivos;
	
	@Column(name="rebotesOfensivosPorPartido")
	private double rebotesOfensivosPorPartido;
	
	@Column(name="rebotesDefensivos")
	private int rebotesDefensivos;
	
	@Column(name="rebotesDefensivosPorPartido")
	private double rebotesDefensivosPorPartido;
	
	@Column(name="rebotes")
	private int rebotes;
	
	@Column(name="rebotesPorPartido")
	private double rebotesPorPartido;
	
	@Column(name="asistencias")
	private int asistencias;
	
	@Column(name="asistenciasPorPartido")
	private double asistenciasPorPartido;
	
	@Column(name="robos")
	private int robos;
	
	@Column(name="robosPorPartido")
	private double robosPorPartido;
	
	@Column(name="perdidas")
	private int perdidas;
	
	@Column(name="perdidasPorPartido")
	private double perdidasPorPartido;
	
	@Column(name="taponesFavor")
	private int taponesFavor;
	
	@Column(name="taponesFavorPorPartido")
	private double taponesFavorPorPartido;
	
	@Column(name="taponesContra")
	private int taponesContra;
	
	@Column(name="taponesContraPorPartido")
	private double taponesContraPorPartido;
	
	@Column(name="faltasFavor")
	private int faltasFavor;
	
	@Column(name="faltasFavorPorPartido")
	private double faltasFavorPorPartido;
	
	@Column(name="faltasContra")
	private int faltasContra;
	
	@Column(name="faltasContraPorPartido")
	private double faltasContraPorPartido;
	
	@Column(name="valoracion")
	private int valoracion;
	
	@Column(name="valoracionPorPartido")
	private double valoracionPorPartido;
	
	@ManyToOne
	@JoinColumn(name="jugador")
	private Jugador jugador;	
	
	
		
	public TemporadaJugador() {
	}


	public TemporadaJugador(String idJugador, int partidos, Date minutos, int puntos, int intentosUno, int canastasUno,
			int intentosDos, int canastasDos, int intentosTres, int canastasTres, int rebotesOfensivos,
			int rebotesDefensivos, int rebotes, int asistencias, int robos, int perdidas, int taponesFavor,
			int taponesContra, int faltasFavor, int faltasContra, int valoracion, Jugador jugador) {
		super();
		this.idJugador = idJugador;
		this.partidos = partidos;
		this.minutos = minutos;
		this.minutosPorPartido=minutos.getMinutes()/partidos;
		this.puntos = puntos;
		this.puntosPorPartido=puntos/partidos;
		this.intentosUno = intentosUno;
		this.intentosUnoPorPartido=intentosUno/partidos;
		this.canastasUno = canastasUno;
		this.canastasUno=canastasUno/partidos;
		this.intentosDos = intentosDos;
		this.intentosDosPorPartido=intentosDos/partidos;
		this.canastasDos = canastasDos;
		this.canastasDosPorPartido=canastasDos/partidos;
		this.intentosTres = intentosTres;
		this.intentosTresPorPartido=intentosTres/partidos;
		this.canastasTres = canastasTres;
		this.canastasTresPorPartido=canastasTres/partidos;
		this.rebotesOfensivos = rebotesOfensivos;
		this.rebotesOfensivosPorPartido=rebotesOfensivos/partidos;
		this.rebotesDefensivos = rebotesDefensivos;
		this.rebotesDefensivosPorPartido=rebotesDefensivos/partidos;
		this.rebotes = rebotes;
		this.rebotesPorPartido=rebotes/partidos;
		this.asistencias = asistencias;
		this.asistenciasPorPartido=asistencias/partidos;
		this.robos = robos;
		this.robosPorPartido=robos/partidos;
		this.perdidas = perdidas;
		this.perdidasPorPartido=perdidas/partidos;
		this.taponesFavor = taponesFavor;
		this.taponesFavorPorPartido=taponesFavor/partidos;
		this.taponesContra = taponesContra;
		this.taponesContraPorPartido=taponesContra/partidos;
		this.faltasFavor = faltasFavor;
		this.faltasFavorPorPartido=faltasFavor/partidos;
		this.faltasContra = faltasContra;
		this.faltasContraPorPartido=faltasContra/partidos;
		this.valoracion = valoracion;
		this.valoracionPorPartido=valoracion/partidos;
		this.jugador = jugador;
	}
	
	

}
