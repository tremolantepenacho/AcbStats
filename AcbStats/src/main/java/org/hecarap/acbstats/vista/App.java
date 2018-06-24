package org.hecarap.acbstats.vista;


import org.hecarap.acbstats.controlador.Controlador;
import org.hecarap.acbstats.modelo.Partido;
import org.hecarap.acbstats.scrap.*;
import org.hecarap.hibernate.HibernateUtil;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args ){
    	
    	Controlador.inicia();
    	Controlador.creaEsquema();
    	Controlador.insertaTemporada("http://acb.com/calendario.php?cod_competicion=LACB&cod_edicion=62&vd=1&vh=34");
    	//Controlador.creaTemporadaJugador(62);
    	Controlador.finaliza();
     	}
    
}
