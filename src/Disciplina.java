public class Disciplina {

	public String nome;
	public String codSemestre;
	public String quantidadeCredito;
	public Professor professor;
	
	public Disciplina(String nome, String codS, String qt, Professor professor){
		this.nome = nome;
		this.codSemestre = codS;
		this.quantidadeCredito = qt;
		this.professor = professor;
	}
}