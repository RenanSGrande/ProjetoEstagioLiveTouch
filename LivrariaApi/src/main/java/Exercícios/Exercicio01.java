package Exercícios;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Exercicio01 {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Pedro");
		lista.add("Maria");
		lista.add("Joana");
		lista.add("André");
		lista.add("Carlos");
		lista.add("anna");
		lista.add("augusto");
		lista.add("Henrique");

		selecionarPalavraComecaLetraA(lista);
	}

	private static void selecionarPalavraComecaLetraA(List<String> palavras) {
		for (String palavra : palavras) {
			if (StringUtils.startsWithIgnoreCase(palavra, "a"))
				System.out.println(palavra);
		}
	}
}
