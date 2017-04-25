/*
 * Nomes: Elias Fank, João Gehlen, Ricardo Zanuzzo
 * Disciplina: Inteligencia Artificial
 * 
 * 2017/1
 * 
 * Esta classe eh usada para controlar cada fase do curso que representa um semestre do curso
 * 
 */


import java.util.HashMap;
import java.util.Map;

public class Fase {
	public String nome;
	public Map<String, Disciplina> horarios = new HashMap<String, Disciplina>();
	
}