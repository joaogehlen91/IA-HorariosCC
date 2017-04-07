import java.util.ArrayList;


public class Horario {
	private ArrayList<Disciplina> aula = new ArrayList<Disciplina>();

	public Horario() {
		for(int i = 0; i < 30; i++)	
			this.aula.add(new Disciplina(null));
	}

	public Disciplina getAula(int posicao) {
		return aula.get(posicao);
	}

	public void setAula(int posicao, Disciplina aula) {
		this.aula.add(posicao, aula);
	}
	
	public void printHorarioss(){
		for (Disciplina i : this.aula) {
			System.out.println(i.getNome());
		}
	}
	
}
