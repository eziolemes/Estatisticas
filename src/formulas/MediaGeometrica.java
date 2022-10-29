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
		
		//produt�ria(multiplica��o) dos valores do vetor
		for(Double i : listaMediaGeometrica){
			produto *= i;//+= atribui � vari�vel a multiplica��o do seu valor atual com o valor informado.
		}
		
		/*o m�todo pow da classe Math calcula a raiz
		 * dos valores passados por par�metro e atribui a 
		   vari�vel resultado*/
		Double resultado = Math.pow(produto, expoente);
		
		//arredonda o valor para at� 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o m�todo.
		return resultado;
	}
}