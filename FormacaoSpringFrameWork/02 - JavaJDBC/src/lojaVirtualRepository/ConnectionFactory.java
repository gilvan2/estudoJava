package lojaVirtualRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.sql.PooledConnection;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {
	
	public DataSource dataSource;
	
	//No construtor do método, eu já uso o c3p0 para realizar um pool de conexões 
	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		//Abre até 15 conexões concorrentes no banco de dados 
		comboPooledDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooledDataSource;
		
	}
	
	public Connection recuperarConexao() throws SQLException {
	
		return  this.dataSource.getConnection();
	}
}
/*Designer patter Factory Methods -> Tem por objetivo centralizar/encapsular um código que vai criar um objeto*/