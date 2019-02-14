package contenidosTests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bag.Bag;
import bag.Contenido;
import bag.Texto;
import bag.Video;

public class ContenidoTest {

	Bag bagYt = new Bag("Youtube");
	Bag bagAlex = new Bag("Alex");
	Bag bagOut = new Bag("Outconsumer");
	Texto texto = new Texto("Descripcion YT");
	Video video1 = new Video("NBA");
	Video video2 = new Video("Minecraft");
	Video video3 = new Video("LOL");
	
	@Before
	public void set() {
		bagAlex.agregarContenido(video2);
		bagAlex.agregarContenido(video3);
		bagOut.agregarContenido(video1);
		bagYt.agregarContenido(bagAlex);
		bagYt.agregarContenido(bagOut);
		bagYt.agregarContenido(texto);
	}
	
	@Test
	public void seAgregaContenido() {
		bagYt.agregarContenido(texto);
		assertEquals(5, bagYt.cantContenidos());
	}
	
	@Test
	public void seMuestraTodosLosContenidosDeUnBag() {
		List<Contenido> contenidos = bagYt.obtenerTodosLosContenidos();
		assertEquals(4, contenidos.size());
	}
	
}
