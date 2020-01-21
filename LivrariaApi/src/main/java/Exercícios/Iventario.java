package Exercícios;

import java.util.HashMap;
import java.util.Map;

public class Iventario {
	private Map<Integer, Item> iventario = new HashMap<>();

	public Map<Integer, Item> getIventario() {
		return iventario;
	}

	public void setIventario(Map<Integer, Item> iventario) {
		this.iventario = iventario;
	}

}
