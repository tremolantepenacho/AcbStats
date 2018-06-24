package org.hecarap.acbstats.scrap;

import java.util.ArrayList;
import java.util.List;

import org.hecarap.acbstats.controlador.Controlador;
import org.hecarap.acbstats.modelo.Partido;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class ScrapTemporada {


	Document docTemporada;
	String nombreTemporada;
	int numTemporada;

	public ScrapTemporada(Document docTemporada) {
		this.docTemporada = docTemporada;
		nombreTemporada=obtenNombreTemporada();
		numTemporada=obtenNumTemporada();
	}
	
	public void obtenPartidos() {
		
		Elements entradas = docTemporada.getElementsByClass("negro");
		
		for (Element elem : entradas) {
			Elements nodosHijo=elem.children();
			if (nodosHijo.size()==1) {
				ScrapPaginaWeb paginaWeb=new ScrapPaginaWeb("http://www.acb.com/"+nodosHijo.get(0).attr("href"));
				Document partidoDocument=paginaWeb.getHtmlDocument();
				ScrapPartido partidos=new ScrapPartido(partidoDocument);
				Partido partidoAInsertar=partidos.obtenPartido();
				Controlador.insertaPartido(partidoAInsertar);
				ScrapPartidoJugador partidoJugador=new ScrapPartidoJugador(partidoDocument,partidoAInsertar.getId());
				partidoJugador.obtenPartidosJugadores();
			}
			
		}
	}
	public String obtenNombreTemporada() {
		Elements entradas= docTemporada.getElementsByClass("titulomenuclubs");
		String[] aux=entradas.get(0).toString().split("-");
		return aux[0].trim();
	}
	
	public int obtenNumTemporada() {
		String[] aux=docTemporada.location().split("=");
		String[] res=aux[2].split("&");
		return Integer.parseInt(res[0]);
	}
	
}
