package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class MediaPonderada {
	
	private static List<Double> vetorA = new ArrayList();
	private static List<Double> vetorB = new ArrayList();
	
	public static Double calculaMediaPonderada(){
		
		//declara��o das vari�veis
		Double xi = 0.0;
		Double peso = 0.0;
		Double resultado = 0.0;
		
		/*loop que faz a somat�ria do produto entre valores dos vetores
		 * onde s�o atribuidos a vari�vel xi e a somat�ria do segundo vetor
		 * que � o peso do valor
		 */
		for(int i=0;i<vetorA.size();i++){
			xi += ( vetorA.get(i) * vetorB.get(i) );
			peso += vetorB.get(i);
		}
		
		//Divis�o do total das entradas pelo total do peso
		resultado = (xi / peso);
		
		//arredonda o valor para at� 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o m�todo.
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