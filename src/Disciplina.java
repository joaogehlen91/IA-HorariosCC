/*
 * Nomes: Elias Fank, João Gehlen, Ricardo Zanuzzo
 * Disciplina: Inteligencia Artificial
 * 
 * 2017/1
 * 
 * Esta classe eh usada para armazenar os dados das disciplinas na leitura do arquivo de entrada.
 * 
 */


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