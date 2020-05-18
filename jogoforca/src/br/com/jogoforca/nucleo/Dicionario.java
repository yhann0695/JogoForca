package br.com.jogoforca.nucleo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.jogoforca.jogo.JogoException;
import br.com.jogoforca.utils.RandomUtils;

public class Dicionario {

	private static final String FILE_NAME = "dicionario.txt";
	
	private static Dicionario instance;
	
	private List<String> palavras = new ArrayList<>();
	
	private Dicionario() {
		carregar();
	}
	
	public static Dicionario getInstance() {
		if(instance == null) {
			instance = new Dicionario();
		}
		return instance;
	}
	
	
	
	private void carregar() {
		
		try (Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
			
			while(scanner.hasNextLine()) {
				String palavra = scanner.nextLine().trim();
				palavras.add(palavra);
		}
			if(palavras.size() == 0) {
				throw new JogoException("Lista de palavras não pode ser vazia");
			}
		}
	}
	
	public Palavra proximaPalavra() {
		int posicao = RandomUtils.novoNumeroRandomico(0, palavras.size());
		return new Palavra(palavras.get(posicao));
	}
}
