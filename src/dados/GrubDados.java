package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import produto.Produto;

public class GrubDados {

	public static void salvarProduto(Produto p) {
		String sql = "insert into produto(nome,preco) values(?,?)";
	
		ConexaoMySQL conexao = new ConexaoMySQL();
		Connection id = conexao.conectar();
	
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1,p.getNome());
			command.setFloat(2, p.getPreco());
			command.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			id.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}