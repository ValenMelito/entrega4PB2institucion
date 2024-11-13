package ar.edu.unlam.pb2.dominio;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import ar.edu.unlam.excepciones.*;


public abstract class Curso {
	protected Integer cantidadDeAlumnos = 10;
	protected Integer cantidadProfesores=2;
	protected Set<Alumno> coleccionAlumnos= new TreeSet<>();
	protected Set<Docente> coleccionDocentes = new HashSet<>();
	
	public Curso() {	
	}

	public Set<Alumno> getColeccionAlumnos() {
		return coleccionAlumnos;
	}

	public void setColeccionAlumnos(TreeSet<Alumno> coleccionAlumnos) {
		this.coleccionAlumnos = coleccionAlumnos;
	}
	
	public Set<Docente> getColeccionDocentes() {
		return coleccionDocentes;
	}

	public void setColeccionDocentes(Set<Docente> coleccionDocentes) {
		this.coleccionDocentes = coleccionDocentes;
	}

	
	public Alumno buscarAlumno(Alumno alumno) throws AlumnoNoEncontradoException{
		if(coleccionAlumnos.contains(alumno)) {
			return alumno;
		}
		throw new AlumnoNoEncontradoException("No se encontro a un alumno");
	}
	
	public Alumno buscarAlumnoPorDni(Integer dni) throws AlumnoNoEncontradoException{
		for (Alumno alumno : coleccionAlumnos) {
			if (alumno.getDni().equals(dni)) {
				return alumno;
			}
		}
		throw new AlumnoNoEncontradoException("No se encontro a un alumno");
	}
	
	public Boolean bajaAlumno(Integer dni) throws AlumnoNoEncontradoException {
		if (buscarAlumnoPorDni(dni) != null) {
			getColeccionAlumnos().remove(buscarAlumnoPorDni(dni));
			return true;
		}
		throw new AlumnoNoEncontradoException("No se encontro a un alumno");
	}
	

	public Boolean tomarAsistencia(Fecha fecha, Alumno alumno, Boolean asistencia) {
		Asistencia nueva = new Asistencia(fecha, asistencia);	
		return alumno.getAsistencias().add(nueva);
	}

	
	public abstract Boolean agregarAlumno(Alumno alumno) throws cantidadMaximaDeAlumnosSuperada;
	
	public abstract Boolean asignarMaestro(Docente docente) throws CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia;
	
	public TreeSet<Alumno> ordenarAlumnosPorDniDeMayorAMenor(){
		TreeSet<Alumno> alumnosOrdenadosPorDni = new TreeSet<>(new AlumnosOrdenadosPorDni());
		alumnosOrdenadosPorDni.addAll(this.coleccionAlumnos);
		return alumnosOrdenadosPorDni;
	}
	
	public Docente buscarMaestroPorDNI(Integer dni) throws DocenteNoEncontrado {
		for (Docente docente : coleccionDocentes) {
			if (docente.getDni().equals(dni)) {
				return docente;
			}
		}
		throw new DocenteNoEncontrado("No se encontro al docente");
	}

	public Boolean bajaDocente(Integer dni) throws DocenteNoEncontrado {
		return coleccionDocentes.remove(buscarMaestroPorDNI(dni));
	}
	
}
