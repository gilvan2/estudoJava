package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		
		try (PreparedStatement stm =  con.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO")){
			
			stm.execute();//Execute retorna true e esse resultado for uma lista, se for um update delet (opera~çoes que não retornam lista) ele será falso
			
			//Para pegar os resultados desse stm, usamos
			
			ResultSet rst = stm.getResultSet();
			
			while (rst.next()) {
				Integer id = rst.getInt("ID");
				System.out.println(id);
				
				String nome = rst.getString("NOME");
				System.out.println(nome);
				
				String descricao = rst.getString("DESCRICAO");
				System.out.println(descricao);
			}			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL OBTER A LISTAGEM DE PRODUTOS");
		}
		
		con.close();
	}

}
