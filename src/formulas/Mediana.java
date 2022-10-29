package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class Mediana {

	private static List<Double> listaMediana = new ArrayList();

	public static void setValor(Double valor){
		listaMediana.add(valor);
	}
	
	public static Double getMediana(){
		
		/*declaraçao das variáveis e atribuição do tamanho do vetor
		 * a variável tamanho*/
		int tamanho = listaMediana.size();
		Double mediana = 0.0;
		
		/*Controle de fluxo para entrar na condição se o resto da
		 * divisão do tamanho do vetor tem resto igual a 0 (número par) 
		 */
		if(tamanho % 2 == 0){
			
			/*divide o tamanho do vetor por 2 e o resultado subtrai por 1
			 * e atribui a variável pos1.
			 * Se subtrai 1, porque a vetor em java se inicia na posição 0*/
			int pos1 = (tamanho / 2) - 1;
			/*divide o tamanho do vetor por 2 e o resultado é somado por um
			 * e este resultado é subtraido por 1, pois o vetor em java se inicia
			 * na posição 0 
			 */
			int pos2 = ((tamanho / 2) + 1) - 1;
			
			/*recupera o valor do vetor na posição pos1 e soma com o valor
			 *  do vetor na posição da variável pos2 e divide por 2 e atribui
			 *  este resultado na variável mediana*/
			mediana = ( (listaMediana.get(pos1) + listaMediana.get(pos2)) / 2 );
		}else{//tamanho do vetor tem resto diferente de 0 (número ímpar)
			/*soma mais um numero para ficar par e divide por 2 para 
			 * encontrar exatamente o meio do vetor, e subtrai 1, pois o 
			 * vetor em java se inicia na posição 0
			 */
			mediana = listaMediana.get( ((tamanho + 1) / 2) -1 );
		}
		//arredonda o valor para até 2 casa decimais
		mediana = Ordenador.arredondar(mediana);

		//retorna o valor para o objeto que chamou o método.
		return mediana;
	}


	public static List<Double> getValores(){
		listaMediana = Ordenador.crescente( listaMediana );
		return listaMediana;
	}
}