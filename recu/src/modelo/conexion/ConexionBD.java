package modelo.conexion;

import java.util.HashMap;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class ConexionBD {
	
	public static HashMap<String, PersonaDTO> personasMap;
	private Coordinador Coordinador;

	public ConexionBD() {
		
		personasMap = new HashMap<String, PersonaDTO>();
	}

	public void setCoordinador(Coordinador Coordinador) {
		this.Coordinador = Coordinador;
	}
}