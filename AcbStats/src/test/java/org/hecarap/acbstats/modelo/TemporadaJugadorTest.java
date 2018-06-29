package org.hecarap.acbstats.modelo;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TemporadaJugadorTest {
	
	private int minutos;
	private int segundos;
	private int partidos;
	private int resultadoMinutos;
	private int resultadoSegundos;
	
	@Parameters(name = "{index}: minutos:segundos partidos --> {0}:{1} {2}= {3} minutos {4} segundos")
    public static Iterable data(){
        return Arrays.asList(new Object[][]{
                {10,0,10,1,0},{0,10,10,0,1},{10,10,0,0,0},{200,600,10,21,0},{200,601,10,21,0},{200,610,10,21,1},{201,600,10,21,6},{201,601,10,21,6},{201,610,10,21,7}
        });
    }

	
	public TemporadaJugadorTest(int minutos, int segundos, int partidos, int resultadoMinutos, int resultadoSegundos) {
		super();
		this.minutos = minutos;
		this.segundos = segundos;
		this.partidos = partidos;
		this.resultadoMinutos = resultadoMinutos;
		this.resultadoSegundos=resultadoSegundos;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculaMinutosMedios() {
		assertEquals(resultadoMinutos,TemporadaJugador.calculaMinutosMedios(minutos,segundos,partidos));
	}

	@Test
	public void testCalculaSegundosMedios() {
		assertEquals(resultadoSegundos,TemporadaJugador.calculaSegundosMedios(minutos,segundos,partidos));
	}

}
