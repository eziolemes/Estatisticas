package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class DesvioPadrao {
	
	private static List<Double> listaDesvioPadrao = new ArrayList();
	
	public static void setValor(Double valor){
		listaDesvioPadrao.add(valor);
	}

	public static Double getDesvioPadrao(Double mediaAritmetica){
		//declara��o das vari�veis
		Double total = 0.0;
		Double desvioPadrao = 0.0;
		
		//loop que percorre a somat�ria
		for(int i=0;i<listaDesvioPadrao.size();i++){
			/*subtrai o valor da posi��o atual no vetor pelo valor da m�dia
			 * e atribui � vari�vel valor*/
			Double valor = ((listaDesvioPadrao.get(i) - mediaAritmetica ) );
			valor *= valor; //multiplicando por ela mesma, para elevar ao quadrado;
			
			//total da somat�ria
			total += valor;
		}
		
		/*divide o valor total pelo tamanho do vetor menos um, que � da f�rmula
		 * e atribui o valor � vari�vel desvioPadrao*/
		desvioPadrao = (total / (listaDesvioPadrao.size() - 1));
		
		/*o m�todo sqrt da classe Math calcula a raiz quadrada do valor da vari�vel
		 * passada por parametro*/
		desvioPadrao = Math.sqrt(desvioPadrao);
		
		//arredonda o valor para at� 2 casa decimais
		desvioPadrao = Ordenador.arredondar(desvioPadrao);
		
		//retorna o valor para o objeto que chamou o m�todo.
		return desvioPadrao;
	}
	
	public static List<Double> getValores(){
		return listaDesvioPadrao;
	}
}