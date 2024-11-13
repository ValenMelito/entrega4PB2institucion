package ar.edu.unlam.pb2.dominio;

public class Materia {
	private Integer id;
	private String nombre;
	private Docente docente;

	public Materia(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Boolean bajaDocente() {
		if (this.docente != null) {
			this.docente = null;
			return true;
		}
		return false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean asignarDocente(Docente docente, Materia materia) {

		if (tieneExperienciaEnMateria(materia)) {
			setDocente(docente);
			return true;
		}
		return false;

	}
	
	public Boolean tieneExperienciaEnMateria(Materia materia) {

		for (int i = 0; i < docente.getExperiencia().getMaterias().length; i++) {
			if (docente.getExperiencia().getMaterias()[i].getNombre().equals(materia.getNombre())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Materia other = (Materia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
