import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Individuo {
	public ArrayList<Curso> semestre = new ArrayList<Curso>();
	
	
	public Individuo(){
		
		//for i in horDisponiveis:

	}
	
	public void imprimeIndividuo(){
		for (Curso c : semestre){
			System.out.println(c.semestre);
		}
	
	}
	
}
