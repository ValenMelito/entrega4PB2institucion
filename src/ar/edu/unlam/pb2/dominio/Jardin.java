package ar.edu.unlam.pb2.dominio;
import java.util.ArrayList;

public class Jardin extends NivelEducativo<Sala>{
	
	private static final Integer CANTIDAD_SALAS = 4;
	
	public Jardin(String nombre) {
		super(nombre,CANTIDAD_SALAS);

	}

	@Override
	public Boolean verificarCupoUnica(Sala sala) throws ComisionExistente {
		for (Sala s : comisiones) {
			if (s.getColor() == sala.getColor()) {
				throw new ComisionExistente("ya existe una comision de esas caracteristicas");
			}
		}
		return false;
	}

	@Override
	public Boolean agregarCupoEspecifico(Sala sala) throws ComisionExistente {
		if (comisiones.size() >= CANTIDAD_SALAS || verificarCupoUnica(sala)) {
			return false;
		}
		return comisiones.add(sala);
	}
	
	
}
