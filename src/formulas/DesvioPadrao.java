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
		//declaração das variáveis
		Double total = 0.0;
		Double desvioPadrao = 0.0;
		
		//loop que percorre a somatória
		for(int i=0;i<listaDesvioPadrao.size();i++){
			/*subtrai o valor da posição atual no vetor pelo valor da média
			 * e atribui à variável valor*/
			Double valor = ((listaDesvioPadrao.get(i) - mediaAritmetica ) );
			valor *= valor; //multiplicando por ela mesma, para elevar ao quadrado;
			
			//total da somatória
			total += valor;
		}
		
		/*divide o valor total pelo tamanho do vetor menos um, que é da fórmula
		 * e atribui o valor à variável desvioPadrao*/
		desvioPadrao = (total / (listaDesvioPadrao.size() - 1));
		
		/*o método sqrt da classe Math calcula a raiz quadrada do valor da variável
		 * passada por parametro*/
		desvioPadrao = Math.sqrt(desvioPadrao);
		
		//arredonda o valor para até 2 casa decimais
		desvioPadrao = Ordenador.arredondar(desvioPadrao);
		
		//retorna o valor para o objeto que chamou o método.
		return desvioPadrao;
	}
	
	public static List<Double> getValores(){
		return listaDesvioPadrao;
	}
}