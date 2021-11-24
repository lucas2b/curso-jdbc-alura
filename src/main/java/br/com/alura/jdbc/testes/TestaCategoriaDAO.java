package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.db.PoolConexoes;
import br.com.alura.jdbc.model.Categoria;

public class TestaCategoriaDAO {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = PoolConexoes.getConnection();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
		
		List<Categoria> listaCategorias = categoriaDAO.listaCategorias();
		
		listaCategorias.forEach(cat -> {
			System.out.println("Id: " + cat.getId());
			System.out.println("Nome: " + cat.getNome());
		});

	}

}
