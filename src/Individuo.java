import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Individuo {
	public ArrayList<Fase> fases = new ArrayList<Fase>();
	public int fitness;
	
	public void imprimeIndividuo(){
		for (Fase f : fases){
			//System.out.println(c.semestre);
			System.out.println("semestre: "+f.nome);
			for (Map.Entry<String, Disciplina> entry : f.horarios.entrySet()){
			    System.out.println(entry.getKey() + "/" + entry.getValue().nome);
			}
		}
	}
	
	public void imprimeFitness(){
		System.out.println("Fitness: "+this.fitness);
	}
	
	public int verificaPrefUm(Fase f, String chave1, String chave2){
		if(f.horarios.containsKey(chave1) && f.horarios.containsKey(chave2)){
			return 10;
		}
		return 0;
	}
	
	public int verificaPrefDois(Fase f1, Fase f2, String mat1, String mat2, String not1, String not2){
		if((f1.horarios.containsKey(mat1) || f1.horarios.containsKey(mat2))
			&& (f2.horarios.containsKey(not1) || f2.horarios.containsKey(not2))	){
			return 5;
		}
		return 0;
	}
	
	public int verificaPrefTres(String horario, List<String> preferencias){
		if(preferencias.contains(horario)){
			return 1;
		}
		return 0;
	}
	
	public void calculaFitness(){
		
		///////////////////RESTRICOES////////////////////////////////////////////////////////////////
		for (Fase c : fases) {
			if(c.horarios.containsKey("21") && c.horarios.containsKey("02")){
				this.fitness += 1000;
			}
			if(c.horarios.containsKey("23") && c.horarios.containsKey("04")){
				this.fitness += 1000;
			}
			if(c.horarios.containsKey("25") && c.horarios.containsKey("06")){
				this.fitness += 1000;
			}
			if(c.horarios.containsKey("27") && c.horarios.containsKey("08")){
				this.fitness += 1000;
			}
		}
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/////////////////PREFERENCIAS//////////////////////////////////////////////////////////////////
		// De preferência os professores não devem ministrar 4 perı́odos con-
		//secutivos no mesmo turno
		for (Fase f : fases){
			this.fitness += verificaPrefUm(f, "00", "01");
			this.fitness += verificaPrefUm(f, "02", "03");
			this.fitness += verificaPrefUm(f, "04", "05");
			this.fitness += verificaPrefUm(f, "06", "07");
			this.fitness += verificaPrefUm(f, "08", "09");
			this.fitness += verificaPrefUm(f, "10", "11");
			this.fitness += verificaPrefUm(f, "12", "13");
			this.fitness += verificaPrefUm(f, "14", "15");
			this.fitness += verificaPrefUm(f, "16", "17");
			this.fitness += verificaPrefUm(f, "18", "19");
			this.fitness += verificaPrefUm(f, "20", "21");
			this.fitness += verificaPrefUm(f, "22", "23");
			this.fitness += verificaPrefUm(f, "24", "25");
			this.fitness += verificaPrefUm(f, "26", "27");
			this.fitness += verificaPrefUm(f, "28", "29");
			
		}
	
		// De preferência os professores não devem ministras aulas no perı́odo
		//matinal e noturno no mesmo dia
		for (int i=0; i < fases.size(); i++){
			for (int j=i+1; j < fases.size(); j++){
				this.fitness += verificaPrefDois(fases.get(i), fases.get(j), "00", "01", "20", "21");
				this.fitness += verificaPrefDois(fases.get(i), fases.get(j), "02", "03", "22", "23");
				this.fitness += verificaPrefDois(fases.get(i), fases.get(j), "04", "05", "24", "25");
				this.fitness += verificaPrefDois(fases.get(i), fases.get(j), "06", "07", "26", "27");
				this.fitness += verificaPrefDois(fases.get(i), fases.get(j), "08", "09", "28", "29");
				//System.out.println(i+"--"+j+"--"+fases.get(i).nome+"--"+fases.get(j).nome);
			}
		}
		
		//De preferência os professores não devem ministrar aulas nos perı́odos
		//que eles solicitaram não ministrar aulas.
		for (Fase f : fases){
			for (Map.Entry<String, Disciplina> entry : f.horarios.entrySet()){
				this.fitness += verificaPrefTres(entry.getKey(), entry.getValue().professor.preferenciaHorarios);
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
	}
}