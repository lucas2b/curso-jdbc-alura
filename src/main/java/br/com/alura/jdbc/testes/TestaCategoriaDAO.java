package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDAO;
import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.db.PoolConexoes;
import br.com.alura.jdbc.model.Categoria;
import br.com.alura.jdbc.model.Produto;

public class TestaCategoriaDAO {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = PoolConexoes.getConnection();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(conn);
		ProdutoDAO produtoDAO = new ProdutoDAO(conn);
		
		
		//------ Lista categorias utilizando consulta N+1 (má prática) -----
		
//		List<Categoria> listaCategorias = categoriaDAO.listaCategorias();
//		
//		listaCategorias.forEach(cat -> {
//			System.out.println("Id: " + cat.getId());
//			System.out.println("Nome: " + cat.getNome());
//			
//			try {
//				System.out.println("Produtos desta categoria:");
//				for(Produto produto : produtoDAO.buscarProdutoPorCategoria(cat)) {
//					System.out.println("-Nome: " + produto.getNome() + ", Descrição: " + produto.getDescricao());
//				}
//			} catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//			
//			
//		});
		
		
		
		List<Categoria> listaCategorias = categoriaDAO.listaCategoriasComProdutos();
		
		listaCategorias.forEach(cat -> {
			System.out.println("Id: " + cat.getId());
			System.out.println("Nome: " + cat.getNome());
			
				System.out.println("Produtos desta categoria:");
				for(Produto produto : cat.getListaProdutos()) {
					System.out.println("-Nome: " + produto.getNome() + ", Descrição: " + produto.getDescricao());
				}
			
			
		});

	}

}
