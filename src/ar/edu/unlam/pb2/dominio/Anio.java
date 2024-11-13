package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import ar.edu.unlam.excepciones.CantidadMaximaDocentesException;
import ar.edu.unlam.excepciones.DocenteNoCuentaConExperiencia;
import ar.edu.unlam.excepciones.cantidadMaximaDeAlumnosSuperada;

public class Anio extends Curso{

	private HashSet<Materia> materias = new HashSet<>();
	private Numero anio;
	
	public Anio(Numero anio){
		this.anio = anio;
	}
	
	public HashSet<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(HashSet<Materia> materias) {
		this.materias = materias;
	}

	public Numero getAnio() {
		return anio;
	}

	public void setAnio(Numero anio) {
		this.anio = anio;
	}
	
	public Boolean agregarMaterias(Materia materia) {
		return materias.add(materia);
	}
	
	public Boolean aproboJardin(Alumno alumno) {
		if (alumno != null && alumno.getHistorial().isPrimaria()) {
			return true;
		}
		return false;
	}
	
	public Boolean aproboAnioPrevio(Alumno alumno) {
		if (alumno != null && aproboJardin(alumno)
				&& alumno.getHistorial().getAnio()[this.anio.ordinal()-1]){
			return true;
		}
		return false;
	}

	@Override
	public Boolean agregarAlumno(Alumno alumno) throws cantidadMaximaDeAlumnosSuperada {
		Boolean alumnoAgregado=false;
		
		if(getAnio().equals(Numero.PRIMERO)) {
			if(aproboJardin(alumno)) {	
				coleccionAlumnos.add(alumno);
				alumnoAgregado=true;
			}
		}else{
			if(aproboAnioPrevio(alumno)) {
				coleccionAlumnos.add(alumno);
				alumnoAgregado=true;	
			}
			
		}
		return alumnoAgregado;
			
		}

	public Boolean asignarMaestro(Docente docente, Materia materia) {
		if (tieneExperienciaEnMateria(docente, materia)) {
			materia.setDocente(docente);
			return true;
		}
		return false;
	}

	public Boolean tieneExperienciaEnMateria(Docente profesor, Materia materia) {
		for (int i = 0; i < profesor.getExperiencia().getMaterias().length; i++) {
			if (profesor.getExperiencia().getMaterias()[i]!=null) {
				if(profesor.getExperiencia().getMaterias()[i].getNombre().equals(materia.getNombre())){
					return true;
					}
			}
		}
		return false;
	}
	
	public Materia buscarMateriaPorNombre(String nombre) throws MateriaNoEncontrada {
		for(Materia materia : materias) {
			if(materia.getNombre().equals(nombre)) {
				return materia;
			}
		}
		throw new MateriaNoEncontrada("no se encontro la materia buscada");
	}
	
	public Boolean eliminarMateria(Materia materia) throws MateriaNoEncontrada {
		Materia materiaABajar=buscarMateriaPorNombre(materia.getNombre());
		Boolean bajado=false;
		if (materiaABajar != null) {
			materias.remove(materiaABajar);
			bajado=true;
		}
		return bajado;
	}

	@Override
	public Boolean asignarMaestro(Docente docente)
			throws CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
