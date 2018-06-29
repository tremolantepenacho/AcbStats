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
	private int minutos;
	
	@Column(name="segundos")
	private int segundos;
	
	@Column(name="minutosPorPartido")
	private float minutosPorPartido;
	
	@Column(name="segundosPorPartido")
	private float segundosPorPartido;
	
	@Column(name="puntos")
	private int puntos;
	
	@Column(name="puntosPorPartido")
	private float puntosPorPartido;
	
	@Column(name="intentosUno")
	private int intentosUno;
	
	@Column(name="intentosUnoPorPartido")
	private float intentosUnoPorPartido;
	
	@Column(name="canastasUno")
	private int canastasUno;
	
	@Column(name="canastasUnoPorPartido")
	private float canastasUnoPorPartido;
	
	@Column(name="intentosDos")
	private int intentosDos;
	
	@Column(name="intentosDosPorPartido")
	private float intentosDosPorPartido;
	
	@Column(name="canastasDos")
	private int canastasDos;
	
	@Column(name="canastasDosPorPartido")
	private float canastasDosPorPartido;
	
	@Column(name="intentosTres")
	private int intentosTres;
	
	@Column(name="intentosTresPorPartido")
	private float intentosTresPorPartido;
	
	@Column(name="canastasTres")
	private int canastasTres;
	
	@Column(name="canastasTresPorPartido")
	private float canastasTresPorPartido;
	
	@Column(name="rebotesOfensivos")
	private int rebotesOfensivos;
	
	@Column(name="rebotesOfensivosPorPartido")
	private float rebotesOfensivosPorPartido;
	
	@Column(name="rebotesDefensivos")
	private int rebotesDefensivos;
	
	@Column(name="rebotesDefensivosPorPartido")
	private float rebotesDefensivosPorPartido;
	
	@Column(name="rebotes")
	private int rebotes;
	
	@Column(name="rebotesPorPartido")
	private float rebotesPorPartido;
	
	@Column(name="asistencias")
	private int asistencias;
	
	@Column(name="asistenciasPorPartido")
	private float asistenciasPorPartido;
	
	@Column(name="robos")
	private int robos;
	
	@Column(name="robosPorPartido")
	private float robosPorPartido;
	
	@Column(name="perdidas")
	private int perdidas;
	
	@Column(name="perdidasPorPartido")
	private float perdidasPorPartido;
	
	@Column(name="taponesFavor")
	private int taponesFavor;
	
	@Column(name="taponesFavorPorPartido")
	private float taponesFavorPorPartido;
	
	@Column(name="taponesContra")
	private int taponesContra;
	
	@Column(name="taponesContraPorPartido")
	private float taponesContraPorPartido;
	
	@Column(name="faltasFavor")
	private int faltasFavor;
	
	@Column(name="faltasFavorPorPartido")
	private float faltasFavorPorPartido;
	
	@Column(name="faltasContra")
	private int faltasContra;
	
	@Column(name="faltasContraPorPartido")
	private float faltasContraPorPartido;
	
	@Column(name="valoracion")
	private int valoracion;
	
	@Column(name="valoracionPorPartido")
	private float valoracionPorPartido;
	
	@ManyToOne
	@JoinColumn(name="jugador")
	private Jugador jugador;	
	
	
		
	public TemporadaJugador() {
	}


	public TemporadaJugador(String idJugador, int partidos, int minutos, int segundos, int puntos, int intentosUno, int canastasUno,
			int intentosDos, int canastasDos, int intentosTres, int canastasTres, int rebotesOfensivos,
			int rebotesDefensivos, int asistencias, int robos, int perdidas, int taponesFavor,
			int taponesContra, int faltasFavor, int faltasContra, int valoracion, Jugador jugador) {
		super();
		this.idJugador = idJugador;
		this.partidos = partidos;
		this.minutos = minutos;
		this.minutosPorPartido=calculaMinutosMedios(minutos,segundos,partidos);
		this.segundos=segundos;
		this.segundosPorPartido=calculaSegundosMedios(minutos,segundos,partidos);
		this.puntos = puntos;
		this.puntosPorPartido=(float) (Math.round((float)puntos/partidos*100) / 100d);
		this.intentosUno = intentosUno;
		this.intentosUnoPorPartido=(float) (Math.round((float)intentosUno/partidos*100) / 100d);
		this.canastasUno = canastasUno;
		this.canastasUnoPorPartido=(float) (Math.round((float)canastasUno/partidos*100) / 100d);
		this.intentosDos = intentosDos;
		this.intentosDosPorPartido=(float) (Math.round((float)intentosDos/partidos*100) / 100d);
		this.canastasDos = canastasDos;
		this.canastasDosPorPartido=(float) (Math.round((float)canastasDos/partidos*100) / 100d);
		this.intentosTres = intentosTres;
		this.intentosTresPorPartido=(float) (Math.round((float)intentosTres/partidos*100) / 100d);
		this.canastasTres = canastasTres;
		this.canastasTresPorPartido=(float) (Math.round((float)canastasTres/partidos*100) / 100d);
		this.rebotesOfensivos = rebotesOfensivos;
		this.rebotesOfensivosPorPartido=(float) (Math.round((float)rebotesOfensivos/partidos*100) / 100d);
		this.rebotesDefensivos = rebotesDefensivos;
		this.rebotesDefensivosPorPartido=(float) (Math.round((float)rebotesDefensivos/partidos*100) / 100d);
		this.rebotes = rebotesOfensivos+rebotesDefensivos;
		this.rebotesPorPartido=(float) (Math.round((float)rebotes/partidos*100) / 100d);
		this.asistencias = asistencias;
		this.asistenciasPorPartido=(float) (Math.round((float)asistencias/partidos*100) / 100d);
		this.robos = robos;
		this.robosPorPartido=(float) (Math.round((float)robos/partidos*100) / 100d);
		this.perdidas = perdidas;
		this.perdidasPorPartido=(float) (Math.round((float)perdidas/partidos*100) / 100d);
		this.taponesFavor = taponesFavor;
		this.taponesFavorPorPartido=(float) (Math.round((float)taponesFavor/partidos*100) / 100d);
		this.taponesContra = taponesContra;
		this.taponesContraPorPartido=(float) (Math.round((float)taponesContra/partidos*100) / 100d);
		this.faltasFavor = faltasFavor;
		this.faltasFavorPorPartido=(float) (Math.round((float)faltasFavor/partidos*100) / 100d);
		this.faltasContra = faltasContra;
		this.faltasContraPorPartido=(float) (Math.round((float)faltasContra/partidos*100) / 100d);
		this.valoracion = valoracion;
		this.valoracionPorPartido=(float) (Math.round((float)valoracion/partidos*100) / 100d);
		this.jugador = jugador;
	}
	
	
	
	@Override
	public String toString() {
		return(jugador.getNombre()+" "+puntosPorPartido+" "+partidos);
	}


	/**
	 * Calcula la cantidad media de minutos por partido del jugador en una temporada
	 * @param minutos Minutos totales en la temporada del jugador
	 * @param segundos Segundos totales en la temporada del jugador
	 * @param partidos Partidos totales en la temporada del jugador
	 * @return
	 */
	public static int calculaMinutosMedios(int minutos, int segundos, int partidos) {
		try {
			int segundosTotalesMedios=(minutos*60+segundos)/partidos;
			return (segundosTotalesMedios-segundosTotalesMedios%60)/60;
		} catch (ArithmeticException ae) {
			return 0;
		}		
	}
	
	/**
	 * Calcula la cantidad media de segundos por partido del jugador en una temporada
	 * @param minutos Minutos totales en la temporada del jugador
	 * @param segundos Segundos totales en la temporada del jugador
	 * @param partidos Partidos totales en la temporada del jugador
	 * @return
	 */
	public static int calculaSegundosMedios(int minutos, int segundos, int partidos) {
		try {
			int segundosTotalesMedios=(minutos*60+segundos)/partidos;
			return segundosTotalesMedios%60;
		} catch (ArithmeticException ae) {
			return 0;
		}
	}

}
