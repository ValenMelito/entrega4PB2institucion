package ar.edu.unlam.pb2.dominio;

public class Docente extends Persona{
	private HistorialAcademico experiencia;
	
	public Docente(String nombre, String apellido, Integer dni, Integer edad) {
		super(nombre, apellido, dni, edad);
	}
	
	public HistorialAcademico getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(HistorialAcademico experiencia) {
		this.experiencia = experiencia;
	}





}
