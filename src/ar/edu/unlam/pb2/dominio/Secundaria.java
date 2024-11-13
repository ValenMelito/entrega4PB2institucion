package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Secundaria extends NivelEducativo<Anio>{
	private static final Integer CANTIDAD_ANIOS = 6;
	
	public Secundaria(String nombre) {
		super(nombre,CANTIDAD_ANIOS);
	}

	@Override
	public Boolean verificarCupoUnica(Anio anio) throws ComisionExistente {
		for (Anio a : comisiones) {
			if(a.getAnio().equals(anio.getAnio())){
				throw new ComisionExistente("ya existe una comision de esas caracteristicas");
			}
		}
		return false;
	}

	@Override
	public Boolean agregarCupoEspecifico(Anio anio) throws ComisionExistente {
		if (comisiones.size() >= CANTIDAD_ANIOS || verificarCupoUnica(anio)) {
			return false;
		}
		return comisiones.add(anio);
	}

	
	
	
	
}
