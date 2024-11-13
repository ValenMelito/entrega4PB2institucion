package ar.edu.unlam.pb2.test;
import ar.edu.unlam.excepciones.AlumnoNoEncontradoException;
import ar.edu.unlam.excepciones.cantidadMaximaDeAlumnosSuperada;
import ar.edu.unlam.pb2.dominio.*;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Set.*;
import java.util.TreeSet;

import org.junit.Test;

public class test {

	@Test
	public void queNoSeAgreguenAlumnosRepetidosAUnCurso() throws cantidadMaximaDeAlumnosSuperada {
		Grado curso= new Grado(Numero.CUARTO);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno ailen= new Alumno("ailen", "araujo", 4100, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);

		//System.out.println(martin.hashCode());
		//System.out.println(ailen.hashCode());		
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		curso.agregarAlumno(ailen);
		curso.agregarAlumno(martin);
		System.out.println(curso.getColeccionAlumnos().size());
		
		for(Alumno alum : curso.getColeccionAlumnos()) {
			System.out.println(alum.toString());
		}
		assertEquals(3,curso.getColeccionAlumnos().size());
		/*
		System.out.println("-----------------");
		
		for(Alumno alum : curso.getColeccionAlumnos()) {
			System.out.println(alum.toString());
		}
		System.out.println(curso.getColeccionAlumnos().size());*/
		
		
	}
	
	@Test
	public void queLosAlumnosDeUnCursoSeanOrdenadosPorDniAscendente() throws cantidadMaximaDeAlumnosSuperada {
		Grado curso= new Grado(Numero.CUARTO);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno ailen= new Alumno("ailen", "araujo", 4100, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);
		
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		curso.agregarAlumno(ailen);
		curso.agregarAlumno(martin);
		
		
		TreeSet<Alumno>alumnos= curso.ordenarAlumnosPorDniDeMayorAMenor();
		Alumno alumno=null;
		for(Alumno alum : alumnos) {
			alumno=alum;
		}
		//System.out.println(alumnos.size());
		
		assertEquals(alumno.getDni(), sol.getDni());
	}
	
	@Test
	public void BuscarUnAlumnoEnUnCurso() throws AlumnoNoEncontradoException, cantidadMaximaDeAlumnosSuperada {
		Grado curso= new Grado(Numero.CUARTO);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno ailen= new Alumno("ailen", "araujo", 4100, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);		
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		curso.agregarAlumno(ailen);
		curso.agregarAlumno(martin);
		
		Alumno alumnoBuscado=curso.buscarAlumno(martin);
		
		assertEquals(alumnoBuscado, martin);
	}
	
	@Test ()
	public void BuscarUnAlumnoEnUnCursoPorDni() throws AlumnoNoEncontradoException, cantidadMaximaDeAlumnosSuperada {
		Grado curso= new Grado(Numero.CUARTO);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno ailen= new Alumno("ailen", "araujo", 4100, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);		
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		curso.agregarAlumno(ailen);
		curso.agregarAlumno(martin);
		
		Alumno alumnoBuscado=curso.buscarAlumnoPorDni(4000);
		
		assertEquals(alumnoBuscado, pedro);
	}
	
	@Test(expected = AlumnoNoEncontradoException.class)
	public void BuscarUnAlumnoEnUnCursoYNoencontrarlo() throws AlumnoNoEncontradoException, cantidadMaximaDeAlumnosSuperada {
		Grado curso= new Grado(Numero.CUARTO);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);	
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		
		Alumno alumnoBuscado=curso.buscarAlumno(martin);//martin no fue agregado por eso no aparece
	}
	
	@Test 
	public void tomarAsistencia() throws AlumnoNoEncontradoException, cantidadMaximaDeAlumnosSuperada {
		ColorDeSala color= ColorDeSala.ROJO;
		Sala curso= new Sala(color);
		Alumno pedro= new Alumno("pedro", "pascual", 4000,12);
		Alumno sol= new Alumno("sol", "muñoz", 4500, 12);
		Alumno martin= new Alumno("martin", "araujo", 4100, 12);	
		
		curso.agregarAlumno(pedro);
		curso.agregarAlumno(sol);
		
		Fecha fecha= new Fecha(1, 12);
		Fecha fecha2= new Fecha(1, 10);
		Fecha fecha3= new Fecha(1, 12);
		curso.tomarAsistencia(fecha, martin, true);
		curso.tomarAsistencia(fecha2, martin, true);
		curso.tomarAsistencia(fecha3, martin, true);

		System.out.println(martin.getAsistencias());
		
		assertEquals(martin.getAsistencias().size(), 2);
	}
	
	@Test 
	public void probarQueNoSeRepitanLasMateriasPorId() {
		Materia matematica= new Materia(1, "Matematica");
		Materia Ingles = new Materia(1, "Ingles");
		Anio anio1= new Anio(Numero.CUARTO);
		anio1.agregarMaterias(matematica);
		anio1.agregarMaterias(Ingles);
		/*System.out.println(anio1.getMaterias().size());
		for(Materia mat : anio1.getMaterias()) {
			System.out.println(mat);
		}*/
		assertEquals(1, anio1.getMaterias().size());
	}
	
	
}
