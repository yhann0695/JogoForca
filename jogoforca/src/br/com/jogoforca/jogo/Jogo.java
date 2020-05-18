package br.com.jogoforca.jogo;

import java.util.HashSet;
import java.util.Set;

import br.com.jogoforca.nucleo.CaracterInvalidoException;
import br.com.jogoforca.nucleo.Dicionario;
import br.com.jogoforca.nucleo.Palavra;
import br.com.jogoforca.ui.UI;

public class Jogo {

	private static final int MAXIMO_DE_ERROS = 5;
	
	public void comecar() {
		
		UI.mostrarNaTela("======= Bem vindo ao jogo da Forca =======");
		
		Dicionario dicionario = Dicionario.getInstance();
		Palavra palavra = dicionario.proximaPalavra();
		
		UI.mostrarNaTela("A palavra tem " + palavra.tamanhoPalavra() + " letras");
		
		Set<Character> palavrasUsadas = new HashSet<>();
		int contadorDeErros = 0;
		
		while(true) {
			UI.mostrarNaTela(palavra);
			UI.pularLinha();
			
			char c; 
			
			try {
				c = UI.lerLetra("Digite uma letra");
				
				if(palavrasUsadas.contains(c)) {
					throw new CaracterInvalidoException("Esta letra já foi utilizada");
				}
						
				palavrasUsadas.add(c);
				
				if(palavra.existeLetra(c)) {
					UI.mostrarNaTela("Você acertou uma palavra");
				} else {
					contadorDeErros++;
					
					if(contadorDeErros < MAXIMO_DE_ERROS) {
						UI.mostrarNaTela("Você errou! Você ainda pode errar " + (MAXIMO_DE_ERROS - contadorDeErros) + " vez(es)");
					}
				}
				
				UI.pularLinha();
				
				if(palavra.descobrir()) {
					System.out.println("Parabens! você acertou a palavra completa: " + palavra.getPalavraOriginal());
					UI.mostrarNaTela("Fim do jogo!");
					break;
				}
				
				if(contadorDeErros == MAXIMO_DE_ERROS) {
					System.out.println("Você perdeu o jogo, a palavra correta é: " + palavra.getPalavraOriginal());
					System.out.println("Fim do jogo!");
					break;
				}
				
			} catch (CaracterInvalidoException e) {
				UI.mostrarNaTela("Erro: " +  e.getMessage());
				UI.pularLinha();
				
			}
		}
	}
}
