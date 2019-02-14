package hitTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bag.Bag;
import bag.Texto;
import bag.Video;
import hits.AgregarContenido;
import hits.EditarTitulo;
import hits.Hit;
import hits.QuitarContenido;

public class HitTest {


	Bag bagYt = new Bag("Youtube");
	Bag bagAlex = new Bag("Alex");
	Bag bagOut = new Bag("Outconsumer");
	Texto texto = new Texto("Descripcion YT");
	Video video1 = new Video("NBA");
	Video video2 = new Video("Minecraft");
	Video video3 = new Video("LOL");
	Video video4 = new Video("Felipe");
	Hit hit1 = new Hit();
	Hit hit2 = new Hit();
	Hit hit3 = new Hit();
	Hit hit4 = new Hit();
	
	@Before
	public void set() {
		bagAlex.agregarContenido(video2);
		bagAlex.agregarContenido(video3);
		bagOut.agregarContenido(video1);
		bagYt.agregarContenido(bagAlex);
		bagYt.agregarContenido(bagOut);
		bagYt.agregarContenido(texto);
		hit1.agregarCommit(new AgregarContenido(texto));
		hit1.agregarCommit(new EditarTitulo("ALEX EL CAPO"));
		hit2.agregarCommit(new QuitarContenido(texto));
		hit3.agregarCommit(new AgregarContenido(video3));
		hit4.agregarCommit(new AgregarContenido(video4));
	}
	
	@Test
	public void agregarContenido() {
		bagYt.aplicarHit(hit3);
		assertEquals(5, bagYt.cantContenidos());
	}
	
	@Test
	public void quitarContenido() {
		bagYt.aplicarHit(hit2);
		assertEquals(3, bagYt.cantContenidos());
	}
	
	@Test
	public void editarContenido() {
		System.out.println(bagYt.getNombre());
		bagYt.aplicarHit(hit1);
		System.out.println(bagYt.getNombre());
		assertEquals(5, bagYt.cantContenidos());
	}
	
	@Test
	public void deshacerQuitarContenido() {
		bagYt.aplicarHit(hit2);
		assertEquals(3, bagYt.cantContenidos());
		Bag unBag = bagYt.bagEstadoPrevio(hit2);
		assertEquals(4, unBag.cantContenidos());
	}
	
	@Test
	public void deshacerAgregarContenido() {
		bagYt.aplicarHit(hit3);
		assertEquals(5, bagYt.cantContenidos());
		Bag unBag = bagYt.bagEstadoPrevio(hit3);
		assertEquals(4, unBag.cantContenidos());
	}
	
	@Test
	public void deshacerEditarTitulo() {
		System.out.println(bagYt.getNombre());
		bagYt.aplicarHit(hit1);
		System.out.println(bagYt.getNombre());
		assertEquals(5, bagYt.cantContenidos());
		Bag unBag = bagYt.bagEstadoPrevio(hit1);
		System.out.println(unBag.getNombre());
		assertEquals(4, unBag.cantContenidos());
	}
	
	@Test
	public void deshacerDosHits() {
		bagYt.aplicarHit(hit1);
		assertEquals(5, bagYt.cantContenidos());
		bagYt.aplicarHit(hit3);
		bagYt.aplicarHit(hit4);
		assertEquals(7, bagYt.cantContenidos());
		Bag unBag = bagYt.bagEstadoPrevio(hit3);
		assertEquals(5, unBag.cantContenidos());
	}
	
	
}
