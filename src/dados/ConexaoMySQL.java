package dados;

import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.jdbc.Connection; se necessário, alterar:
import java.sql.Connection;

public class ConexaoMySQL {
	//1º passo: definir os atributos de acesso ao MySQL
	private String database = "test"; // use vendas;
	private String usuario = "root"; // usuário de acesso
	private String senha = "root";
	//url=endereço do servidor MySQL
	private String url = "jdbc:mysql://localhost:3306/"+database;
	
								
	public Connection conectar() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection(url,usuario,senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(conexao != null) {
			System.out.println("Conectado com sucesso!!");
			return conexao;
		}
		
		return null;
	}
	
	public boolean close() {
		return true;
	}
	
}