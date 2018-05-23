package org.hecarap.acbstats.scrap;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;


public class ScrapPaginaWeb {
	
	String url;

	public ScrapPaginaWeb(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Este método comprueba el Status code de la respuesta que se recibe al hacer la petición
	 * EJM:
	 * 		200 OK
	 * 		300 Multiple Choices
	 * 		301 Moved Permanently	
	 * 		305 Use Proxy
	 * 		400 Bad Request	
	 * 		403 Forbidden
	 * 		404 Not Found
	 * 		500 Internal Server Error
	 * 		502 Bad Gateway
	 * 		503 Service Unavailable
	 * @return Status Code
	 */
	public final int getStatusConnectionCode() {
			
	    Response response = null;
		
	    try {
		response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
	    } catch (IOException ex) {
		System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
	    }
	    return response.statusCode();
	}

	/**
	 * Este método devuelve un objeto de la clase Document con el contenido del
	 * HTML de la web
	 * @return Documento con el HTML
	 */
	public final Document getHtmlDocument() {

	    Document doc = null;
		try {
		    doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
		    } catch (IOException ex) {
			System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
		    }
	    return doc;
	}
}
