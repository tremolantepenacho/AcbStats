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


	Document temporada;

	public ScrapTemporada(Document temporada) {
		this.temporada = temporada;
	}
	
	public void obtenPartidos() {
		
			Elements entradas = temporada.getElementsByClass("negro");
		
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
	
}
