/*
 * Nomes: Elias Fank, João Gehlen, Ricardo Zanuzzo
 * Disciplina: Inteligencia Artificial
 * 
 * 2017/1
 * 
 * Esta classe a classe principal do algoritmo GA.
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculaHorarios {

	public static void main(String[] args) {
		String fileName = "arquivos/curso.dat";
		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Semestre> semestres = new ArrayList<Semestre>();
		int numCruzamentos = 150;
		int maxGenerations = 100;
		int condParada = 10;

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String linha;

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				professores.add(montaProfessor(linha));
			}

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				semestres.add(montaSemestre(linha));
			}

			br.readLine();
			while((linha = br.readLine()) != null){
				Disciplina d = montaDisciplina(linha, professores);
				disciplinas.add(d);
				if(d.quantidadeCredito.equals("2")){
					Disciplina d1 = new Disciplina(d.nome, d.codSemestre, d.quantidadeCredito, d.professor);
					disciplinas.add(d1);					
				}
			}
			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Populacao populacao = new Populacao(professores, semestres, disciplinas);
		populacao.geraPopulacao();
			
		Integer melhorfitness = 10000;
		Integer melhorfitnessAnt = 0;
		Integer countFitnes = 0;
		Individuo melhorIndividuo = new Individuo();
		
		System.out.println();
		for (int i = 1; i < maxGenerations; i++) {
			maxGenerations--;
			for (int j = 0; j < numCruzamentos ; j++)
				populacao.cruzamento();
			
			melhorIndividuo = populacao.getMelhorIndividuo();
			System.out.println("Geração: "+ i + " Fitness: "+ melhorIndividuo.fitness);
			
			if(melhorfitness == melhorfitnessAnt)
				countFitnes++;
			else
				countFitnes = 0;
			
			if(countFitnes > condParada) break;			
			
			
			melhorfitnessAnt = melhorfitness;
			melhorfitness = melhorIndividuo.fitness;
		}
			
		System.out.println("\n"+"#RESULTADO#############################");
		melhorIndividuo.imprimeIndividuo();
		System.out.println("#######################################");
		System.out.println();
	}
	
	
	public static Professor getProfessorPorNome(String nome, ArrayList<Professor> professores){
		for (Professor p : professores){
			if (p.nome.equals(nome))
				return p;
		}
		return null;
	}

	public static Professor montaProfessor(String linha){
		String[] parts = linha.split(" +");
		String nome = parts[0];
		List<String> horarios = new ArrayList<String>();
		for (int i = 2; i < parts.length; i+=1) {
			if (parts[i].length() > 0) horarios.add(parts[i]);
		}
		//System.out.println(nome+": "+horarios);
		Professor p = new Professor(nome, horarios);
		return p;
	}
	
	private static Semestre montaSemestre(String linha){
		String[] parts = linha.split(" +");
		String nome = parts[0];
		ArrayList<String> horarios = new ArrayList<String>();
		for (int i = 3; i < parts.length; i+=1) {
			horarios.add(parts[i]);
		}
		//System.out.println(nome+": "+horarios);
		Semestre s = new Semestre(nome, horarios);
		return s;
	}
	
	private static Disciplina montaDisciplina(String linha, ArrayList<Professor> professores){
		String[] parts = linha.split(" +");
		String nome = parts[0];
		String qt = parts[1];
		String codS = parts[2];
		Professor professor;
		professor = getProfessorPorNome(parts[3], professores);
		//System.out.println(nome+": "+professor);
		Disciplina d = new Disciplina(nome, codS, qt, professor);
		return d;
	}
}
