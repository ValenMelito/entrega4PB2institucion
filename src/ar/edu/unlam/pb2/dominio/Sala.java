package ar.edu.unlam.pb2.dominio;

import java.util.LinkedList;
import ar.edu.unlam.excepciones.*;

public class Sala extends Curso{
	private ColorDeSala color;

	public Sala(ColorDeSala color) {
		this.color = color;
	}

	public ColorDeSala getColor() {
		return color;
	}

	public void setColor(ColorDeSala color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Sala " + color + "\n Maestro=" + getColeccionDocentes() + "\n Alumnos=" + getColeccionAlumnos();
	}

	@Override
	public Boolean agregarAlumno(Alumno alumno) throws cantidadMaximaDeAlumnosSuperada {
		if (coleccionAlumnos.size() <= cantidadDeAlumnos) {
			return coleccionAlumnos.add(alumno);
		}
		throw new cantidadMaximaDeAlumnosSuperada("ya no entran mas alumnos en esta comision");
	}
	

	@Override
	public Boolean asignarMaestro(Docente docente) throws CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia{
		if (coleccionDocentes.size() < cantidadProfesores && tieneExperiencia(docente)) {
			return coleccionDocentes.add(docente);
		}
		throw new CantidadMaximaDocentesException("supero la cantidad maxima de docentes");
	}

	public Boolean tieneExperiencia(Docente docente) throws DocenteNoCuentaConExperiencia {
		Boolean tieneExperiencia=docente.getExperiencia().isJardinero();
		if(tieneExperiencia) {
			return true;
		}
		throw new DocenteNoCuentaConExperiencia("El docente no cuenta con la experiencia necesaria");
	}

	

}
