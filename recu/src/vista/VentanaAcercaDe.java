package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controlador.Coordinador;

public class VentanaAcercaDe extends JDialog implements ActionListener {

	private Coordinador Coordinador;
	private JButton btnCerrar;

	public VentanaAcercaDe(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setTitle("Acerca de");
		setSize(420, 320);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("informacion del desarrolador osea mi jajaja");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitulo.setBounds(0, 10, 420, 30);
		getContentPane().add(lblTitulo);

		JSeparator sep = new JSeparator();
		sep.setBounds(20, 48, 380, 2);
		getContentPane().add(sep);
		
		crearEtiqueta("Nombre:", "Miguel Angel Armero Muñoz", 62);
		crearEtiqueta("Programa:", "ADSO - SENA", 97);
		crearEtiqueta("Especialidad:", "desarrollador de sofware", 132);
		crearEtiqueta("Fecha:", "2026", 167);

		JSeparator sep2 = new JSeparator();
		sep2.setBounds(20, 202, 380, 2);
		getContentPane().add(sep2);

		JLabel lblDesc = new JLabel("Cálculo de IMC con patrón MVC y POO.");
		lblDesc.setFont(new Font("Arial", Font.ITALIC, 12));
		lblDesc.setForeground(new Color(100, 100, 100));
		lblDesc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesc.setBounds(30, 220, 360, 20);
		getContentPane().add(lblDesc);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(145, 255, 130, 30);
		btnCerrar.addActionListener(this);
		getContentPane().add(btnCerrar);
	}
	
	private void crearEtiqueta(String titulo, String valor, int y) {
		JLabel et = new JLabel(titulo);
		et.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		et.setBounds(30, y, 120, 25);
		getContentPane().add(et);

		JLabel val = new JLabel(valor);
		val.setBounds(160, y, 230, 25);
		getContentPane().add(val);
	}

	public void setCoordinador(Coordinador Coordinador) {
		this.Coordinador = Coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			dispose(); // Cierra y libera los recursos de la ventana
		}
	}
}