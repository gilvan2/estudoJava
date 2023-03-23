package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		
		Statement stm = con.createStatement();
		
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('MOUSE','MOUSE SEM FION')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rts =  stm.getGeneratedKeys();
		
		while(rts.next()) {

			Integer id = rts.getInt(1);
			
			System.out.println("O ID " + id + " foi criado nessa transação");
		}
	}
}
