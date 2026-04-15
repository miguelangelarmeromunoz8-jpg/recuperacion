package modelo.dao;

import java.util.ArrayList;

import controlador.Coordinador;
import modelo.conexion.ConexionBD;
import modelo.dto.PersonaDTO;

public class PersonaDAO {

	private Coordinador Coordinador;
	
	public String registrarPersona(PersonaDTO persona) {
		if (!ConexionBD.personasMap.containsKey(persona.getDocumento())) {
			ConexionBD.personasMap.put(persona.getDocumento(), persona);
			return "si";
		}
		return "no";
	}
	
	public PersonaDTO consultarPersonaPorDocumento(String documento) {
		if (ConexionBD.personasMap.containsKey(documento)) {
			return ConexionBD.personasMap.get(documento);
		}
		return null;
	}
	
	public ArrayList<PersonaDTO> consultarListaPersonas() {
		return new ArrayList<PersonaDTO>(ConexionBD.personasMap.values());
	}
	
	public String actualizarPersona(PersonaDTO persona) {
		if (ConexionBD.personasMap.containsKey(persona.getDocumento())) {
			ConexionBD.personasMap.put(persona.getDocumento(), persona);
			return "ok";
		}
		return "error";
	}

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