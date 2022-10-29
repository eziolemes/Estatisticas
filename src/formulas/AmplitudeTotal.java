package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class AmplitudeTotal {

	private static List<Double> listaAmplitude = new ArrayList();
	
	public static void setValor(Double valor){
		listaAmplitude.add(valor);
	}
	
	public static Double getAmplitudeTotal(){
		//declaração das variáveis e atribuições do menor e maior valor
		Double menor = listaAmplitude.get(0);
		Double maior = listaAmplitude.get( listaAmplitude.size() - 1 );
		
		/*subtrai o maior valor pelo menor valor para se obter 
		 * a aplitude, e o valor e retornado à variável amplitude
		 */
		Double amplitude = maior - menor;
		
		//arredonda o valor para até 2 casa decimais
		amplitude = Ordenador.arredondar(amplitude);
		
		//retorna o valor para o objeto que chamou o método.
		return amplitude;
	}
	
	public static List<Double> getValores(){
		listaAmplitude = Ordenador.crescente( listaAmplitude );
		return listaAmplitude;
	}
	
}