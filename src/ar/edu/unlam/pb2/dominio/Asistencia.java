package ar.edu.unlam.pb2.dominio;

public class Asistencia {
	
	private Fecha fecha;
	private Boolean asistencia;
	
	public Asistencia(Fecha fecha, Boolean asistencia) {		
		this.fecha = fecha;
		this.asistencia = asistencia;
	}

	
	public Boolean isAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Boolean asistencia) {
		this.asistencia = asistencia;
	}
	
	public Fecha getFecha() {
		return fecha;
	}


	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Asistencia [fecha=" + fecha + ", asistencia=" + asistencia + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asistencia other = (Asistencia) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		return true;
	}
	
	

}
