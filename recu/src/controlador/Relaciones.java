package controlador;

import modelo.Procesos;
import modelo.conexion.ConexionBD;
import modelo.dao.PersonaDAO;
// Simplificado para evitar errores de clase no encontrada
import vista.VentanaAcercaDe;
import vista.VentanaConsultaIndividual;
import vista.VentanaConsultarLista;
import vista.VentanaPrincipal;
import vista.VentanaRegistro;

public class Relaciones {

	public Relaciones() {

		// 1. Instancia de las ventanas
		VentanaPrincipal principal = new VentanaPrincipal();
		VentanaRegistro registro = new VentanaRegistro(principal, true);
		VentanaConsultaIndividual consultaIndividual = new VentanaConsultaIndividual(principal, true);
		VentanaConsultarLista consultaLista = new VentanaConsultarLista(principal, true);
		VentanaAcercaDe acercaDe = new VentanaAcercaDe(principal, true);

		// 2. Instancia de la lógica, persistencia y control
		Procesos procesos = new Procesos();
		PersonaDAO personaDAO = new PersonaDAO();
		ConexionBD conexionBD = new ConexionBD();
		Coordinador coordinador = new Coordinador();

		// 3. Vinculación de las vistas con el coordinador
		principal.setCoordinador(coordinador);
		registro.setCoordinador(coordinador);
		consultaIndividual.setCoordinador(coordinador);
		consultaLista.setCoordinador(coordinador);
		acercaDe.setCoordinador(coordinador);

		// 4. Vinculación del modelo con el coordinador
		personaDAO.setCoordinador(coordinador);
		conexionBD.setCoordinador(coordinador);
		procesos.setCoordinador(coordinador);

		// 5. Configuración central en el coordinador
		// Aseguramos que el coordinador conozca todas sus partes para evitar el
		// NullPointerException
		coordinador.setVentanaPrincipal(principal);
		coordinador.setVentanaRegistro(registro);
		coordinador.setVentanaConsultaIndividual(consultaIndividual);
		coordinador.setVentanaConsultarLista(consultaLista);
		coordinador.setVentanaAcercaDe(acercaDe);
		coordinador.setProcesos(procesos);
		coordinador.setPersonaDAO(personaDAO);
		coordinador.setConexionBD(conexionBD);

		// 6. Inicio de la aplicación
		coordinador.mostrarVentanaPrincipal();
	}
}