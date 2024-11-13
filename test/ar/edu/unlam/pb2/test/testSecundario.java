package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import ar.edu.unlam.excepciones.cantidadMaximaDeAlumnosSuperada;
import ar.edu.unlam.pb2.dominio.*;

public class testSecundario {

	
	@Test
	public void agregarUnAnioASecundario() throws ComisionExistente {
		String nombre = "Unlam";			
		Institucion institucion = new Institucion(nombre);
		Secundaria secundaria=institucion.getSecundaria();
		Anio anio1=new Anio(Numero.PRIMERO);
		assertTrue(secundaria.agregarCupoEspecifico(anio1));
	}
	
	@Test
	public void verificarQueUnAlumnoHayaPasadoASecundaria() {
		HistorialAcademico historial= new HistorialAcademico(true);
		Alumno alumno=new Alumno("Enrique","Maximo", 1111111, 12);
		alumno.setHistorial(historial);
		historial.setPrimaria(true);
		assertTrue(historial.isPrimaria());
	}
	
	@Test
	public void agregarUnAlumnoAPrimerAnioEnSecundario() throws cantidadMaximaDeAlumnosSuperada, ComisionExistente {
		String nombre = "Unlam";			
		Institucion institucion = new Institucion(nombre);
		Secundaria secundaria=institucion.getSecundaria();
		Anio anio1=new Anio(Numero.PRIMERO);
		secundaria.agregarCupoEspecifico(anio1);	
		HistorialAcademico historial= new HistorialAcademico(true);
		Alumno alumno=new Alumno("Juan","Villa", 1111111, 12);
		alumno.setHistorial(historial);
		for(int i=0;i<historial.getAnio().length;i++) {
			historial.getAnio()[i]=false;
		}
		historial.setPrimaria(true);
		System.out.println(anio1.agregarAlumno(alumno));
		assertTrue(anio1.getColeccionAlumnos().contains(alumno));
	}

	@Test
	public void agregarUnAlumnoAUnSegundoAnioEnSecundario() throws cantidadMaximaDeAlumnosSuperada, ComisionExistente {		
		Institucion institucion = new Institucion("Unlam");
		Secundaria secundaria=institucion.getSecundaria();
		Anio anio1=new Anio(Numero.SEGUNDO);
		secundaria.agregarCupoEspecifico(anio1);	
		HistorialAcademico historial= new HistorialAcademico(true);
		Alumno alumno=new Alumno("Juan", "Perez", 1111111, 12);
		alumno.setHistorial(historial);
		historial.getAnio()[0]=true;
		for(int i=1;i<historial.getAnio().length;i++) {
			historial.getAnio()[i]=false;
		}
		historial.setPrimaria(true);
		System.out.println(anio1.agregarAlumno(alumno));
		assertTrue(anio1.getColeccionAlumnos().contains(alumno));
	}
	
	
	@Test 
	public void agregarUnDocenteAUnaMateria() {
		Anio anio1=new Anio(Numero.SEGUNDO);
		Docente docente = new Docente("Nicolas", "Maduro",11111, 33);
		HistorialAcademico historialDocente = new HistorialAcademico();
		Materia quimica = new Materia(1, "quimica");
		historialDocente.getMaterias()[0]=quimica;
		docente.setExperiencia(historialDocente);
		anio1.asignarMaestro(docente, quimica);
		assertEquals(quimica.getDocente(), docente);
	}
	
	
	/*@Test	
	public void agregarUnaMateriaAUnAnio(){
		Institucion institucion = new Institucion("Unlam");
		Secundaria secundaria=institucion.getSecundaria();
		Anio anio1=new Anio(Numero.SEGUNDO);
		secundaria.crearAnios(anio1);
		Docente docente = new Docente("Nicolas",11111);
		Materia quimica = new Materia("quimica");
		anio1.agregarMaterias(quimica);
		assertEquals(anio1.getMaterias().get(0).getDocente(),docente);
	}*/
}
