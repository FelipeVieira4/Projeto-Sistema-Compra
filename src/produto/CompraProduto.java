package produto;

/**
 *  
 * Usado para instânciar um produtos na compra.
 * 
 * 
 * 
 * **/
public class CompraProduto{
	
	private int qtda=0;
	private float precoTotal=0.0f;
	private GarantiaExtendida garantia = null;
	private Produto produto;
	
	public CompraProduto(Produto pProduto,int pQtda) {
		this.produto=pProduto;
		
		this.setQtda(pQtda);
		this.setPrecoTotal();
	}
	public CompraProduto(Produto pProduto,int pQtda,GarantiaExtendida GarantiaEx) {
		this.produto=pProduto;
		
		this.setQtda(pQtda);
		this.setGarantia(GarantiaEx);
		this.setPrecoTotal();
	}
	
	public int getQtda() {
		return qtda;
	}

	public boolean setQtda(int pqtda) {
		if(pqtda>0){
	          this.qtda=pqtda;
	          return true;
	        }
	        return false;
	}
	
	public GarantiaExtendida getGarantia() {
		return garantia;
	}

	public void setGarantia(GarantiaExtendida pgarantia) {
		this.garantia = pgarantia;
	}
	
	public float getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal() {
		this.precoTotal = (this.produto.getPreco()*this.qtda);
		if(this.garantia!=null)this.precoTotal+=this.garantia.getPrecoGarantia();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto p) {
		this.produto = p;
	}
	
	
}
