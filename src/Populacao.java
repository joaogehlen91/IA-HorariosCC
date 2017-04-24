import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Populacao {
	private ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Semestre> semestres = new ArrayList<Semestre>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private int quantIndividuos = 20;

	public Populacao(ArrayList<Professor> professores, ArrayList<Semestre> semestres, ArrayList<Disciplina> disciplinas){
		this.professores = professores;
		this.semestres = semestres;
		this.disciplinas = disciplinas;
	}

	private Individuo geraIndividuo(){
		//System.out.println("Individuo ------------");
		Individuo ind = new Individuo();
		for (Semestre sem : semestres){
			//System.out.print(sem.nome+": ");
			Fase fase = new Fase();
			fase.nome = sem.nome;
			ArrayList<Disciplina> discDisp = new ArrayList<Disciplina>();
			discDisp = pegaDisciplinas(sem.nome); 
			//System.out.println(sem.nome);
			ArrayList<String> horariosSem = new ArrayList<String>(sem.horDisponiveis);
			long seed = System.nanoTime();
			Collections.shuffle(horariosSem, new Random(seed));
			//System.out.println(discDisp.size()+"--"+sem.horDisponiveis.size());
			for (Disciplina disciplina : discDisp) {
				//if (horariosSem.size() < 1) break;
				//System.out.print(horariosSem.get(0)+"--"+disciplina.nome+"--"+disciplina.professor.getNome()+"\n");
				fase.horarios.put(horariosSem.get(0), disciplina);
				
				horariosSem.remove(0);
			}
			
			ind.fases.add(fase);
			
		}
		
		//ind.imprimeIndividuo();
		
		ind.calculaFitness();
		//ind.imprimeFitness();
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


	public void geraPopulacao(){
		for(int i=0; i<quantIndividuos; i++){
			individuos.add(geraIndividuo());
		}
	}
	
	
	public void cruzamento(){
		Individuo ind1 = new Individuo();
		Individuo ind2 = new Individuo();
		Individuo newInd = new Individuo();
		Random rand = new Random();
		Integer min = 0;
		int index1 = rand.nextInt(((quantIndividuos - 1) - min) + 1) + min;
		int index2 = rand.nextInt(((quantIndividuos - 1) - min) + 1) + min;
		
		ind1 = individuos.get(index1);
		ind2 = individuos.get(index2);
		
		for (int i = 0; i < 8; i++) {
			newInd.fases.add(ind1.fases.get(i));
			i++;
			newInd.fases.add(ind2.fases.get(i));
		}
		newInd.fases.add(ind1.fases.get(8));
		
//		newInd.imprimeIndividuo();
//		newInd.calculaFitness();
//		newInd.imprimeFitness();
		
		if(ind1.fitness < ind2.fitness)
			individuos.remove(index2);
		else
			individuos.remove(index1);
		
		newInd.calculaFitness();
		individuos.add(newInd);
		
		
	}
	
	
	public void imprimePopulacaoComFitness(){
		for (Individuo ind : individuos){
			ind.imprimeIndividuo();
			ind.imprimeFitness();
		}
	}
	

}
