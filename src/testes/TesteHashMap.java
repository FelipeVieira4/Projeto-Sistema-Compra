package testes;

import java.util.HashMap;

import produto.CompraProduto;
import produto.GarantiaExtendida;
import produto.Produto;

/**
 * Test do sistema com HashMap
 * 
 * 
 * @author Felipe Vieira
 * **/
public class TesteHashMap {

	public static void main(String[] args) {
		HashMap<String, Produto> listaProduto = new HashMap<String, Produto>();
		listaProduto.put("F35",new Produto("F22","Macarrao","35.3",new String[] {"TEST1","Test2"}));
		listaProduto.put("F40",new Produto("F40","Test","25.0",new String[] {"TEST1","Test2"}));
		
		listaProduto.get("F40").setCategorias(new String[]{"Automovel","CARRO"});
		listaProduto.get("F40").removeCategoria(1);
		
		System.out.println(listaProduto.get("F35").getLocalProduzido());
		
		HashMap<String, CompraProduto> carrinho = new HashMap<String, CompraProduto>();
		carrinho.put("F23", new CompraProduto(listaProduto.get("F40"),"8"));
		
		//carrinho.get("F23").setGarantia(new GarantiaExtendida("básica", 6, 750.0f, "Nenhuma"));
		//carrinho.get("F23").setPrecoTotal();
		
		System.out.println("-TEST- 3");
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
