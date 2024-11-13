package ar.edu.unlam.pb2.dominio;

public class Fecha {
	private final Integer ANIO = 2024;
	private Integer mes;
	private Integer dia;
	
	public Fecha(Integer mes, Integer dia) {
		this.mes = mes;
		this.dia = dia;
	}

	public Integer getMes() {
		return mes;
	}

	public Boolean setMes(Integer mes) {
		if (mes > 0 && mes <= 12) {
			this.mes = mes;
			return true;
		}
		return false;
	}

	public Integer getDia() {
		return dia;
	}

	public Boolean setDia(Integer dia) {
		if (dia > 0 && dia <= 31) {
			this.dia = dia;
			return true;
		}
		return false;
	}

	public Integer getAnio() {
		return ANIO;
	}

	@Override
	public String toString() {
		return "Fecha =" + dia + "/" + mes + "/" +  ANIO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ANIO == null) ? 0 : ANIO.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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
		Fecha other = (Fecha) obj;
		if (ANIO == null) {
			if (other.ANIO != null)
				return false;
		} else if (!ANIO.equals(other.ANIO))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (mes == null) {
			if (other.mes != null)
				return false;
		} else if (!mes.equals(other.mes))
			return false;
		return true;
	}
	
	

}
