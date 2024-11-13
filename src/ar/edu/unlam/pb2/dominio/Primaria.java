package ar.edu.unlam.pb2.dominio;

import java.util.ArrayList;
import java.util.Arrays;

public class Primaria extends NivelEducativo<Grado>{
	private static final Integer CANTIDAD_GRADOS = 6;

	public Primaria(String nombre) {
		super(nombre,CANTIDAD_GRADOS);
	}

	@Override
	public Boolean verificarCupoUnica(Grado grado) throws ComisionExistente {
		for (Grado g : comisiones) {
			if(g.getGrado().equals(grado.getGrado())){
				throw new ComisionExistente("ya existe una comision de esas caracteristicas");
			}
		}
		return false;
	}

	@Override
	public Boolean agregarCupoEspecifico(Grado grado) throws ComisionExistente {
		if (comisiones.size() >= CANTIDAD_GRADOS || verificarCupoUnica(grado)) {
			return false;
		}
		return comisiones.add(grado);
	}

	
}
