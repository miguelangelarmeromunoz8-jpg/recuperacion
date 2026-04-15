package modelo.dao;

import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.ConexionBD;
import modelo.dto.PersonaDTO;

public class PersonaDAO {

	private Coordinador Coordinador;

	// Guarda una nueva persona si el documento no existe
	
	public String registrarPersona(PersonaDTO persona) {
		if (!ConexionBD.personasMap.containsKey(persona.getDocumento())) {
			ConexionBD.personasMap.put(persona.getDocumento(), persona);
			return "si";
		}
		return "no";
	}

	// Busca a alguien por su número de identificación
	
	public PersonaDTO consultarPersonaPorDocumento(String documento) {
		if (ConexionBD.personasMap.containsKey(documento)) {
			return ConexionBD.personasMap.get(documento);
		}
		return null;
	}

	// Pasa todos los datos del mapa a una lista para las tablas
	
	public ArrayList<PersonaDTO> consultarListaPersonas() {
		return new ArrayList<PersonaDTO>(ConexionBD.personasMap.values());
	}

	// Actualiza los datos si encuentra el documento
	
	public String actualizarPersona(PersonaDTO persona) {
		if (ConexionBD.personasMap.containsKey(persona.getDocumento())) {
			ConexionBD.personasMap.put(persona.getDocumento(), persona);
			return "ok";
		}
		return "error";
	}

	// Quita a una persona del mapa de datos
	
	public String eliminarPersona(String documento) {
		if (ConexionBD.personasMap.containsKey(documento)) {
			ConexionBD.personasMap.remove(documento);
			return "ok";
		}
		return "error";
	}

	public void setCoordinador(Coordinador Coordinador) {
		this.Coordinador = Coordinador;
	}
}