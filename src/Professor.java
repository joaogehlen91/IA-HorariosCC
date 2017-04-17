import java.util.List;


public class Professor {
	private String nome;
	private List<String> preferenciaHorarios;
	
		
	public Professor(String nome, List<String> preferenciaHorarios) {
		this.nome = nome;
		this.preferenciaHorarios = preferenciaHorarios;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<String> getPreferenciaHorarios() {
		return preferenciaHorarios;
	}
	
	public void setPreferenciaHorarios(List<String> preferenciaHorarios) {
		this.preferenciaHorarios = preferenciaHorarios;
	}
	
	
}
