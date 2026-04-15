package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class VentanaRegistro extends JDialog implements ActionListener {

	private Coordinador coordinador;
	private JTextField txtNombre, txtDocumento, txtEdad, txtPeso, txtEstatura;
	private JLabel lblResultado, lblRegistrarPersonas;
	private JButton btnRegistrar, btnConsultar;

	public VentanaRegistro(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setTitle("Registro de Personas");
		setSize(420, 360);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		lblRegistrarPersonas = new JLabel("Registro de Persona - IMC");
		lblRegistrarPersonas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarPersonas.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblRegistrarPersonas.setBounds(0, 10, 420, 30);
		getContentPane().add(lblRegistrarPersonas);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 55, 100, 25);
		getContentPane().add(lblNombre);
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 55, 260, 28);
		getContentPane().add(txtNombre);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(20, 93, 100, 25);
		getContentPane().add(lblDocumento);
		txtDocumento = new JTextField();
		txtDocumento.setBounds(130, 93, 150, 28);
		getContentPane().add(txtDocumento);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 131, 100, 25);
		getContentPane().add(lblEdad);
		txtEdad = new JTextField();
		txtEdad.setBounds(130, 131, 80, 28);
		getContentPane().add(txtEdad);

		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setBounds(20, 169, 100, 25);
		getContentPane().add(lblPeso);
		txtPeso = new JTextField();
		txtPeso.setBounds(130, 169, 80, 28);
		getContentPane().add(txtPeso);

		JLabel lblEstatura = new JLabel("Estatura (m):");
		lblEstatura.setBounds(20, 207, 100, 25);
		getContentPane().add(lblEstatura);
		txtEstatura = new JTextField();
		txtEstatura.setBounds(130, 207, 80, 28);
		getContentPane().add(txtEstatura);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(40, 255, 130, 30);
		btnRegistrar.addActionListener(this);
		getContentPane().add(btnRegistrar);

		btnConsultar = new JButton("Ver Listado");
		btnConsultar.setBounds(210, 255, 150, 30);
		btnConsultar.setVisible(false);
		btnConsultar.addActionListener(this);
		getContentPane().add(btnConsultar);

		lblResultado = new JLabel("Estado: Esperando datos", SwingConstants.CENTER);
		lblResultado.setBounds(20, 295, 380, 30);
		getContentPane().add(lblResultado);
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			procesarRegistro();
		} else if (e.getSource() == btnConsultar) {
			coordinador.mostrarVentanaConsultarLista();
		}
	}

	private void procesarRegistro() {
		
		boolean vNombre = coordinador.validarNombre(txtNombre.getText());
		boolean vDocumento = coordinador.validarNumero(txtDocumento.getText());
		boolean vEdad = coordinador.validarNumero(txtEdad.getText());
		boolean vPeso = coordinador.validarNumero(txtPeso.getText());
		boolean vEstatura = coordinador.validarNumero(txtEstatura.getText());

		verificaCampo(vNombre, txtNombre);
		verificaCampo(vDocumento, txtDocumento);
		verificaCampo(vEdad, txtEdad);
		verificaCampo(vPeso, txtPeso);
		verificaCampo(vEstatura, txtEstatura);

		if (vNombre && vDocumento && vEdad && vPeso && vEstatura) {
			double imc = coordinador.calcularIMC(txtPeso.getText(), txtEstatura.getText());
			String clasificacion = coordinador.obtenerClasificacion(imc);

			if (registrarPersona(imc, clasificacion)) {
				lblResultado.setText("IMC: " + imc + " | Clasificación: " + clasificacion);
				lblResultado.setForeground(new Color(0, 100, 0));
				btnConsultar.setVisible(true);
			} else {
				lblResultado.setText("Error: El documento ya está registrado.");
				lblResultado.setForeground(Color.RED);
			}
		} else {
			lblResultado.setText("Por favor, revise los campos en rojo.");
			lblResultado.setForeground(Color.RED);
			btnConsultar.setVisible(false);
		}
	}

	private boolean registrarPersona(double imc, String clasificacion) {
		try {
			PersonaDTO persona = new PersonaDTO();
			persona.setDocumento(txtDocumento.getText());
			persona.setNombre(txtNombre.getText());
			persona.setEdad(Integer.parseInt(txtEdad.getText().trim()));
			persona.setPeso(Double.parseDouble(txtPeso.getText().trim()));
			persona.setEstatura(Double.parseDouble(txtEstatura.getText().trim()));
			persona.setImc(imc);
			persona.setClasificacion(clasificacion);

			return coordinador.registrarPersona(persona).equalsIgnoreCase("si");
		} catch (Exception e) {
			return false;
		}
	}

	public void limpiarFormulario() {
		txtNombre.setText("");
		txtDocumento.setText("");
		txtEdad.setText("");
		txtPeso.setText("");
		txtEstatura.setText("");
		lblResultado.setText("Estado: Esperando datos");
		btnConsultar.setVisible(false);

		txtNombre.setBackground(Color.WHITE);
		txtDocumento.setBackground(Color.WHITE);
		txtEdad.setBackground(Color.WHITE);
		txtPeso.setBackground(Color.WHITE);
		txtEstatura.setBackground(Color.WHITE);
	}

	private void verificaCampo(boolean esValido, JTextField campo) {
		campo.setBackground(esValido ? Color.WHITE : new Color(255, 200, 200));
	}
}