package controlador;

import java.util.ArrayList;

import modelo.Procesos;
import modelo.conexion.ConexionBD;
import modelo.dao.PersonaDAO;
import modelo.dto.PersonaDTO;
import vista.VentanaAcercaDe;
import vista.VentanaConsultaIndividual;
import vista.VentanaConsultarLista;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Coordinador {

	private VentanaPrincipal ventanaPrincipal;
	private VentanaRegistro ventanaRegistro;
	private VentanaConsultaIndividual ventanaConsultaIndividual;
	private VentanaConsultarLista ventanaConsultarLista;
	private VentanaAcercaDe ventanaAcercaDe;
	private Procesos procesos;
	private PersonaDAO personaDAO;
	private ConexionBD conexionBD;

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public void setVentanaRegistro(VentanaRegistro ventanaRegistro) {
		this.ventanaRegistro = ventanaRegistro;
	}

	public void setVentanaConsultaIndividual(VentanaConsultaIndividual ventanaConsultaIndividual) {
		this.ventanaConsultaIndividual = ventanaConsultaIndividual;
	}

	public void setVentanaConsultarLista(VentanaConsultarLista ventanaConsultarLista) {
		this.ventanaConsultarLista = ventanaConsultarLista;
	}

	public void setVentanaAcercaDe(VentanaAcercaDe ventanaAcercaDe) {
		this.ventanaAcercaDe = ventanaAcercaDe;
	}

	public void setProcesos(Procesos procesos) {
		this.procesos = procesos;
	}

	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}

	public void setConexionBD(ConexionBD conexionBD) {
		this.conexionBD = conexionBD;
	}

	// Métodos para mostrar las vistas

	public void mostrarVentanaPrincipal() {
		if (ventanaPrincipal != null)
			ventanaPrincipal.setVisible(true);
	}

	public void mostrarVentanaRegistro() {
		if (ventanaRegistro != null) {
			ventanaRegistro.limpiarFormulario();
			ventanaRegistro.setVisible(true);
		}
	}

	public void mostrarVentanaConsultaIndividual() {
		if (ventanaConsultaIndividual != null)
			ventanaConsultaIndividual.setVisible(true);
	}

	public void mostrarVentanaConsultarLista() {
		// Verificamos que tanto la ventana como el DAO existan antes de llamar
		if (ventanaConsultarLista != null && personaDAO != null) {
			ventanaConsultarLista.consultarListaPersonas();
			ventanaConsultarLista.setVisible(true);
		} else {
			System.out.println("Error: No se puede abrir la lista. Verifique las relaciones.");
		}
	}

	public void mostrarVentanaAcercaDe() {
		if (ventanaAcercaDe != null)
			ventanaAcercaDe.setVisible(true);
	}

	public boolean validarNombre(String valor) {
		return procesos != null && procesos.validarNombre(valor);
	}

	public boolean validarNumero(String valor) {
		return procesos != null && procesos.validarNumero(valor);
	}

	public double calcularIMC(String peso, String estatura) {
		return procesos != null ? procesos.calcularIMC(peso, estatura) : 0;
	}

	public String obtenerClasificacion(double imc) {
		return procesos != null ? procesos.obtenerClasificacion(imc) : "Error";
	}

	public String registrarPersona(PersonaDTO persona) {
		return personaDAO != null ? personaDAO.registrarPersona(persona) : "error";
	}

	public PersonaDTO consultarPersona(String documento) {
		return personaDAO != null ? personaDAO.consultarPersonaPorDocumento(documento) : null;
	}

	public ArrayList<PersonaDTO> consultarListaPersonas() {
		return personaDAO != null ? personaDAO.consultarListaPersonas() : new ArrayList<>();
	}

	public String actualizarPersona(PersonaDTO personaNueva) {
		return personaDAO != null ? personaDAO.actualizarPersona(personaNueva) : "error";
	}

	public String eliminarPersona(String documento) {
		return personaDAO != null ? personaDAO.eliminarPersona(documento) : "error";
	}
}