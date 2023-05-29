package produto;

/**
 *  
 * Usado para instanciar um produto,compra,quantidades do produto e a Garantia do produto(s) comprado.
 * 
 * 
 * @author Felipe V.
 * **/
public class CompraProduto{
	
	private int qtda=0;
	private float precoTotal=0.0f;
	private GarantiaExtendida garantia = null;
	private Produto produto;
	private String codigo;
	
	
	/**Retorna codigo da compra**/
	public String getCodigo() {
		return codigo;
	}

	/**Seta codigo da compra**/
	public boolean setCodigo(String pCodigo) {
		if(Validacao.Codigo(pCodigo)) {
			this.codigo = pCodigo;
			return true;
		}
		return false;
	}

	/**Metodo construtor sem Garantia**/
	public CompraProduto(Produto pProduto,int pQtda) {
		this.produto=pProduto;
		
		this.setQtda(pQtda);
		this.setPrecoTotal();
	}
	
	/**Metodo construtor com Garantia**/
	public CompraProduto(Produto pProduto,int pQtda,GarantiaExtendida GarantiaEx) {
		this.produto=pProduto;
		
		this.setQtda(pQtda);
		this.setGarantia(GarantiaEx);
		this.setPrecoTotal();
	}
	
	/**Retorna a valor de quantidades**/
	public int getQtda() {
		return qtda;
	}

	/**Setar a quantidades**/
	public boolean setQtda(int pqtda) {
		if(pqtda>0){
	          this.qtda=pqtda;
	          return true;
	        }
	        return false;
	}
	
	/**Retornar a Garantia Extendida**/
	public GarantiaExtendida getGarantia() {
		return garantia;
	}

	/**Setar a Garantia Extendida**/
	public boolean setGarantia(GarantiaExtendida pgarantia) {
		if(pgarantia!=null) {
			this.garantia = pgarantia;
			return true;
		}
		return false;
	}
	
	/**Setar o preco da comprar**/
	public float getPrecoTotal() {
		return precoTotal;
	}

	/**Calcular o preco da comprar**/
	public void setPrecoTotal() {
		this.precoTotal = (this.produto.getPreco()*this.qtda);
		if(this.garantia!=null)this.precoTotal+=this.garantia.getPrecoGarantia();
	}

	/**Retornar o produto da compra**/
	public Produto getProduto() {
		return produto;
	}

	/**Setar o produto da compra**/
	public boolean setProduto(Produto p) {
		if(p!=null) {
			this.produto = p;
			return true;
		}
		return false;
	}
	
	
}
