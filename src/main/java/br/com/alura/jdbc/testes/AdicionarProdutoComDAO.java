package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.db.PoolConexoes;
import br.com.alura.jdbc.model.Produto;

public class AdicionarProdutoComDAO {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = PoolConexoes.getConnection();
		
		ProdutoDAO produtoDAO = new ProdutoDAO(conn);
		
		Produto produto = new Produto();
		produto.setNome("TV");
		produto.setDescricao("TV Smart");
		
		produtoDAO.salvar(produto);

	}

}
