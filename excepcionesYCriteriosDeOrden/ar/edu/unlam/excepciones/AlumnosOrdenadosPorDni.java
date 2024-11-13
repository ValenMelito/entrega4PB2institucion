package ar.edu.unlam.excepciones;

import java.util.Comparator;

import ar.edu.unlam.pb2.dominio.*;


public class AlumnosOrdenadosPorDni implements Comparator<Alumno> {

	@Override
	public int compare(Alumno alumno1, Alumno alumno2) {
		return alumno1.getDni().compareTo(alumno2.getDni());
	}

}
