package testes;

import java.util.HashMap;

import produto.CompraProduto;
import produto.Produto;

/**
 * Test do sistema com HashMap
 * 
 * 
 * @author Felipe Vieira
 * **/
public class TesteHashMap {

	public static void main(String[] args) {
		
		System.out.println("-TEST- (HASHMAP)");
		//Lista de produto (banco dados)
		HashMap<String, Produto> listaProduto = new HashMap<String, Produto>();
		listaProduto.put("F35",new Produto("F22","Macarrao",35.3f,new String[] {"TEST1","Test2"}));
		listaProduto.put("F40",new Produto("F40","Test",25.5f,new String[] {"TEST1","Test2"}));
		listaProduto.get("F40").setCategorias(new String[]{"Automovel","CARRO"});
		listaProduto.get("F40").removeCategoria(1);
		
		System.out.println("\n\n-PRINT- BANCO-DADOS");
		for (String chaves : listaProduto.keySet()) {

            //Capturamos o valor a partir da chave
            String nome = listaProduto.get(chaves).getNome();
            String categorias="";
            
            for(String i:listaProduto.get(chaves).getCategoriasToArray()) {
            	categorias+=i+",";
            }
            System.out.println(chaves + " = " + nome + "	:["+categorias+"]");
		}
		
		//Lista do usuário (compra)
		HashMap<String, CompraProduto> carrinho = new HashMap<String, CompraProduto>();
		carrinho.put("F23", new CompraProduto(listaProduto.get("F40"),5));

		
		System.out.println("\n\n-PRINT- COMPRAS");
		for (String chaves : carrinho.keySet()) {

            //Capturamos o valor a partir da chave
            String nome = carrinho.get(chaves).getProduto().getNome();
            float preco = carrinho.get(chaves).getPrecoTotal();
            String categorias="";
            
            for(String i:carrinho.get(chaves).getProduto().getCategoriasToArray()) {
            	categorias+=i+",";
            }
            System.out.println(chaves + " = " + nome + "	:" + preco+"	:["+categorias+"]");
		}
		
	}
		
}
