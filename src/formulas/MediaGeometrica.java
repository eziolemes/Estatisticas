package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class MediaGeometrica {

	private static List<Double> listaMediaGeometrica = new ArrayList();
	
	public static void setValor(Double valor){
		listaMediaGeometrica.add(valor);
	}
	
	public static List<Double> getValores(){
		return listaMediaGeometrica;
	}
	
	public static Double getMediaGeometrica(){
		
		//tamanho do vetor dividido por 1
		Double expoente = (double) 1/listaMediaGeometrica.size();
		Double produto = (double) 1;
		
		//produtória(multiplicação) dos valores do vetor
		for(Double i : listaMediaGeometrica){
			produto *= i;//+= atribui à variável a multiplicação do seu valor atual com o valor informado.
		}
		
		/*o método pow da classe Math calcula a raiz
		 * dos valores passados por parâmetro e atribui a 
		   variável resultado*/
		Double resultado = Math.pow(produto, expoente);
		
		//arredonda o valor para até 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o método.
		return resultado;
	}
}