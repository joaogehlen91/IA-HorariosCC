import java.util.ArrayList;
import java.util.Map;

public class Individuo {
	public ArrayList<Fase> curso = new ArrayList<Fase>();
	
	
	public Individuo(){
		
		//for i in horDisponiveis:

	}
	
	public void imprimeIndividuo(){
		for (Fase c : curso){
			//System.out.println(c.semestre);
			System.out.println("semestre ---------");
			for (Map.Entry<String, Disciplina> entry : c.semestre.entrySet()){
				System.out.println(entry.getValue().codSemestre );
			    System.out.println(entry.getKey() + "/" + entry.getValue().nome);
			}
		}
	
	}
	
	
	public Double fitness(){
		Double fitness = 0.0;
		
		
		//RESTRICAO MAXIMA
		for (Fase c : curso) {
			if(c.semestre.containsKey("21") && c.semestre.containsKey("02")){
				System.out.println(c.semestre.get("21").professor);
				System.out.println(c.semestre.get("02").professor);
				fitness += 100;
			}
			
			if(c.semestre.containsKey("23") && c.semestre.containsKey("04")){
				System.out.println(c.semestre.get("23").professor);
				System.out.println(c.semestre.get("04").professor);
				fitness += 100;
			}
			
			if(c.semestre.containsKey("25") && c.semestre.containsKey("06")){
				System.out.println(c.semestre.get("25").professor);
				System.out.println(c.semestre.get("06").professor);
				fitness += 100;
			}
			
			if(c.semestre.containsKey("27") && c.semestre.containsKey("08")){
				System.out.println(c.semestre.get("27").professor);
				System.out.println(c.semestre.get("08").professor);
				fitness += 100;
			}
		}
		//####################
		
		
		
		//PREFERENCIAS

		
		
		
		
		for (Fase c : curso) {
			
			// pesquisar em todos os cursos
			/*for (Map.Entry<String, Disciplina> entry : c.semestre.entrySet()){
				System.out.println(entry.getValue().codSemestre );
			    System.out.println(entry.getKey() + "/" + entry.getValue().nome);
			}*/
			
			
			//criar funcao para verificar choque de horarios proximos
			
			//criar funcao para verificar aula manha e noite no mesmo dia
			
			//criar funcao para vericicar preferecias dos professores
			
			if(c.semestre.containsKey("00") && c.semestre.containsKey("01")){
				if(c.semestre.get("00").professor.equals(c.semestre.get("01").professor))
					fitness += 1;
					
			}
			if(c.semestre.containsKey("02") && c.semestre.containsKey("03")){
				if(c.semestre.get("02").professor.equals(c.semestre.get("03").professor))
					fitness += 1;
				
			}
			if(c.semestre.containsKey("04") && c.semestre.containsKey("05")){
				
			}
			if(c.semestre.containsKey("06") && c.semestre.containsKey("07")){
				
			}
			if(c.semestre.containsKey("08") && c.semestre.containsKey("09")){
				
			}
			
			if(c.semestre.containsKey("10") && c.semestre.containsKey("11")){
				
			}
			if(c.semestre.containsKey("12") && c.semestre.containsKey("13")){
				
			}
			if(c.semestre.containsKey("14") && c.semestre.containsKey("15")){
				
			}
			if(c.semestre.containsKey("16") && c.semestre.containsKey("17")){
				
			}
			if(c.semestre.containsKey("18") && c.semestre.containsKey("19")){
				
			}
			
			if(c.semestre.containsKey("20") && c.semestre.containsKey("21")){
				
			}
			if(c.semestre.containsKey("22") && c.semestre.containsKey("23")){
				if(c.semestre.get("22").professor.equals(c.semestre.get("23").professor))
					System.out.println("Sim");
				else
					System.out.println("Não");
				
			}
			if(c.semestre.containsKey("24") && c.semestre.containsKey("25")){
				
			}
			if(c.semestre.containsKey("26") && c.semestre.containsKey("27")){
				
			}
			if(c.semestre.containsKey("28") && c.semestre.containsKey("29")){
				
			}
			

			
		}
		

		
		
		
		//###################
		
		
		
		
		return fitness;
		
	}
	
	
}

/*De preferˆencia os professores n˜ao devem ministrar 4 per´ıodos consecutivos
no mesmo turno
– De preferˆencia os professores n˜ao devem ministras aulas no per´ıodo
matinal e noturno no mesmo dia
– de preferˆencia os professores n˜ao devem ministrar aulas nos per´ıodos
que eles solicitaram n˜ao ministrar aulas.
*/