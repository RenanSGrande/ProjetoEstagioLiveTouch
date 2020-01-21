package Exercícios;

public class Item {
	private String nome;
	private double peso;
	private String habilidade;

	public Item(String nome, double peso, String habilidade) {
		this.nome = nome;
		this.peso = peso;
		this.habilidade = habilidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

}
