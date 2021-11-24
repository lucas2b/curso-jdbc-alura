package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.model.Produto;

public class ProdutoDAO {
	
	private final Connection conn;
	
	public ProdutoDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}
	
	public boolean salvar(Produto produto) throws SQLException {
		
			PreparedStatement ps = null;
		
			ps = conn.prepareStatement("Insert into produto (nome, descricao) values (?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, produto.getNome());
			ps.setString(2, produto.getDescricao());
			
			return ps.execute();
		
	}
	


}
