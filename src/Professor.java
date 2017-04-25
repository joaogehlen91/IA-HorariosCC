/*
 * Nomes: Elias Fank, João Gehlen, Ricardo Zanuzzo
 * Disciplina: Inteligencia Artificial
 * 
 * 2017/1
 * 
 * Esta classe eh usada para armazenar os dados dos professores na leitura do arquivo de entrada.
 * 
 */

import java.util.List;

public class Professor {
	public String nome;
	public List<String> preferenciaHorarios;
	
	public Professor(String nome, List<String> preferenciaHorarios) {
		this.nome = nome;
		this.preferenciaHorarios = preferenciaHorarios;
	}
	
}