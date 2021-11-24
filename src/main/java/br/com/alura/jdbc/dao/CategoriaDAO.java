package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.model.Categoria;

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

}
