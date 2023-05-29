package produto;

import java.util.ArrayList;

/**
*Usado para criar produtos no banco dados.
*
**/

public class Produto {
	
	private float preco=0.0f;
	private String codigo;
	private String nome;
	private String decricao;
	private String distribuidora;
	private String contatoDistribuidora;
	private String localProduzido;
		
	private ArrayList<String> categorias=new ArrayList<String>();
	
	/** Construtor simples**/
	public Produto(String pCodigo,String pName,float pPreco,String[] categorias) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);

		
		for(String i:categorias) {
			this.setCategorias(i);
		}
		
		this.setPreco(pPreco);
   		
	}
	
	/**Construtor completo**/
	public Produto(String pCodigo,String pName,float pPreco,String[] categorias,String pLocalProduzido,String pContatoDistribuidora,String pDecricao) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);
		this.setPreco(pPreco);
		this.setDecricao(decricao);
		
		for(String i:categorias) {
			this.setCategorias(i);
		}
		
		this.setDistribuidora(contatoDistribuidora);
		this.setLocalProduzido(localProduzido);
		
	}
	
	/**Retornar preço do produto**/
	public float getPreco() {
		return preco;
	}

	/**Setar o preco do produto**/
    public boolean setPreco(float pPreco){
    	if(pPreco>0){
				this.preco=pPreco;
				return true;    		
    	}
    	
    	return false;
      }
	
    /**Retornar nome do produto**/
	public String getNome() {
		return nome;
	}
	
	/**Setar o nome do produto**/
	public boolean setNome(String pnome) {
		if(!pnome.isBlank()) {
			this.nome = pnome;
			return true;
		}
		return false;
	}

	/**Retornar o codigo do produto**/
	public String getCodigo() {
		return this.codigo;
	}

	/**Setar o codigo de um produto tem regex digitos**/
	public boolean  setCodigo(String pcodigo) {
		if(!pcodigo.isBlank() && Validacao.IntTipo(pcodigo) && pcodigo.length()<=3){
			this.codigo = pcodigo;
			return true;
		}
		return false;
	}
	
	/**Retornar a Distribuidora do produto**/
	public String getDistribuidora() {
		return distribuidora;
	}

	/**Setar a Distribuidora do produto**/
	public boolean setDistribuidora(String pDistribuidora) {
		if(!pDistribuidora.isBlank()) {
			this.distribuidora = pDistribuidora;
			return true;
		}
		return false;
	}

	/**Retornar o lugar onde o produto foi produzido**/
	public String getLocalProduzido() {
		return localProduzido;
	}

	/**Setar o lugar onde o produto foi produzido**/
	public boolean setLocalProduzido(String pLocalProduzido) {
		if(!pLocalProduzido.isBlank()) {
			this.localProduzido = pLocalProduzido;
			return true;
		}
		return false;
	}

	
	/**Retornar o contato da Distribuidora do produto**/
	public String getContatoDistribuidora() {
		return contatoDistribuidora;
	}

	/**Setar o contato da Distribuidora do produto**/
	public boolean setContatoDistribuidora(String pContatoDistribuidora) {
		if(!pContatoDistribuidora.isBlank()) {
			this.contatoDistribuidora = pContatoDistribuidora;
			return true;
		}
		return false;
	}


	/**Retornar a Descricao do produto**/
	public String getDecricao() {
		return decricao;
	}

	/**Setar a Descricao do produto**/
	public boolean setDecricao(String pDecricao) {
		if(!pDecricao.isBlank()) {
			this.decricao = pDecricao;
			return true;
		}
		return false;
	}

	
	/**Retornar uma categoria especifica do produto**/
	public String getCategorias(int index) {
		return categorias.get(index);
	}
	
	/**Remover uma categoria especifica do produto**/
	public boolean removeCategoria(int index) {
		if(categorias.size() > index) {
			categorias.remove(index);
			return true;
		}
		return false;
	}
	
	/**Limpar todas as Categorias do produto**/
	public void clearCategoria() {
		this.categorias.clear();
	}
	
	/**Retornar uma ArrayList da Categorias ao produto**/
	public ArrayList<String> getCategoriasToArray() {
		return categorias;
	}

	/**Adicionar uma nova Categoria ao produto**/
	public void setCategorias(String pCategorias) {
		if(!pCategorias.isBlank()) {
			this.categorias.add(pCategorias);
		}
	}
	
	/**Adicionar uma ArrayList da Categorias ao produto**/
	public void setCategorias(String[] pCategorias) {
			
		for(String i : pCategorias) {
			this.categorias.add(i);
		}
	}	
}
