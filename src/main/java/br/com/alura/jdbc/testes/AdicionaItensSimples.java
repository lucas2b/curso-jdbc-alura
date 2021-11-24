package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.db.PoolConexoes;

public class AdicionaItensSimples {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = PoolConexoes.getConnection();
		
		Statement stm = conn.createStatement();
		stm.execute("Insert into produto (nome, descricao) values ('mouse', 'mouse sem fio')", 
				Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stm.getGeneratedKeys();
		
		while(rs.next()) {
			System.out.println("ID Criado:" + rs.getString(1));
		}
		
		
		

	}

}
