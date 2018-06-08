package org.hecarap.acbstats.scrap;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hecarap.acbstats.controlador.Controlador;
import org.hecarap.acbstats.modelo.PartidoJugador;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class ScrapPartidoJugador {

	private Document web;
	private String idJugador;
	private Date minutos;
	private int puntos;
	private int intentosUno;
	private int canastasUno;
	private int intentosDos;
	private int canastasDos;
	private int intentosTres;
	private int canastasTres;
	private int rebotesOfensivos;
	private int rebotesDefensivos;
	private int rebotes;
	private int asistencias;
	private int robos;
	private int perdidas;
	private int taponesFavor;
	private int taponesContra;
	private int faltasFavor;
	private int faltasContra;
	private int valoracion;

	public ScrapPartidoJugador(Document web) {
		super();
		this.web = web;
	}
	
	
	public void obtenPartidosJugadores() {
			
			Elements entradas=web.getElementsByClass("naranjaclaro");
			for (Element jugador : entradas) {
					if (tieneEnlaceJugador(jugador.childNode(0)) && !existeJugador(jugador)) {
						insertaJugador(jugador.childNode(0).attr("href"));
					}
					Elements padre=jugador.parent().children();
					PartidoJugador nuevoPartidoJugador=creaPartidoJugador(padre);
					if (nuevoPartidoJugador!=null) {
						Controlador.insertaPartidoJugador(nuevoPartidoJugador);
					}
			}
		}
	
	private boolean existeJugador(Element jugador) {
		return false;
		
	}
	
	private void insertaJugador(String direccion) {
		if (!direccion.contains("www.acb.com")) {
			direccion="http://www.acb.com"+direccion;
		}
		ScrapJugador jugador=new ScrapJugador(direccion);
		Controlador.insertaJugador(jugador.getJugador());
		
	}
	
	private PartidoJugador creaPartidoJugador(Elements datosJugador) {
			
		if (haParticipado(datosJugador)) {
			String id=obtenIdJugador(datosJugador);
			Date minutos=obtenMinutosJugador(datosJugador);
			int puntos=obtenPuntos(datosJugador);
			int intentosDos=obtenIntentosDos(datosJugador);
			int canastasDos=obtenCanastasDos(datosJugador);
			int intentosTres=obtenIntentosTres(datosJugador);
			int canastasTres=obtenCanastasTres(datosJugador);
			int intentosUno=obtenIntentosUno(datosJugador);
			int canastasUno=obtenCanastasUno(datosJugador);
			int rebotesOfensivos=obtenRebotesOfensivos(datosJugador);
			int rebotesDefensivos=obtenRebotesDefensivos(datosJugador);
			int rebotes=obtenRebotes(datosJugador);
			int asistencias=obtenAsistencias(datosJugador);
			int robos=obtenRobos(datosJugador);
			int perdidas=obtenPerdidas(datosJugador);
			int taponesFavor=obtenTaponesFavor(datosJugador);
			int taponesContra=obtenTaponesContra(datosJugador);
			int faltasFavor=obtenFaltasFavor(datosJugador);
			int faltasContra=obtenFaltasContra(datosJugador);
			int valoracion=obtenValoracion(datosJugador);
			
			return new PartidoJugador(id,minutos,puntos,intentosUno,canastasUno,intentosDos,canastasDos,intentosTres,canastasTres,rebotesOfensivos,rebotesDefensivos,asistencias,robos,perdidas,taponesFavor,taponesContra,faltasFavor,
			faltasContra,valoracion);
		}
		return null;
	}
	private String obtenIdJugador(Elements datos) {
		Element fila=datos.get(1);
		String res="";
		for (Node enlace : fila.childNodes()) {
			if (tieneEnlaceJugador(enlace)){
				String[] aux=enlace.toString().split("\"");
				String[] temp=aux[1].split("=");
				return temp[1];
			}
		}
		return res;
	}
	
	private Date obtenMinutosJugador(Elements datos) {
		Element fila=datos.get(2);
		String dato=fila.childNode(0).toString();
		String[] aux=dato.split(":");
		int min=Integer.parseInt(aux[0]);
		int segundos=Integer.parseInt(aux[1]);
		return new Date(0,0,0,0,min,segundos);
	}
	
	private int obtenPuntos(Elements datos) {
		Element fila=datos.get(3);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenCanastasDos(Elements datos) {
		Element fila=datos.get(4);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[1]);
	}
	private int obtenIntentosDos(Elements datos) {
		Element fila=datos.get(4);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[0]);
	}	
	private int obtenCanastasTres(Elements datos) {
		Element fila=datos.get(6);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[1]);
	}
	private int obtenIntentosTres(Elements datos) {
		Element fila=datos.get(6);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[0]);
	}	
	private int obtenCanastasUno(Elements datos) {
		Element fila=datos.get(8);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[1]);
	}
	private int obtenIntentosUno(Elements datos) {
		Element fila=datos.get(8);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("/");
		return Integer.parseInt(total[0]);
	}
	private int obtenRebotesDefensivos(Elements datos) {
		Element fila=datos.get(11);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("\\+");
		return Integer.parseInt(total[0]);
	}
	private int obtenRebotesOfensivos(Elements datos) {
		Element fila=datos.get(11);
		String dato=fila.childNode(0).toString();
		String[] total=dato.split("\\+");
		return Integer.parseInt(total[1]);
	}
	private int obtenRebotes(Elements datos) {
		Element fila=datos.get(10);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenAsistencias(Elements datos) {
		Element fila=datos.get(12);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenRobos(Elements datos) {
		Element fila=datos.get(13);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenPerdidas(Elements datos) {
		Element fila=datos.get(14);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenTaponesFavor(Elements datos) {
		Element fila=datos.get(16);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenTaponesContra(Elements datos) {
		Element fila=datos.get(17);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenFaltasFavor(Elements datos) {
		Element fila=datos.get(19);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenFaltasContra(Elements datos) {
		Element fila=datos.get(20);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	private int obtenValoracion(Elements datos) {
		Element fila=datos.get(22);
		String dato=fila.childNode(0).toString();
		return Integer.parseInt(dato);
	}
	
	private boolean tieneEnlaceJugador(Node enlace) {
		return ((enlace instanceof TextNode)==false);
	}
	private boolean haParticipado(Elements datos) {
		Element fila=datos.get(2);
		String dato=fila.childNode(0).toString();
		return !dato.equals("&nbsp;");
	}
}
