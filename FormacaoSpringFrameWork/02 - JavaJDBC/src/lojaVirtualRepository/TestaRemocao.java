package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		Integer id = 2;
		
		ConnectionFactory connectionFacture = new ConnectionFactory();
		
		Connection con  = connectionFacture.recuperarConexao();
		
		try(PreparedStatement stm = con.prepareStatement("DELETE FROM PRODUTO WHERE ID < ? ")){
		
			stm.setInt(1, id);
			
			stm.execute();
			
			Integer linhasModificadas =  stm.getUpdateCount();
			
			System.out.println("Quantidade de linhas que foram modificadas " + linhasModificadas);
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("NÃO FOI POSSIVEL DELETAR O PRODUTO COM ID " + id);
		}
		con.close();
	}
}
