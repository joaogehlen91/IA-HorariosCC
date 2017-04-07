import java.util.ArrayList;
import java.util.List;


public class Disciplina {

	private String nome;
	
	ArrayList<Professor> prof = new ArrayList<Professor>();
	
	
	public Disciplina(String nome){
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Professor> getProf() {
		return prof;
	}


	public void setProf(Professor prof) {
		this.prof.add(prof);
	}
	
	
	
}
