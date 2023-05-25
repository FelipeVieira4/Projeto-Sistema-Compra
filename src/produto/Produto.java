package produto;

import java.util.ArrayList;

/**
*Classe usada para criar produto.
* 
*ultima Atualizacao:22/05/2023
*
*methodos integração em interfaces
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
	
	/** Construtor da classe produto **/
	public Produto(String pCodigo,String pName,String pPreco,String[] categorias) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);
		
		
		for(String i:categorias) {
			this.setCategorias(i);
		}
		
		this.setPreco(pPreco);
   
		
	}
	
	/** Construtor da classe produto **/
	public Produto(String pCodigo,String pName,String pPreco) {
		
		this.setCodigo(pCodigo);
		this.setNome(pName);
		this.setPreco(pPreco);
   
		
	}
	
	public Produto(String pCodigo,String pName,float pPreco,String descricao) {
		this.codigo=pCodigo;
		this.nome=pName;
		
    	this.preco=pPreco;
    	this.decricao=descricao;
		
	}
	
	/** Retornar o preco do produto**/
	public float getPreco() {
		return preco;
	}

	/** Setar o preco do produto**/
    public boolean setPreco(String pPreco){
    	if(pPreco.matches("[0-9.]*")){
    		if(Float.parseFloat(pPreco)>0) {
				this.preco=Float.parseFloat(pPreco);
				return true;
    		}
    		
    	}
    	
    	return false;
      }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String pnome) {
		if(!pnome.isBlank()) {
			this.nome = pnome;
		}
	}

	public void setCodigo(String pcodigo) {
		if(!pcodigo.isBlank() && pcodigo.matches("^[A-Z][0-9]*") && pcodigo.length()<=3){
			this.codigo = pcodigo;
		}
	}
	public String getCodigo() {
		return this.codigo;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public boolean setDistribuidora(String pDistribuidora) {
		if(!pDistribuidora.isBlank()) {
			this.distribuidora = pDistribuidora;
			return true;
		}
		return false;
	}

	public String getLocalProduzido() {
		return localProduzido;
	}

	public boolean setLocalProduzido(String pLocalProduzido) {
		if(!pLocalProduzido.isBlank()) {
			this.localProduzido = pLocalProduzido;
			return true;
		}
		return false;
	}

	
	
	public String getContatoDistribuidora() {
		return contatoDistribuidora;
	}

	public boolean setContatoDistribuidora(String pContatoDistribuidora) {
		if(!pContatoDistribuidora.isBlank()) {
			this.contatoDistribuidora = pContatoDistribuidora;
			return true;
		}
		return false;
	}


	
	public String getDecricao() {
		return decricao;
	}

	public boolean setDecricao(String pDecricao) {
		if(!pDecricao.isBlank()) {
			this.decricao = pDecricao;
			return true;
		}
		return false;
	}

	
	
	public String getCategorias(int index) {
		return categorias.get(index);
	}
	
	public boolean removeCategoria(int index) {
		System.out.println(categorias.size());
		if(categorias.size() > index) {
			categorias.remove(index);
			return true;
		}
		return false;
	}
	
	public ArrayList<String> getCategoriasToArray() {
		return categorias;
	}

	public void setCategorias(String pCategorias) {
		if(!pCategorias.isBlank()) {
			this.categorias.add(pCategorias);
		}
	}
	public void setCategorias(String[] pCategorias) {
		for(String i : pCategorias) {
			this.categorias.add(i);
		}
	}	
}
