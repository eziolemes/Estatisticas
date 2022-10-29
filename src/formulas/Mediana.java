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
		
		/*declara�ao das vari�veis e atribui��o do tamanho do vetor
		 * a vari�vel tamanho*/
		int tamanho = listaMediana.size();
		Double mediana = 0.0;
		
		/*Controle de fluxo para entrar na condi��o se o resto da
		 * divis�o do tamanho do vetor tem resto igual a 0 (n�mero par) 
		 */
		if(tamanho % 2 == 0){
			
			/*divide o tamanho do vetor por 2 e o resultado subtrai por 1
			 * e atribui a vari�vel pos1.
			 * Se subtrai 1, porque a vetor em java se inicia na posi��o 0*/
			int pos1 = (tamanho / 2) - 1;
			/*divide o tamanho do vetor por 2 e o resultado � somado por um
			 * e este resultado � subtraido por 1, pois o vetor em java se inicia
			 * na posi��o 0 
			 */
			int pos2 = ((tamanho / 2) + 1) - 1;
			
			/*recupera o valor do vetor na posi��o pos1 e soma com o valor
			 *  do vetor na posi��o da vari�vel pos2 e divide por 2 e atribui
			 *  este resultado na vari�vel mediana*/
			mediana = ( (listaMediana.get(pos1) + listaMediana.get(pos2)) / 2 );
		}else{//tamanho do vetor tem resto diferente de 0 (n�mero �mpar)
			/*soma mais um numero para ficar par e divide por 2 para 
			 * encontrar exatamente o meio do vetor, e subtrai 1, pois o 
			 * vetor em java se inicia na posi��o 0
			 */
			mediana = listaMediana.get( ((tamanho + 1) / 2) -1 );
		}
		//arredonda o valor para at� 2 casa decimais
		mediana = Ordenador.arredondar(mediana);

		//retorna o valor para o objeto que chamou o m�todo.
		return mediana;
	}


	public static List<Double> getValores(){
		listaMediana = Ordenador.crescente( listaMediana );
		return listaMediana;
	}
}