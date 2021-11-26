package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

public class CategoriaDAO {
	
	private Connection conn;
	
	public CategoriaDAO(Connection conn) {
		this.conn = conn;
	}
	
	public List<Categoria> listaCategorias() throws SQLException{
		
		Statement stm = conn.createStatement();
		stm.execute("Select * from categoria");
		
		ResultSet rs = stm.getResultSet();
		
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		while(rs.next()) {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getString(1));
			categoria.setNome(rs.getString(2));
			
			listaCategorias.add(categoria);
			
		}
		
		return listaCategorias;
	}
	
	public List<Categoria> listaCategoriasComProdutos() throws SQLException{
		
		Categoria ultima = null;
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		
		Statement stm = conn.createStatement();
		stm.execute("select * from categoria c join produto p on c.id = p.categoria_id order by c.id");
		
		ResultSet rs = stm.getResultSet();
		
		while(rs.next()) {
			
			if(ultima == null || !ultima.getNome().equals(rs.getString(2))) {
				
				Categoria categoria = new Categoria();
				categoria.setId(rs.getString(1));
				categoria.setNome(rs.getString(2));
				
				ultima = categoria;
				listaCategorias.add(categoria);
			}
			
			Produto produto = new Produto();
			produto.setId(rs.getInt(3));
			produto.setNome(rs.getString(4));
			produto.setDescricao(rs.getString(5));
			ultima.adicionar(produto);
			
			
		}
		
		return listaCategorias;
	
	}
	
}