package Exercícios;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Exercicio02 {

	public static void main(String[] args) {
		Iventario iventario = new Iventario();
		final int tamanhoIventario = 3;

		pegarItem(new Item("Espada", 1.1, "Corte"), iventario, tamanhoIventario);
		pegarItem(new Item("Escudo", 7, "Defesa"), iventario, tamanhoIventario);
		pegarItem(new Item("Armadura", 30, "Defesa"), iventario, tamanhoIventario);
		pegarItem(new Item("Machado", 1.5, "Corte"), iventario, tamanhoIventario);
		mostrarIventario(iventario);
		mostraItemPorPosicao(iventario, 0);
		mostraItemPorPosicao(iventario, 1);
		mostraItemPorPosicao(iventario, 2);

	}

	private static void pegarItem(Item item, Iventario iventario, int tamanhoIventario) {
		if (iventario.getIventario().size() < tamanhoIventario) {
			iventario.getIventario().put(iventario.getIventario().size(), item);
			System.out.println("Item: " + item.getNome().toUpperCase() + " adicionado!!!");
		} else {
			System.out.println(
					"Iventário cheio, não foi possível adicionar o item: " + item.getNome().toUpperCase() + "!!");
		}
	}

	private static void mostrarIventario(Iventario iventario) {
		Set<Entry<Integer, Item>> set = iventario.getIventario().entrySet();
		Iterator<Entry<Integer, Item>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Entry<Integer, Item> item = iterator.next();
			System.out.print("Item:" + item.getValue().getNome() + " | ");
			System.out.print("Peso:" + item.getValue().getPeso() + "Kg | ");
			System.out.print("Habilidade: " + item.getValue().getHabilidade() + " | ");
			System.out.println("Posição no iventário: " + item.getKey() + " | ");

		}
	}

	private static void mostraItemPorPosicao(Iventario iventario, int posicao) {
		Item item = iventario.getIventario().get(posicao);
		System.out.print("Item:" + item.getNome() + " | ");
		System.out.print("Peso:" + item.getPeso() + "Kg | ");
		System.out.println("Habilidade: " + item.getHabilidade() + " | ");
	}

}
