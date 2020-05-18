package br.com.jogoforca.ui;

import java.util.Scanner;

import br.com.jogoforca.nucleo.CaracterInvalidoException;

public class UI {

	public static void mostrarNaTela(Object object) {
		System.out.println(object);
	}
	
	public static void pularLinha() {
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	public static char lerLetra(String text)throws CaracterInvalidoException {
		System.out.println(text + " ");
		
		Scanner scanner = new Scanner(System.in);
		String linha = scanner.nextLine();
		
		if(linha.trim().isEmpty()) {
			throw new CaracterInvalidoException("Nenhuma letra foi digitada");
		}
		
		if(linha.length() > 1) {
			throw new CaracterInvalidoException("Apenas uma letra deve ser digitado");
		}
		
		char c = linha.charAt(0);
		
		if(!Character.isLetter(c)) {
			throw new CaracterInvalidoException("Apenas letras devem ser digitadas");
		}
		
		return c;
				
	}
	
	
}
