package modelo;

import controlador.Coordinador;

public class Procesos {

	private Coordinador coordinador;

	public void setCoordinador(Coordinador coordinador) {
		this.coordinador = coordinador;
	}

	public String obtenerDatos(String nombre) {
		return "Bienvenido " + nombre.trim().toUpperCase();
	}

	public double calcularIMC(String pesoTexto, String estaturaTexto) {
		try {
			double peso = Double.parseDouble(pesoTexto);
			double estatura = Double.parseDouble(estaturaTexto);
			double imc = peso / (estatura * estatura);
			return Math.round(imc * 100.0) / 100.0;
		} catch (Exception e) {
			return 0;
		}
	}

	public String obtenerClasificacion(double imc) {
		if (imc < 18.5) {
			return "Bajo peso";
		} else if (imc <= 24.9) {
			return "Normal";
		} else if (imc <= 29.9) {
			return "Sobrepeso";
		} else {
			return "Obesidad";
		}
	}

	public boolean validarNombre(String valor) {
		String texto = valor.trim();
		if (texto.isEmpty()) {
			return false;
		}
		try {
			Double.parseDouble(texto);
			return false; // Si se puede convertir a número, no es un nombre válido
		} catch (NumberFormatException e) {
			return true;
		}
	}

	public boolean validarNumero(String valor) {
		try {
			return Double.parseDouble(valor) > 0;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validarPeso(String valor) {
		try {
			double num = Double.parseDouble(valor);
			return num > 0 && num <= 500;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validarEstatura(String valor) {
		try {
			double num = Double.parseDouble(valor);
			return num >= 0.5 && num <= 2.8;
		} catch (Exception e) {
			return false;
		}
	}
}