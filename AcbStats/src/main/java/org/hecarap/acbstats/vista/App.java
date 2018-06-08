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
    	Controlador.insertaJornada("prueba");
    	Controlador.finaliza();
     	}
    
}
