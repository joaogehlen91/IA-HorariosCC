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
		String fileName = "/home/joao/Trabalho1/curso.dat";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
			}
			
			
			Horario h = new Horario();
			
			Disciplina ds = new Disciplina("IA");
			
			h.setAula(8, ds);
			
			
			
			h.printHorarioss();
			
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
