package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaInsercao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Connection con = connectionFactory.recuperarConexao();
		
		try(PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('MOUSE','MOUSE SEM FION')", PreparedStatement.RETURN_GENERATED_KEYS)){
			stm.execute();
			
			ResultSet rts =  stm.getGeneratedKeys();
			
			while(rts.next()) {

				Integer id = rts.getInt(1);
				
				System.out.println("O ID " + id + " foi criado nessa transação");
			}			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL ISERIR O PRODUTO");
		}
		
		con.close();
	}
}
