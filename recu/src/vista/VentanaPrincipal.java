package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Coordinador Coordinador;
	private JButton btnRegistrar;
	private JButton btnConsultarPersona;
	private JButton btnConsultarLista;
	private JButton btnAcercaDe;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); // Centra la ventana en pantalla

		iniciarComponentes();
	}

	private void iniciarComponentes() {

		// Título y descripción de la ventana

		JLabel lblTitulo = new JLabel("Sistema de calculo imc");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblTitulo.setBounds(33, 6, 388, 30);
		contentPane.add(lblTitulo);

		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setText("Esta aplicacion permite calcular el Indice de Masa Corporal IMC,\n"
				+ "se tienen diferentes validaciones separando las responsabilidades\n"
				+ "de cada clase y usando el coordinador para delegar los llamados.\n\n"
				+ "Ingrese a las diferentes opciones y pruebe el funcionamiento.");
		txtrDescripcion.setEditable(false);
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setWrapStyleWord(true);
		txtrDescripcion.setBounds(21, 48, 410, 110);
		contentPane.add(txtrDescripcion);

		// Configuración de los botones del menú

		btnRegistrar = new JButton("Registrar Persona");
		btnRegistrar.setBounds(16, 175, 415, 29);
		btnRegistrar.addActionListener(this);
		contentPane.add(btnRegistrar);

		btnConsultarPersona = new JButton("Consultar Persona");
		btnConsultarPersona.setBounds(16, 212, 415, 29);
		btnConsultarPersona.addActionListener(this);
		contentPane.add(btnConsultarPersona);

		btnConsultarLista = new JButton("Consultar Lista de Personas");
		btnConsultarLista.setBounds(16, 249, 415, 29);
		btnConsultarLista.addActionListener(this);
		contentPane.add(btnConsultarLista);

		btnAcercaDe = new JButton("Acerca de");
		btnAcercaDe.setBounds(16, 286, 415, 29);
		btnAcercaDe.addActionListener(this);
		contentPane.add(btnAcercaDe);
	}

	public void setCoordinador(Coordinador Coordinador) {
		this.Coordinador = Coordinador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Gestión de eventos para abrir las otras ventanas

		if (e.getSource() == btnRegistrar) {
			Coordinador.mostrarVentanaRegistro();
		} else if (e.getSource() == btnConsultarPersona) {
			Coordinador.mostrarVentanaConsultaIndividual();
		} else if (e.getSource() == btnConsultarLista) {
			Coordinador.mostrarVentanaConsultarLista();
		} else if (e.getSource() == btnAcercaDe) {
			Coordinador.mostrarVentanaAcercaDe();
		}
	}
}