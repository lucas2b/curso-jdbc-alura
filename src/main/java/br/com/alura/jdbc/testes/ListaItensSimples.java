package br.com.alura.jdbc.testes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.db.PoolConexoes;

public class ListaItensSimples {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = PoolConexoes.getConnection();
		
		PreparedStatement ps =  conn.prepareStatement("select * from produto");
		ResultSet rs =  ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: " + rs.getString(1));
			System.out.println("Nome: " + rs.getString(2));
			System.out.println("Descrição: " + rs.getString(3));
		}
		
		conn.close();

	}

}
