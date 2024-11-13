package ar.edu.unlam.pb2.dominio;

import ar.edu.unlam.excepciones.CantidadMaximaDocentesException;
import ar.edu.unlam.excepciones.DocenteNoCuentaConExperiencia;
import ar.edu.unlam.excepciones.cantidadMaximaDeAlumnosSuperada;

public class Grado extends Curso{

	private Numero grado;
	private final Integer EDAD_MINIMA=9;

	
	public Grado(Numero grado) {
		this.grado = grado;
		this.cantidadDeAlumnos=30;
		this.cantidadProfesores=1;
	}

	public Numero getGrado() {
		return grado;
	}

	public void setGrado(Numero grado) {
		this.grado = grado;
	}

	@Override
	public Boolean agregarAlumno(Alumno alumno) throws cantidadMaximaDeAlumnosSuperada {
		if(alumno.getEdad()>=EDAD_MINIMA ||alumno.getEdad()<=11  && coleccionAlumnos.size()<cantidadDeAlumnos){
			return coleccionAlumnos.add(alumno);
		}
		throw new cantidadMaximaDeAlumnosSuperada("cantidad de alumnos superada");
	}

	@Override
	public Boolean asignarMaestro(Docente docente) throws CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia {
		if (coleccionDocentes.size() <= cantidadProfesores && tieneExperiencia(docente)) {
			return coleccionDocentes.add(docente);
		}
		throw new CantidadMaximaDocentesException("supero la cantidad maxima de docentes");
	}

	public Boolean tieneExperiencia(Docente docente) throws DocenteNoCuentaConExperiencia {
		Boolean tieneExperiencia=docente.getExperiencia().getGrado()[this.grado.ordinal()];
		if(tieneExperiencia) {
			return true;
		}
		throw new DocenteNoCuentaConExperiencia("El docente no cuenta con la experiencia necesaria");
	}
}
