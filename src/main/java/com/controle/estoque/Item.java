package com.controle.estoque;

public class Item {
    private int id; // novo campo
    private String nome;
    private String tipo;
    private int quantidade;
    private String local;
    private String dataEntrada;

    // Construtor usado ao carregar do banco (com id)
    public Item(int id, String nome, String tipo, int quantidade, String local, String dataEntrada) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.local = local;
        this.dataEntrada = dataEntrada;
    }

//    // Construtor usado ao criar novo item (sem id)
//    public Item(String nome, String tipo, int quantidade, String local, String dataEntrada) {
//        this.nome = nome;
//        this.tipo = tipo;
//        this.quantidade = quantidade;
//        this.local = local;
//        this.dataEntrada = dataEntrada;
//    }
    
    public Item(String nome, String tipo, int quantidade, String local, String dataEntrada) {
        this(-1, nome, tipo, quantidade, local, dataEntrada);
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public void setId(int id) { // necessário para salvar id gerado no banco
        this.id = id;
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
    
    public String getDataEntrada() {
    	return dataEntrada;
    }
    
}
