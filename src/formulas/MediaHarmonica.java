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
		
		//declara��o das variaveis
		Double somatorio = 0.0;
		Double resultado = 0.0;
		
		/*loop que faz a somat�ria da divis�o de 1 
		 * pelo valor da posi��o atual do vetor
		 * e atribui � vari�vel somatorio*/
		for(int i=0;i<listaMediaHarmonica.size();i++){
			somatorio += (1 / listaMediaHarmonica.get(i));
		}
		
		/*divide o tamanho do vetor pela somat�ria obtida
		 * e atribui � vari�vel resultado*/
		resultado = (listaMediaHarmonica.size() / somatorio);
		
		//arredonda o valor para at� 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o m�todo.
		return resultado;
	}
	
	
	public static List<Double> getValores(){
		return listaMediaHarmonica;
	}
}