package br.com.alura.jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private String id;
	private String nome;
	private List<Produto> listaProdutos = new ArrayList<Produto>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public void adicionar(Produto produto) {
		listaProdutos.add(produto);
	}
	

}
