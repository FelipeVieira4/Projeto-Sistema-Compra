package produto;

/**
 * 
 * Fornece uma Garantia Extendida para produto(s).
 * 
 * @author Felipe V.
 * **/

public class GarantiaExtendida {
	
	private String tipoGarantia;
	private int tempodeGarantia;//(em Mês)
	private float precoGarantia;
	private String descricao;
	
	/**Retornar o metodo construtor**/
	public GarantiaExtendida(String pTipoGarantia,int pTempo,float pPreco,String pDescricao) {
		this.tipoGarantia=pTipoGarantia;
		this.precoGarantia=pPreco;
		this.tempodeGarantia=pTempo;
		this.descricao=pDescricao;
	}

	/**Retornar o tipo GarantiaExtendida**/
	public String getTipoGarantia() {
		return tipoGarantia;
	}

	/**Tempo da Garantia(Meses)**/
	public int getTempodeGarantia() {
		return tempodeGarantia;
	}

	/**Descricao da GarantiaExtendida**/
	public String getDescricao() {
		return descricao;
	}

	/**Preco da GarantiaExtendida**/
	public float getPrecoGarantia() {
		return precoGarantia;
	}
	
	
	
}
