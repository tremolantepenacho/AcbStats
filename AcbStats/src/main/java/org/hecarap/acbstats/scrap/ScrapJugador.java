package org.hecarap.acbstats.scrap;

import org.hecarap.acbstats.modelo.Jugador;
import org.hecarap.acbstats.modelo.Pasaporte;
import org.hecarap.acbstats.modelo.Posicion;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;

public class ScrapJugador {

	Document jugador;
	String codigo;

	public ScrapJugador(Document player) {
		String[] aux=player.location().split("=");
		codigo= aux[1];
		this.jugador = player;
	}
	
	
	
	
	public Jugador getJugador() {
		
		String nombre, lugarNacimiento, nacionalidad;
		Date fechaNacimiento;
		Posicion pos;
		double altura;
		Pasaporte pass;
		
		Elements entradas = jugador.getElementsByClass("datojug");
		
		nombre= getNombre(entradas.get(0));
		lugarNacimiento= getLugarNacimiento(entradas.get(1));
		fechaNacimiento= getFechaNacimiento(entradas.get(1));
		pos= getPosicion(entradas.get(2));
		altura= getAltura(entradas.get(2));
		nacionalidad= getNacionalidad(entradas.get(3));
		pass= getPasaporte(entradas.get(3));
				
		return new Jugador(codigo,nombre,nacionalidad,lugarNacimiento,altura,pos,pass,fechaNacimiento);
	}
	
	public String getNombre(Element e) {
		return e.text();
		}
	public String getLugarNacimiento(Element e) {
		String[] aux= e.text().split(",");
		return aux[0];
	}
	
	@SuppressWarnings("deprecation")
	public Date getFechaNacimiento(Element e) {
		String[] aux= e.text().split(",");
		String[] fechas= aux[1].split("/");
		return new Date(Integer.parseInt(fechas[2])-1900,Integer.parseInt(fechas[1])-1,Integer.parseInt(fechas[0].trim()));
		
	}
	
	public Posicion getPosicion(Element e) {
		String[] aux= e.text().split("\\|");
		aux[0]= aux[0].trim();
		if (aux[0].equals("B")) return Posicion.BASE;
		if (aux[0].equals("E")) return Posicion.ESCOLTA;
		if (aux[0].equals("A")) return Posicion.ALERO;
		if (aux[0].equals("F")) return Posicion.ALAPIVOT;
		return Posicion.PIVOT;
		
	}
	
	public double getAltura(Element e) {
		String[] aux= e.text().split("\\|");
		String[] alt= aux[1].split(" ");
		return Double.parseDouble(alt[1]);
	}
	
	public String getNacionalidad(Element e) {
		String[] aux= e.text().split("\\|");
		return aux[0].trim();
	}
	
	public Pasaporte getPasaporte(Element e) {
		String[] aux= e.text().split("\\|");
		aux[1]= aux[1].trim();	
		if (aux[1].equals("EUR")) return Pasaporte.EUROPEO;
		if (aux[1].equals("EXT")) return Pasaporte.EXTRACOMUNITARIO;
		return Pasaporte.CUPO;
	}
}
