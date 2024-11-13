package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Alumno extends Persona implements Comparable<Alumno>{
	private HistorialAcademico historial;
	private HashSet<Asistencia> asistencias;
	private ArrayList<Evaluacion> evaluaciones;
	
	
	public Alumno(String nombre, String apellido, Integer dni, Integer edad) {
		super(nombre, apellido, dni, edad);
		this.asistencias = new HashSet<>(); // segun el Ministerio de Relaciones Exteriores y Culto un ciclo escolar tiene 190 dias
		this.evaluaciones = new ArrayList<>();
	}
	
	@Override
	public int compareTo(Alumno alumno) {
		if(this.dni.compareTo(alumno.dni)==0)
			return 0;
        int resultado = getApellido().compareTo(alumno.getApellido());

        if (resultado == 0) {
            resultado = this.getNombre().compareTo(alumno.getNombre());
        }
        return resultado;
	}
	
	public HistorialAcademico getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialAcademico historial) {
		this.historial = historial;
	}
	public HashSet<Asistencia> getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(HashSet<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	public ArrayList<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}
	public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + getNombre() + ", apellido="+ getApellido()+" dni=" + getDni() + ", edad=" + getEdad() + ", historial=" + historial
				+ ", asistencias=" + asistencias + ", evaluaciones=" + evaluaciones + "]";
	}
	


}
