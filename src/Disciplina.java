import java.util.ArrayList;
import java.util.List;

public class Disciplina {


	public String nome;
	public String codSemestre;
	public String quantidadeCredito;
	public String professor;
	

	public Disciplina(String nome, String codS, String qt, String professor){
		this.nome = nome;
		this.codSemestre = codS;
		this.quantidadeCredito = qt;
		this.professor = professor;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCodSemestre(String n) {
		this.codSemestre = n;
	}

	

	public String getNome() {
		return this.nome;
	}
	public String getCodSemestre(){
		return this.codSemestre;
	}



}
