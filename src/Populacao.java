import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Random;

public class Populacao {
	private ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	private ArrayList<Semestre> semestres = new ArrayList<Semestre>();
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	private int quantIndividuos = 1000;
	private double probMutation = 0.15;
	private double mutationRate = 0.03;
	private int numCruzamentosporGeracao = 10; 

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

		Collections.sort(individuos, comparaIndividuo);
				
		individuos.remove(0);

		int muta = rand.nextInt((100 - min) + 1) + min;
		if (muta <= probMutation*100)
			newInd = mutacao(newInd);
		

		newInd.calculaFitness();
		individuos.add(newInd);
		Collections.sort(individuos, comparaIndividuo);
		
		
	}
	

	public static Comparator<Individuo> comparaIndividuo = new Comparator<Individuo>() {

		@Override
		public int compare(Individuo in1, Individuo in2) {
			Integer fitness1 = in1.fitness;
			Integer fitness2 = in2.fitness;
			//descendente
			return fitness2.compareTo(fitness1);
		}


	};

	public Semestre getSemestre(String nome){
		for (Semestre s: semestres){
			if (s.nome.equals(nome))
				return s;
		}
		return null;
	}
	
	public Individuo mutacao(Individuo ind){
		Random rand = new Random();
		for (Fase f : ind.fases){
			ArrayList <String> horariosDisp = new ArrayList<String>(getSemestre(f.nome).horDisponiveis);
			long seed = System.nanoTime();
			Collections.shuffle(horariosDisp, new Random(seed));
			for (Map.Entry<String, Disciplina> entry : f.horarios.entrySet()){
				//System.out.println("horariosDisp"+ " "+f.nome+horariosDisp);
				int mutaGen = rand.nextInt((100 - 0) + 1) + 0;
				if (mutaGen <= mutationRate*100){
					String chaveCima = horariosDisp.get(0);
					String chaveBaixo = entry.getKey();
					if (chaveCima.equals(chaveBaixo)){
						chaveCima = horariosDisp.get(1);	
						if(f.horarios.containsKey(chaveCima)){
							Disciplina aux = f.horarios.get(chaveCima);
							f.horarios.remove(chaveCima);
							f.horarios.put(chaveCima, f.horarios.get(chaveBaixo));
							f.horarios.remove(chaveBaixo);
							f.horarios.put(chaveBaixo, aux);
							horariosDisp.remove(1);
						}else{
							Disciplina aux = f.horarios.get(chaveBaixo);
							f.horarios.remove(chaveBaixo);
							f.horarios.put(chaveCima, aux);
							horariosDisp.remove(1);
						}
					}else{
						if(f.horarios.containsKey(chaveCima)){
							Disciplina aux = f.horarios.get(chaveCima);
							f.horarios.remove(chaveCima);
							f.horarios.put(chaveCima, f.horarios.get(chaveBaixo));
							f.horarios.remove(chaveBaixo);
							f.horarios.put(chaveBaixo, aux);
							horariosDisp.remove(0);
						}else{
							Disciplina aux = f.horarios.get(chaveBaixo);
							f.horarios.remove(chaveBaixo);
							f.horarios.put(chaveCima, aux);
							horariosDisp.remove(0);
						}
						
					}
				}
				return ind;
			}
		}
		
		return ind;
	}

	
	
	public void imprimePopulacaoComFitness(){
		for (Individuo ind : individuos){
			ind.imprimeIndividuo();
			ind.imprimeFitness();
		}
	}
	
	public void imprimeMelhorIndividuo(){
		individuos.get(individuos.size()-1).imprimeIndividuo();
	}
	
	public void imprimeMelhorFitness(){
		individuos.get(individuos.size()-1).imprimeFitness();
	}
	
	public Individuo getMelhorIndividuo(){
		return individuos.get(individuos.size()-1);
	}


}
