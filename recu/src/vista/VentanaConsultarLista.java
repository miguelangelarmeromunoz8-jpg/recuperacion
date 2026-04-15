package vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.dto.PersonaDTO;

public class VentanaConsultarLista extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Coordinador coordinador; 
	private JTextArea txtAreaResultado;

	public VentanaConsultarLista(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal, modal);
		setTitle("Listado General");
		setSize(500, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		iniciarComponentes();
	}

	public void consultarListaPersonas() {
		if (coordinador == null)
			return;

		ArrayList<PersonaDTO> listaPersonas = coordinador.consultarListaPersonas();

		if (listaPersonas == null || listaPersonas.isEmpty()) {
			txtAreaResultado.setText("\n   No hay personas registradas actualmente.");
			return;
		}

		StringBuilder contenido = new StringBuilder();
		contenido.append("Resultados encontrados: ").append(listaPersonas.size()).append("\n");
		contenido.append("==============================\n\n");

		for (PersonaDTO persona : listaPersonas) {
			contenido.append(" Documento: ").append(persona.getDocumento()).append("\n");
			contenido.append(" Nombre:    ").append(persona.getNombre()).append("\n");
			contenido.append(" Edad:      ").append(persona.getEdad()).append("\n");
			contenido.append(" IMC:       ").append(persona.getImc()).append("\n");
			contenido.append(" Resultado: ").append(persona.getClasificacion()).append("\n");
			contenido.append(" ------------------------------\n");
		}

		txtAreaResultado.setText(contenido.toString());
		txtAreaResultado.setCaretPosition(0); 
	}

	private void iniciarComponentes() {
		JLabel lblTitulo = new JLabel("Lista de personas registradas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblTitulo.setBounds(10, 10, 480, 30);
		contentPane.add(lblTitulo);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setEditable(false);
		txtAreaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtAreaResultado.setLineWrap(true);
		txtAreaResultado.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
		scrollPane.setBounds(15, 50, 470, 310);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
	}

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador; 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}