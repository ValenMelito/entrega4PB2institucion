package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;

public abstract class NivelEducativo <T>{
	
	protected String nombre;
	protected ArrayList<T> comisiones= new ArrayList<>();
	protected Integer cantidadComisiones;
	

	public NivelEducativo(String nombre, Integer cantidadComisiones) {
		this.nombre = nombre;
		this.cantidadComisiones = cantidadComisiones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<T> getSalones() {
		return comisiones;
	}

	public void setSalones(ArrayList<T> salones) {
		this.comisiones = salones;
	}

	public Integer getCantidadSalitas() {
		return cantidadComisiones;
	}

	public void setCantidadSalitas(Integer cantidadSalitas) {
		this.cantidadComisiones = cantidadSalitas;
	}

	public abstract Boolean verificarCupoUnica(T entradaEspecifica) throws ComisionExistente;
	
	public abstract Boolean agregarCupoEspecifico(T entradaEspecifica) throws ComisionExistente;

	@Override
	public String toString() {
		return "NivelEducativo [nombre=" + nombre + ", comisiones=" + comisiones + ", cantidadComisiones="
				+ cantidadComisiones + "]";
	}
	
	
	
}
