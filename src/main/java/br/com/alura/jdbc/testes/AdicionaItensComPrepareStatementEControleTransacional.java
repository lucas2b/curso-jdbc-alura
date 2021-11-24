package br.com.alura.jdbc.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.db.PoolConexoes;


public class AdicionaItensComPrepareStatementEControleTransacional {

	public static void main(String[] args) throws SQLException {		
		
		Connection conn = PoolConexoes.getConnection();
		conn.setAutoCommit(false);
		
		PreparedStatement ps = null;
		
		try {
		
			ps = conn.prepareStatement("Insert into produto (nome, descricao) values (?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			
			passarParametrosEInserir("mouse", "mouse sem fio", ps);
			passarParametrosEInserir("caixa de som", "caixa de som 45w", ps);
			
			conn.commit();
		
		}catch(Exception e) {
			
			e.printStackTrace();
			System.out.println("EXECUTANDO ROLLBACK");
			conn.rollback();
			
		}finally {
			
			//Fechando recursos
			conn.close();
			ps.close();
			
		}
	}

	private static void passarParametrosEInserir(String nomeProd, String descProd, PreparedStatement ps)
			throws SQLException {
		ps.setString(1, nomeProd);
		ps.setString(2, descProd);
		
		//Simulando uma interrupção da transação (quebra de atomicidade)
//		if(descProd.contains("som")) {
//			throw new RuntimeException("Erro ao inserir caixa de som");
//		}
		
		ps.execute();
		
		ResultSet rs = ps.getGeneratedKeys();
		
		while(rs.next()) {
			System.out.println("ID Criado:" + rs.getString(1));
		}
	}

}
