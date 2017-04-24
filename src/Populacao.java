import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Populacao {
	private ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Semestre> semestres = new ArrayList<Semestre>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private int quantIndividuos = 1;

	public Populacao(ArrayList<Professor> professores, ArrayList<Semestre> semestres, ArrayList<Disciplina> disciplinas){
		this.professores = professores;
		this.semestres = semestres;
		this.disciplinas = disciplinas;
	}

	
	private Individuo geraIndividuo(){
		System.out.println("Individuo ------------");
		Individuo ind = new Individuo();
		for (Semestre sem : semestres){
			//System.out.print(sem.nome+": ");
			
			Fase curso = new Fase();
			ArrayList<Disciplina> discDisp = new ArrayList<Disciplina>();
			discDisp = pegaDisciplinas(sem.nome);  
			long seed = System.nanoTime();
			Collections.shuffle(discDisp, new Random(seed));
			for (String hd : sem.horDisponiveis) {
				
				//System.out.print(" "+hd+" ");
				
				//System.out.print(discDisp.get(0).nome);
				curso.semestre.put(hd, discDisp.get(0));
				
				discDisp.remove(0);
			}
			
			ind.curso.add(curso);
			
		}
		
		ind.imprimeIndividuo();
		
		ind.fitness();
		return ind;
		
		
	}
	
	
	public ArrayList<Disciplina> pegaDisciplinas(String nomeSemestre) {
		ArrayList<Disciplina> disciplinasDisp = new ArrayList<Disciplina>();
		for (Disciplina disciplina : disciplinas) {
			//System.out.println(nomeSemestre +"   " +disciplina.codSemestre);
			if(disciplina.codSemestre.equals(nomeSemestre)){
				
				disciplinasDisp.add(disciplina);
			}
		}
		
		return disciplinasDisp;
		
	}


	public void gera(){
		for(int i=0; i<quantIndividuos; i++){
			individuos.add(geraIndividuo());
		}
		
		
	}

}
