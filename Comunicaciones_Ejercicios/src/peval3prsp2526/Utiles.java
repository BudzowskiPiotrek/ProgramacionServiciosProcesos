package peval3prsp2526;

public class Utiles {

	public String criptar(String texto) {
		String textoCifrado = "";
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			char letraCifrada = (char) (caracter + 3);
			textoCifrado += letraCifrada;
		}
		return textoCifrado;
	}

	public String descriptar(String texto) {
		String textoCifrado = "";
		for (int i = 0; i < texto.length(); i++) {
			char caracter = texto.charAt(i);
			char letraCifrada = (char) (caracter - 3);
			textoCifrado += letraCifrada;
		}
		return textoCifrado;
	}
}
