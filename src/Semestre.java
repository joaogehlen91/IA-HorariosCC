/*
 * Nomes: Elias Fank, João Gehlen, Ricardo Zanuzzo
 * Disciplina: Inteligencia Artificial
 * 
 * 2017/1
 * 
 * Esta classe eh usada para armazenar os semestres do arquivo de dados
 * 
 */

import java.util.ArrayList;

public class Semestre {
	public ArrayList<String> horDisponiveis = new ArrayList<String>();
	public String nome = new String();
	public String quantidade;
	public String professor;
	
	public Semestre(String nome, ArrayList<String> horDisponiveis) {
		this.horDisponiveis = horDisponiveis;
		this.nome = nome;
	}
}