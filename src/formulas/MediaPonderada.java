package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class MediaPonderada {
	
	private static List<Double> vetorA = new ArrayList();
	private static List<Double> vetorB = new ArrayList();
	
	public static Double calculaMediaPonderada(){
		
		//declaração das variáveis
		Double xi = 0.0;
		Double peso = 0.0;
		Double resultado = 0.0;
		
		/*loop que faz a somatória do produto entre valores dos vetores
		 * onde são atribuidos a variável xi e a somatória do segundo vetor
		 * que é o peso do valor
		 */
		for(int i=0;i<vetorA.size();i++){
			xi += ( vetorA.get(i) * vetorB.get(i) );
			peso += vetorB.get(i);
		}
		
		//Divisão do total das entradas pelo total do peso
		resultado = (xi / peso);
		
		//arredonda o valor para até 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o método.
		return resultado;
	}
	
	public static void setValor(Double valor, String vetor){
		if(vetor.equals("A")){
			vetorA.add(valor);
		}else{
			vetorB.add(valor);
		}
	}
	
	public static List<Double>getVetor(String vetor){
		if(vetor.equals("A")){
			return vetorA;
		}else{
			return vetorB;
		}
	}
	
}