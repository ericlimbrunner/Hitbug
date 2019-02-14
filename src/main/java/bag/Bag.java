package bag;

import java.util.ArrayList;
import java.util.List;

import hits.Hit;
import usuarios.Usuario;

public class Bag implements Contenido{
	
	private String nombre;
	private Usuario duenio;
	private List<Contenido> contenidos = new ArrayList<Contenido>();
	private List<Usuario> colaboradores = new ArrayList<Usuario>();
	private List<Hit> hits = new ArrayList<Hit>();
	private List<Hit> hitRequests = new ArrayList<Hit>();
	
	public Bag(String nombre) {
		super();
		this.nombre = nombre;
	}

	public void aplicarHit(Hit hit) {
		hit.ejecutar(this);
		hits.add(hit);
	}
	
	public Bag bagEstadoPrevio(Hit hit) {
		Bag bag = this;
		bag.volverAEstadoPrevioA(hit);
		return bag;
	}
	
	public void volverAEstadoPrevioA(Hit unHit) {
		for(int i = hits.size(); i>=0;i--) {
			Hit hit = hits.get(i-1);
			if(hit != unHit) {
				hit.deshacer(this);
			}
			else {
				unHit.deshacer(this);
				return;
			}
		}
	}
	
	public void aceptarHitRequest(Hit unHit) {
		if(!hitRequests.contains(unHit)) {
			throw new NoPoseeDichoHitRequest();
		}
		hitRequests.remove(unHit);
		this.aplicarHit(unHit);
	}
	
	public void rechazarHitRequest(Hit unHit) {
		if(!hitRequests.contains(unHit)) {
			throw new NoPoseeDichoHitRequest();
		}
		hitRequests.remove(unHit);
	}
	
	public void agregarContenido(Contenido contenido) {
		contenidos.add(contenido);
	}
	
	public void quitarContenido(Contenido contenido) {
		contenidos.remove(contenido);
	}
	
	public void contenidosMultimedia(List<Contenido> contenidosAMostrar) {
		this.contenidos.stream().forEach(contenido-> contenido.contenidosMultimedia(contenidosAMostrar));
	}

	public List<Contenido> obtenerTodosLosContenidos() {
		List<Contenido> contenidosAMostrar = new ArrayList<Contenido>();
		this.contenidosMultimedia(contenidosAMostrar);
		return contenidosAMostrar;
	}
	
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void editarNombre(String nombre) {
		this.nombre = nombre;
	}

	public int cantContenidos() {
		return this.contenidos.stream().mapToInt(contenido -> contenido.cantContenidos()).sum();
	}
	
	public void agregarColaborador(Usuario colaborador) {
		colaboradores.add(colaborador);
	}
	
	public void agregarHit(Hit hit) {
		hits.add(hit);
	}
	
	public void agregarHitRequest(Hit hit) {
		hitRequests.add(hit);
	}

	public Usuario getDuenio() {
		return duenio;
	}

	public void setDuenio(Usuario duenio) {
		this.duenio = duenio;
	}
	
}
