package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		System.out.println("Fechando a conexão");
		con.close();

	}
}
