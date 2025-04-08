package com.controle.estoque;

public class Item {
	private String nome;
	private String tipo;
	private int quantidade;
	private String local;
	private String dataEntrada;
	
	public Item(String nome, String tipo, int quantidade, String local, String dataEntrada) {
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.local = local;
		this.dataEntrada = dataEntrada;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getLocal() {
		return local;
	}
	
	
}
