package br.com.jogoforca.nucleo;

import java.util.HashSet;
import java.util.Set;

public class Palavra {

	private static final char LETRA_SECRETA = '_';

	private String palavraOriginal;
	private Set<Character> letraEncontrada = new HashSet<>(); 
	private Set<Character> palavraEncontrada =  new HashSet<>();
	
	public Palavra(String palavraOriginal) {
		
		this.palavraOriginal = palavraOriginal.toUpperCase();
		
		char[] letrasArray = this.palavraOriginal.toCharArray();
		for (char c : letrasArray) {
			palavraEncontrada.add(c);
		}
	}
	
	public int tamanhoPalavra() {
		return palavraOriginal.length();
	}
	
	public boolean existeLetra(char c) {	
		c = Character.toUpperCase(c);
		if(palavraOriginal.indexOf(c) > -1) {
			letraEncontrada.add(c);
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		char[] letrasArray = palavraOriginal.toCharArray();
		
		for (int i = 0; i < letrasArray.length; i++) {
			char c = letrasArray[i];
			
			if(letraEncontrada.contains(c)) {
				sb.append(c);
			} else {
				sb.append(LETRA_SECRETA);
			}
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public boolean descobrir() {
		
		return letraEncontrada.equals(palavraEncontrada);
	}
	
	public String getPalavraOriginal() {
		return palavraOriginal;
	}
}
