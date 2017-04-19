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
		List<Professor> professores = new ArrayList<Professor>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String linha;

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				professores.add(montaProfessor(linha));
			}

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				addSemestre(linha);
			}

			br.readLine();
			while((linha = br.readLine()) != null){
				//addDisciplina(linha);
			}
			
			
/*			Horario h = new Horario();
			Disciplina ds = new Disciplina("IA");
			h.setAula(8, ds);
			h.printHorarioss();
*/			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
	
	public static Professor montaProfessor(String linha){
		String nome = linha.substring(0, 9).replace(" ", "");
		List<String> horarios = new ArrayList<String>();
		
		for (int i = 12; i < linha.length(); i+=3) {
			horarios.add(linha.substring(i, i+2));
		}
		System.out.println(nome+": "+horarios);
		Professor p = new Professor(nome, horarios);
		return p;
	}
	
	private static void addSemestre(String linha){
		String nome = linha.substring(0, 6);
		List<String> horarios = new ArrayList<String>();
		
		for (int i = 10; i < linha.length(); i+=3) {
			horarios.add(linha.substring(i, i+2));
		}
		System.out.println(nome+": "+horarios);
	}
	
	
	private static void addDisciplina(String linha){
		System.out.println(linha);
	}

}
