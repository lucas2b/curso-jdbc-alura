package br.com.alura.jdbc.db;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class PoolConexoes {
	
	private static DataSource dataSource;
	
	static {
		
		System.out.println("Instanciando propriedades est·ticas de PoolConexoes");
		
		ComboPooledDataSource comboPooledDS = new ComboPooledDataSource();
		comboPooledDS.setJdbcUrl("jdbc:mysql://localhost/loja-virtual-repository?useTimezone=true&serverTimezone=UTC");
		comboPooledDS.setUser("root");
		comboPooledDS.setPassword("rootroot");
		
		comboPooledDS.setMaxPoolSize(15);
		
		dataSource = comboPooledDS;
		
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection(); //devolve uma nova conex√£o
	}
	

}
