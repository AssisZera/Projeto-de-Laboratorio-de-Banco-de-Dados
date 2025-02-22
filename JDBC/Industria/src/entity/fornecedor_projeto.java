package entity;

public class fornecedor_projeto {

	private int codForProj;
	private int numFornecedor;
	private int numProjeto;
	private String nomeMaterial;
	private int qtdMaterial;
	
	public int getCodForProj() {
		return codForProj;
	}
	public void setCodForProj(int codForProj) {
		this.codForProj = codForProj;
	}
	public int getNumFornecedor() {
		return numFornecedor;
	}
	public void setNumFornecedor(int numFornecedor) {
		this.numFornecedor = numFornecedor;
	}
	public int getNumProjeto() {
		return numProjeto;
	}
	public void setNumProjeto(int numProjeto) {
		this.numProjeto = numProjeto;
	}
	public String getNomeMaterial() {
		return nomeMaterial;
	}
	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}
	public int getQtdMaterial() {
		return qtdMaterial;
	}
	public void setQtdMaterial(int qtdMaterial) {
		this.qtdMaterial = qtdMaterial;
	}
}
