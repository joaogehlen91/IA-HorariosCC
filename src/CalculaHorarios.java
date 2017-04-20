import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculaHorarios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "arquivos/curso.dat";
		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Semestre> semestres = new ArrayList<Semestre>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String linha;

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				professores.add(montaProfessor(linha));
			}

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				semestres.add(montaSemestre(linha));
			}

			br.readLine();
			while((linha = br.readLine()) != null){
				Disciplina d = montaDisciplina(linha);
				disciplinas.add(d);
				if(d.quantidadeCredito.equals("2")){
					Disciplina d1 = new Disciplina(d.nome, d.codSemestre, d.quantidadeCredito, d.professor);
					disciplinas.add(d1);					
				}
			}

			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		Populacao populacao = new Populacao(professores, semestres, disciplinas);
		populacao.gera();
			
		
	}

	public static Professor montaProfessor(String linha){
		String nome = linha.substring(0, 9).replace(" ", "");
		List<String> horarios = new ArrayList<String>();
		
		for (int i = 12; i < linha.length(); i+=3) {
			horarios.add(linha.substring(i, i+2));
		}
		//System.out.println(nome+": "+horarios);
		Professor p = new Professor(nome, horarios);
		return p;
	}
	
	private static Semestre montaSemestre(String linha){
		String nome = linha.substring(0, 3).replace(" ","");
		ArrayList<String> horarios = new ArrayList<String>();
		
		for (int i = 10; i < linha.length(); i+=3) {
			horarios.add(linha.substring(i, i+2));
		}
		//System.out.println(nome+": "+horarios);
		Semestre s = new Semestre(nome, horarios);
		return s;
	}
	
	private static Disciplina montaDisciplina(String linha){
		String nome = linha.substring(0, 6).replace(" ","");
		String qt = linha.substring(6,7);
		String codS = linha.substring(8,11).replace(" ","");
		String professor = linha.substring(11);

		Disciplina d = new Disciplina(nome, codS, qt, professor);
		return d;
	}

}
