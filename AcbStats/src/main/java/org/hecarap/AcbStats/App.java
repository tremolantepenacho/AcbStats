package org.hecarap.AcbStats;


import org.hecarap.AcbStats.modelo.Jugador;
import org.hecarap.AcbStats.scrap.*;

public class App 
{
    public static void main( String[] args ){
    	ScrapPaginaWeb prueba=new ScrapPaginaWeb("http://www.acb.com/jugador.php?id=217");
    	//System.out.println(prueba.getStatusConnectionCode());
    	ScrapJugador djublevic=new ScrapJugador(prueba.getHtmlDocument());
    	Jugador dubi=djublevic.getJugador();
    	System.out.println(dubi);
    }
}
