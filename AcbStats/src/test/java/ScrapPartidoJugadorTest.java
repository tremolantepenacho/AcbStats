import static org.junit.Assert.*;

import org.hecarap.acbstats.scrap.ScrapPaginaWeb;
import org.hecarap.acbstats.scrap.ScrapPartidoJugador;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import junit.framework.Assert;

public class ScrapPartidoJugadorTest {
	
	ScrapPaginaWeb paginaWeb;
	Document partidoDocument;
	ScrapPartidoJugador spj;
	Element jugadorCorrecto;
	Element jugadorSinEnlace;
	Element jugadorSinId;
	Element tdCorrecto;
	Element tdSinEnlace;
	Element tdSinId;
	Elements trParticipado;
	Elements trNoParticipado;
	Element tdParticipado;
	Element tdParticipado2;
	Element tdJugadorParticipado;
	
	@Mock
    private Element elementMock;

   // @InjectMocks
   // private CustomerService service;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		
		paginaWeb=new ScrapPaginaWeb("http://www.acb.com/fichas/LACB62329.php");
		partidoDocument=paginaWeb.getHtmlDocument();
		spj=new ScrapPartidoJugador(partidoDocument,null);
		
		
		tdCorrecto=new Element("td");
		jugadorCorrecto=tdCorrecto.appendElement("a");
		jugadorCorrecto.attr("href","/jugador.php?id=53W");
				
		tdSinId=new Element("td");
		jugadorSinId=tdSinId.appendElement("a");
		jugadorSinId.attr("href","/jugador.php?id=");
		
		tdSinEnlace=new Element("td");
		
		trParticipado=new Elements();
		tdParticipado=new Element("td");
		tdParticipado2=new Element("td");
		tdJugadorParticipado=new Element("td");
		tdJugadorParticipado.append("15:20");
		trParticipado.add(tdParticipado);
		trParticipado.add(tdParticipado2);
		trParticipado.add(tdJugadorParticipado);		
		trNoParticipado=new Elements();
		
		
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testObtenIdJugador() {
		
		Assert.assertEquals(spj.obtenIdJugador(tdCorrecto),"53W");		
		Assert.assertEquals(spj.obtenIdJugador(tdSinId),null);
		Assert.assertEquals(spj.obtenIdJugador(tdSinEnlace),null);
	}
	
	@Test 
	public void testEsEnlaceVacio() {
		
		Assert.assertEquals(spj.esEnlaceVacio(jugadorCorrecto), false);
		Assert.assertEquals(spj.esEnlaceVacio(jugadorSinId), true);
	}

	@Test
	public void testHaParticipado() {
		
		Assert.assertTrue(spj.haParticipado(trParticipado));
		Assert.assertFalse(trParticipado.get(2).equals("&nbsp;"));
		Assert.assertFalse(spj.haParticipado(trNoParticipado));
	}
	
	

}
