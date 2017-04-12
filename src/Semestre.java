import java.util.ArrayList;


public class Semestre {
	//private ArrayList<Semana> aula = new ArrayList<Semana>();
	private ArrayList<Disciplina> horarios = new ArrayList<Disciplina>();
	private String nome = new String();
	private String horario = new String();
	
	public Semestre() {
		for(int i = 0; i < 30; i++)	
			this.horarios.add(new Disciplina(null));
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	
	
	
	
	

}
