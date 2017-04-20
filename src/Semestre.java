import java.util.ArrayList;


public class Semestre {
	public ArrayList<String> horDisponiveis = new ArrayList<String>();
	public String nome = new String();
	public String quantidade;
	public String professor;
	
	public Semestre(String nome, ArrayList<String> horDisponiveis) {
		this.horDisponiveis = horDisponiveis;
		this.nome = nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
