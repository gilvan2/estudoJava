package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Simuila inserção com parametros e previne sql injection
public class TestaInsercaoComParametros {

	public static void main(String[] args) throws SQLException {
		
		String nome = "MOUSE'";
		String descricao = "MOUSE SEM FIO);DELET * FROM PRODUTO";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?)";
		
		//Agoera, ao inves de receber um statement, ele prepara um statement e deixa a responsabilidade da escrita do sql para o java
		PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		
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
