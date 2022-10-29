package formulas;

import java.util.ArrayList;
import java.util.List;
import utilitarios.Ordenador;

public class MediaHarmonica {

	private static List<Double> listaMediaHarmonica = new ArrayList();
	
	public static void setValor(Double valor){
		listaMediaHarmonica.add(valor);
	}
	
	public static Double getMediaHarmonica(){
		
		//declaração das variaveis
		Double somatorio = 0.0;
		Double resultado = 0.0;
		
		/*loop que faz a somatória da divisão de 1 
		 * pelo valor da posição atual do vetor
		 * e atribui à variável somatorio*/
		for(int i=0;i<listaMediaHarmonica.size();i++){
			somatorio += (1 / listaMediaHarmonica.get(i));
		}
		
		/*divide o tamanho do vetor pela somatória obtida
		 * e atribui à variável resultado*/
		resultado = (listaMediaHarmonica.size() / somatorio);
		
		//arredonda o valor para até 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o método.
		return resultado;
	}
	
	
	public static List<Double> getValores(){
		return listaMediaHarmonica;
	}
}