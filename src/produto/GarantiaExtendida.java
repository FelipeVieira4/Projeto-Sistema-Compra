package produto;

public class GarantiaExtendida {
	private String tipoGarantia;
	private int tempodeGarantia;//(em Mês)
	private float precoGarantia;
	private String descricao;
	
	public GarantiaExtendida(String pTipoGarantia,int pTempo,float pPreco,String pDescricao) {
		this.tipoGarantia=pTipoGarantia;
		this.precoGarantia=pPreco;
		this.tempodeGarantia=pTempo;
		this.descricao=pDescricao;
	}

	public String getTipoGarantia() {
		return tipoGarantia;
	}

	public int getTempodeGarantia() {
		return tempodeGarantia;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getPrecoGarantia() {
		return precoGarantia;
	}
	
	
	
}
