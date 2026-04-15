package controlador;

import modelo.Procesos;
import modelo.conexion.ConexionBD;
import modelo.dao.PersonaDAO;
import vista.VentanaAcercaDe;
import vista.VentanaConsultaIndividual;
import vista.VentanaConsultarLista;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Relaciones {

	public Relaciones() {

		VentanaPrincipal principal = new VentanaPrincipal();
		VentanaRegistro registro = new VentanaRegistro(principal, true);
		VentanaConsultaIndividual consultaIndividual = new VentanaConsultaIndividual(principal, true);
		VentanaConsultarLista consultaLista = new VentanaConsultarLista(principal, true);
		VentanaAcercaDe acercaDe = new VentanaAcercaDe(principal, true);

		Procesos procesos = new Procesos();
		PersonaDAO personaDAO = new PersonaDAO();
		ConexionBD conexionBD = new ConexionBD();
		Coordinador coordinador = new Coordinador();

		principal.setCoordinador(coordinador);
		registro.setCoordinador(coordinador);
		consultaIndividual.setCoordinador(coordinador);
		consultaLista.setCoordinador(coordinador);
		acercaDe.setCoordinador(coordinador);

		personaDAO.setCoordinador(coordinador);
		conexionBD.setCoordinador(coordinador);
		procesos.setCoordinador(coordinador);

		coordinador.setVentanaPrincipal(principal);
		coordinador.setVentanaRegistro(registro);
		coordinador.setVentanaConsultaIndividual(consultaIndividual);
		coordinador.setVentanaConsultarLista(consultaLista);
		coordinador.setVentanaAcercaDe(acercaDe);
		coordinador.setProcesos(procesos);
		coordinador.setPersonaDAO(personaDAO);
		coordinador.setConexionBD(conexionBD);

		coordinador.mostrarVentanaPrincipal();
	}
}