package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.db.PoolConexoes;

public class RemoveItensSimples {

	public static void main(String[] args) throws SQLException {
		
			Connection conn = PoolConexoes.getConnection();
			
			Statement stm = conn.createStatement();
			stm.execute("Delete from produto where id > 2");
			
			if(stm.getUpdateCount()>0) {
				
				System.out.println("Delete executado com sucesso!");
				System.out.println("Foram deletados " + stm.getUpdateCount() + " registros.");
			}else {
				
				System.out.println("Nenhum registro deletado");
			}
			
		
		
		

	}

}
