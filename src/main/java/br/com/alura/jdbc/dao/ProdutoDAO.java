package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.model.Categoria;
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
	
	public List<Produto> buscarProdutoPorCategoria(Categoria categoria) throws SQLException{
		
		PreparedStatement ps = null;
		ps = conn.prepareStatement("select * from produto where categoria_id = ?");
		ps.setString(1, categoria.getId());
		
		ResultSet rs = ps.executeQuery();
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		while(rs.next()) {
			
			Produto produto = new Produto();
			produto.setId(rs.getInt(1));
			produto.setNome(rs.getString(2));
			produto.setDescricao(rs.getString(3));
			
			listaProdutos.add(produto);
		}
		
		return listaProdutos;
		
		
		
	}
	


}
