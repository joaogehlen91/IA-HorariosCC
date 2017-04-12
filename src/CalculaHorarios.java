import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;




public class CalculaHorarios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "arquivos/curso.dat";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String linha;

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				addProfessor(linha);
			}

			br.readLine();
			while((linha = br.readLine()).length() > 0){
				addSemestre(linha);
			}

			br.readLine();
			while((linha = br.readLine()) != null){
				addDisciplina(linha);
			}
			
			
/*			Horario h = new Horario();
			Disciplina ds = new Disciplina("IA");
			h.setAula(8, ds);
			h.printHorarioss();
*/			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
	
	private static void addProfessor(String linha){
		System.out.println(linha);
	}
	
	private static void addSemestre(String linha){
		System.out.println(linha);
	}
	
	private static void addDisciplina(String linha){
		System.out.println(linha);
	}

}
