package br.com.estudo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Simuila inserção com parametros e previne sql injection
public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {
		
		//String nome = "MOUSE'";
		///String descricao = "MOUSE SEM FIO);DELET * FROM PRODUTO";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		
		//Nesse momento, comecei a controlar a transação, eu digo qunado ela começa e obrigatoriamente preciso dizer quando a transação termina
		//Caso contrário, os valores não serão salvos no banco quando a conexão for fechada
		con.setAutoCommit(false);
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		//Agoera, ao inves de receber um statement, ele prepara um statement e deixa a responsabilidade da escrita do sql para o java
		//colocando o prepareStatement, eu não vou preicisar explicitar o fechamento do mesmo
		try (PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);){
			
			
			
			
			insereProduto("SmartTv", "45 polegadas", stm);
			
			insereProduto("Radio", "Radio de bateria", stm);
			
			con.commit();
			con.close();
			
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println("ROLLBACK EXECUTADO");
			con.rollback();
		}
	}
//Alt + Shift + M (Transforma o trecho selecionade em um método (eclipse shrtcut))
	private static void insereProduto(String nome, String descricao, PreparedStatement stm)
			throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		stm.execute();
		
		ResultSet rts =  stm.getGeneratedKeys();
		
		while(rts.next()) {

			Integer id = rts.getInt(1);
			
			System.out.println("O ID " + id + " foi criado nessa transação");
		}
	}
}
