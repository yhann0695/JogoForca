package br.com.jogoforca.utils;

import java.util.Random;

public class RandomUtils {

	private static Random random = new Random();
	
	public static int novoNumeroRandomico(int min, int max) {
		return random.nextInt(max - min) + min;
	}
}
