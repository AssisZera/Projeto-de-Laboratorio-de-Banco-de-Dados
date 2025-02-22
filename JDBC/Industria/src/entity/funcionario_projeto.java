package entity;

public class funcionario_projeto {

	private int codFunc;
	private int numFunc;
	private int numProjeto;
	private String dataInicioProjeto;
	private double horasTrabalhadas;
	
	public int getCodFunc() {
		return codFunc;
	}
	public void setCodFunc(int codFunc) {
		this.codFunc = codFunc;
	}
	public int getNumFunc() {
		return numFunc;
	}
	public void setNumFunc(int numFunc) {
		this.numFunc = numFunc;
	}
	public int getNumProjeto() {
		return numProjeto;
	}
	public void setNumProjeto(int numProjeto) {
		this.numProjeto = numProjeto;
	}
	public String getDataInicioProjeto() {
		return dataInicioProjeto;
	}
	public void setDataInicioProjeto(String dataInicioProjeto) {
		this.dataInicioProjeto = dataInicioProjeto;
	}
	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
}
