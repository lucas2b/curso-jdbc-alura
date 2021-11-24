package br.com.alura.jdbc.testes;

import java.sql.SQLException;

import br.com.alura.jdbc.db.PoolConexoes;

public class TesteNumeroConexoesPool {

	public static void main(String[] args) throws SQLException {
		
		
		//Limite foi definido em 15 conexões
		for(int i = 0; i < 20; i++) {
			PoolConexoes.getConnection();
			System.out.println("Conexao de número:" + (i+1));
		}

	}

}
