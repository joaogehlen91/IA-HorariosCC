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
				//addSemestre(linha);
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
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
		
	
	public static Professor montaProfessor(String linha){
		String nome = "";
		linha = linha.replace(" ", "");
		List<String> preferenciaHorarios = new ArrayList<String>();
		
		for (int i = 0; i < linha.length(); i++){
			char chr = linha.charAt(i);
			if (Character.isLetter(chr)){
				nome = nome + chr;
			}
			if (Character.isDigit(chr)){
				for (int j = i + 1; j < linha.length(); j+=2){
					char h1 = linha.charAt(j);
					char h2 = linha.charAt(j+1);
					String horario = h1+""+h2;
					preferenciaHorarios.add(horario);
				}
				break;
			}
		}
		
		Professor p = new Professor(nome, preferenciaHorarios);
		return p;
	}
	
	private static void addSemestre(String linha){
		System.out.println(linha);
		String nome = linha.substring(0, 6);
		List<String> horarios = new ArrayList<String>();
		
		for (int i = 7; i < linha.length(); i++){
			char chr = linha.charAt(i);
			if (Character.isDigit(chr)){
				for (int j = i + 1; j < linha.length(); j+=2){
					char h1 = linha.charAt(j);
					char h2 = linha.charAt(j+1);
					String horario = h1+""+h2;
					horarios.add(horario);
				}
			}
		}
	}
	
	private static void addDisciplina(String linha){
		System.out.println(linha);
	}

}
