package modelo.conexion;

import java.util.HashMap;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class ConexionBD {

	// Simulación de base de datos usando un mapa
	
	public static HashMap<String, PersonaDTO> personasMap;
	private Coordinador Coordinador;

	public ConexionBD() {
		// Inicializamos el contenedor de los datos
		
		personasMap = new HashMap<String, PersonaDTO>();
	}

	public void setCoordinador(Coordinador Coordinador) {
		this.Coordinador = Coordinador;
	}
}