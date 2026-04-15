package modelo.dto;

public class PersonaDTO {

	// Atributos que representan los datos de la persona
	
	private String documento;
	private String nombre;
	private int edad;
	private double peso;
	private double estatura;
	private double imc;
	private String clasificacion;

	public PersonaDTO() {
	}

	// Constructor para inicializar todos los campos a la vez
	
	public PersonaDTO(String documento, String nombre, int edad, double peso, double estatura, double imc,
			String clasificacion) {
		this.documento = documento;
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
		this.imc = imc;
		this.clasificacion = clasificacion;
	}

	// Métodos Getter y Setter
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Override
	public String toString() {
		return "PersonaDTO [documento=" + documento + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso
				+ ", estatura=" + estatura + ", imc=" + imc + ", clasificacion=" + clasificacion + "]";
	}
}