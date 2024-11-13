package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.excepciones.CantidadMaximaDocentesException;
import ar.edu.unlam.excepciones.DocenteNoCuentaConExperiencia;
import ar.edu.unlam.excepciones.DocenteNoEncontradoException;
import ar.edu.unlam.excepciones.cantidadMaximaDeAlumnosSuperada;
import ar.edu.unlam.pb2.dominio.*;

public class testInstitucion {

	@Test
	public void crearUnaInstitucion() {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		assertNotNull(ins);
		assertEquals(nombre, ins.getNombre());
		}	
	@Test	
	public void incorporarUnDocenteALaInstitucion() throws DocenteNoEncontradoException{
		Docente nuevo = new Docente("Santiago", "De Paul", 11111111, 22);
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		
		Boolean validacion = ins.incoportarDocente(nuevo);
		assertTrue(validacion);		
	}
	@Test
	public void buscarUnDocentePorSuDNI() throws DocenteNoEncontradoException {
		Integer dni = 11111111;
		Docente nuevo = new Docente("Santiago", "De Paul", 11111111, 22);
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		
		ins.incoportarDocente(nuevo);
		
		Docente buscado = ins.buscarDocente(dni);
		assertEquals(nuevo, buscado);		
	}	
	@Test
	public void darDeBajaUnDocente() throws DocenteNoEncontradoException {
		Integer dni = 11111111;
		Docente nuevo = new Docente("Santiago", "De Paul", 11111111, 22);
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		
		ins.incoportarDocente(nuevo);
		
		Docente buscado = ins.buscarDocente(dni);
		assertEquals(nuevo, buscado);		
	}	
	@Test (expected = DocenteNoEncontradoException.class)
	public void noIncorporarDosDocentesConElMismoDNI() throws DocenteNoEncontradoException{
		Integer dni = 1;
		Docente nuevo = new Docente("Santiago", "De Paul", dni, 22);
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		ins.incoportarDocente(nuevo);
		Docente segundo = new Docente("Juliana", "Martinez", dni, 25);
		Boolean validacion = ins.incoportarDocente(segundo);
		assertFalse(validacion);		
	}	
	@Test
	public void crearJardin() {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		
		assertNotNull(ins.getJardin());
	}
	@Test
	public void crearSalaCELESTE() throws ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		Boolean validacion = ins.getJardin().agregarCupoEspecifico(sala);
		
		assertTrue(validacion);
	}	
	@Test
	public void crearSalaCELESTEYSalaRoja() throws ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);	
		Boolean validacionCELESTE = ins.getJardin().agregarCupoEspecifico(sala);
		Sala salaroja = new Sala(ColorDeSala.ROJO);
		Boolean validacionRoja = ins.getJardin().agregarCupoEspecifico(salaroja);
		assertTrue(validacionCELESTE);
		assertTrue(validacionRoja);
		
	}	
	@Test(expected = ComisionExistente.class) 
	public void noCrearDosSalasCELESTEDosVeces() throws ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		ins.getJardin().agregarCupoEspecifico(sala);
		Boolean validacion = ins.getJardin().agregarCupoEspecifico(sala);
		
		assertFalse(validacion);
	}	
	@Test
	public void asignoUnMaestroASalaCELESTERegistradoComoDocenteDentroDeLaInstitucion() throws ComisionExistente, CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia, DocenteNoEncontradoException{
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Docente maestro = new Docente("Juliana", "Martinez", 1112, 25);
		HistorialAcademico historial = new HistorialAcademico();
		historial.setJardinero(true);
		maestro.setExperiencia(historial);
		ins.incoportarDocente(maestro);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		ins.getJardin().agregarCupoEspecifico(sala);
		Boolean validacion = false;
		if (ins.buscarDocente(maestro.getDni()) != null) {
			validacion = sala.asignarMaestro(maestro);
		}
		assertTrue(validacion);	
	}	
	@Test
	public void asignoDosMaestroASalaCELESTERegistradoComoDocenteDentroDeLaInstitucion() throws ComisionExistente, CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia, DocenteNoEncontradoException{
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		HistorialAcademico historial = new HistorialAcademico();
		historial.setJardinero(true);
		Docente maestro = new Docente("Juliana", "Martinez", 1112, 25);
		ins.incoportarDocente(maestro);
		Docente segundoMaestro = new Docente("Julian", "Fernandez", 11111, 30);
		ins.incoportarDocente(segundoMaestro);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		ins.getJardin().agregarCupoEspecifico(sala);
		Boolean validacion = false;
		maestro.setExperiencia(historial);
		segundoMaestro.setExperiencia(historial);
		if (ins.buscarDocente(maestro.getDni()) != null) {
			sala.asignarMaestro(maestro);
		}
		if (ins.buscarDocente(segundoMaestro.getDni()) != null) {
			validacion = sala.asignarMaestro(segundoMaestro);
		}
		assertTrue(validacion);	
	}	
	@Test ()
	public void noAsignoMaestroASalaCELESTESinoEstaEnLaInstitucion() throws ComisionExistente, CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia{
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Docente maestro = new Docente("Juliana", "Martinez", 1112, 25);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		ins.getJardin().agregarCupoEspecifico(sala);
		Boolean validacion = false;
		
		if (ins.buscarDocente(maestro.getDni()) != null) {
			sala.asignarMaestro(maestro);
			validacion = true;
		}
		assertFalse(validacion);	
	}	
	@Test (expected=CantidadMaximaDocentesException.class)
	public void noAsignarTresMaestrosAunqueEstenRegistradosEnLaInstitucion() throws DocenteNoEncontradoException, ComisionExistente, CantidadMaximaDocentesException, DocenteNoCuentaConExperiencia{
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Docente maestro = new Docente("Juliana", "Martinez", 1112, 25);
		ins.incoportarDocente(maestro);
		Docente segundoMaestro = new Docente("Valentin", "Jerez", 1111, 45);
		ins.incoportarDocente(segundoMaestro);
		Docente extra = new Docente("Azul","Zapata", 111111, 22);
		ins.incoportarDocente(extra);
		Sala sala = new Sala(ColorDeSala.CELESTE);		
		ins.getJardin().agregarCupoEspecifico(sala);
		Boolean validacion = true;
		HistorialAcademico historial = new HistorialAcademico();
		historial.setJardinero(true);
		maestro.setExperiencia(historial);
		segundoMaestro.setExperiencia(historial);
		extra.setExperiencia(historial);
		if (ins.buscarDocente(maestro.getDni()) != null) {
			sala.asignarMaestro(maestro);
		}
		if (ins.buscarDocente(segundoMaestro.getDni()) != null) {
			sala.asignarMaestro(segundoMaestro);
		}
		if (ins.buscarDocente(extra.getDni()) != null) {
			validacion = sala.asignarMaestro(extra);			
		}		
		assertFalse(validacion);	
	}	
	public void agregarUnAlumnoASalaCELESTE() throws cantidadMaximaDeAlumnosSuperada, ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);	
		ins.getJardin().agregarCupoEspecifico(sala);
		Integer dni,edad;
		dni = 11111;
		edad = 4;
		
		Alumno alumno = new Alumno("Martin", "Gonzalez", dni, edad);
		
		ins.incoportarAlumno(alumno);
		Boolean validacion = false;
		if (ins.buscarAlumno(dni).equals(alumno)) {
			validacion = sala.agregarAlumno(alumno);
		}		
		assertTrue(validacion);
	}
	@Test
	public void noAgregarDosAlumnoASalaCELESTEconElMismoDNI() throws cantidadMaximaDeAlumnosSuperada, ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);	
		ins.getJardin().agregarCupoEspecifico(sala);
		Integer dni,edad;
		dni = 11111;
		edad = 4;
		Alumno alumno = new Alumno("Martin", "Gonzalez", dni, edad);
		ins.incoportarAlumno(alumno);
		Alumno segundoAlumno = new Alumno("Jose","Torres",dni, edad);
		ins.incoportarAlumno(segundoAlumno);
		
		sala.agregarAlumno(alumno);
		sala.agregarAlumno(segundoAlumno);
		
		assertEquals(1,sala.getColeccionAlumnos().size());		
	}	
	public void noSuperarLaCapacidadDeUnaSala() throws cantidadMaximaDeAlumnosSuperada, ComisionExistente {
		String nombre = "Unlam";			
		Institucion ins = new Institucion(nombre);
		Sala sala = new Sala(ColorDeSala.CELESTE);	
		ins.getJardin().agregarCupoEspecifico(sala);
		Integer dni,edad;
		dni = 11111;
		edad = 4;
		Boolean validacion = true;
		for (int i = 0; i < 10; i++) {
			Alumno alumno = new Alumno("Martin", "Gonzalez", dni++, edad);
			ins.incoportarAlumno(alumno);
			if (ins.buscarAlumno(dni) != null) {
				validacion = sala.agregarAlumno(alumno);
			}
			
		}
		
		assertFalse(validacion);	
	}
	
	
	
	
	
}
