package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class VentanaConsultaIndividual extends JDialog implements ActionListener {

	private Coordinador coordinador;
	private JButton btnConsulta;
	private JTextField txtNombre, txtEdad, txtPeso, txtEstatura, txtImc, txtClasificacion, txtDocumento;
	private JButton btnActualizar, btnEliminar;
	private JLabel lblDocumento, lblConsultaDeUsuarios;

	public VentanaConsultaIndividual(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setTitle("Consulta de Persona - IMC");
		setSize(420, 400); // Ajustado un poco el alto para los botones
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		lblConsultaDeUsuarios = new JLabel("consulta de los usuarios :) ");
		lblConsultaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaDeUsuarios.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblConsultaDeUsuarios.setBounds(17, 6, 390, 30);
		getContentPane().add(lblConsultaDeUsuarios);

		// Sección de búsqueda
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(20, 48, 100, 25);
		getContentPane().add(lblDocumento);

		txtDocumento = new JTextField();
		txtDocumento.setBounds(130, 48, 150, 28);
		getContentPane().add(txtDocumento);

		btnConsulta = new JButton("Buscar");
		btnConsulta.setBounds(290, 48, 90, 28);
		btnConsulta.addActionListener(this);
		getContentPane().add(btnConsulta);

		// Campos de información (agrupados para claridad)
		
		agregarCampo("Nombre:", 88, txtNombre = new JTextField(), 250);
		agregarCampo("Edad:", 126, txtEdad = new JTextField(), 80);
		agregarCampo("Peso (kg):", 164, txtPeso = new JTextField(), 80);
		agregarCampo("Estatura (m):", 202, txtEstatura = new JTextField(), 80);

		// Campos de solo lectura
		
		agregarCampo("IMC:", 240, txtImc = new JTextField(), 80);
		txtImc.setEditable(false);
		txtImc.setBackground(new Color(240, 240, 240));

		agregarCampo("Clasificación:", 278, txtClasificacion = new JTextField(), 150);
		txtClasificacion.setEditable(false);
		txtClasificacion.setBackground(new Color(240, 240, 240));

		// Acciones
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(20, 325, 150, 30);
		btnActualizar.addActionListener(this);
		getContentPane().add(btnActualizar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(180, 325, 150, 30);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
	}

	// Método auxiliar para no repetir código de etiquetas y campos
	
	private void agregarCampo(String label, int y, JTextField field, int width) {
		JLabel lbl = new JLabel(label);
		lbl.setBounds(20, y, 100, 25);
		getContentPane().add(lbl);
		field.setBounds(130, y, width, 28);
		getContentPane().add(field);
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConsulta) {
			consultar();
		} else if (e.getSource() == btnActualizar) {
			actualizarUsuario();
		} else if (e.getSource() == btnEliminar) {
			eliminarUsuario();
		}
	}

	private void consultar() {
		PersonaDTO miPersona = coordinador.consultarPersona(txtDocumento.getText());
		if (miPersona != null) {
			txtNombre.setText(miPersona.getNombre());
			txtEdad.setText(miPersona.getEdad() + "");
			txtPeso.setText(miPersona.getPeso() + "");
			txtEstatura.setText(miPersona.getEstatura() + "");
			txtImc.setText(miPersona.getImc() + "");
			txtClasificacion.setText(miPersona.getClasificacion());
		} else {
			JOptionPane.showMessageDialog(null, "Esta persona no fue encontrada", "Sin registros",
					JOptionPane.INFORMATION_MESSAGE);
			limpiar();
		}
	}

	private void actualizarUsuario() {
		PersonaDTO p = coordinador.consultarPersona(txtDocumento.getText());
		if (p != null) {
			p.setNombre(txtNombre.getText());
			p.setEdad(Integer.parseInt(txtEdad.getText().trim()));
			p.setPeso(Double.parseDouble(txtPeso.getText().trim()));
			p.setEstatura(Double.parseDouble(txtEstatura.getText().trim()));

			double imc = coordinador.calcularIMC(txtPeso.getText(), txtEstatura.getText());
			String clas = coordinador.obtenerClasificacion(imc);
			p.setImc(imc);
			p.setClasificacion(clas);

			if (coordinador.actualizarPersona(p).equals("ok")) {
				JOptionPane.showMessageDialog(null, "Los datos han sido actualizados");
				txtImc.setText(imc + "");
				txtClasificacion.setText(clas);
			}
		}
	}

	private void eliminarUsuario() {
		if (coordinador.eliminarPersona(txtDocumento.getText()).equals("ok")) {
			JOptionPane.showMessageDialog(null, "Los registro fueron eliminados");
			limpiar();
		}
	}

	private void limpiar() {
		txtNombre.setText("");
		txtEdad.setText("");
		txtPeso.setText("");
		txtEstatura.setText("");
		txtImc.setText("");
		txtClasificacion.setText("");
	}
}