package formulas;

import java.util.ArrayList;
import java.util.List;

import utilitarios.Ordenador;

public class MediaAritmetica {

	private static List<Double> listaMediaAritmetica = new ArrayList();

	public static void setValor(Double valor){
		listaMediaAritmetica.add(valor);
	}
	
	public static Double getMediaAritmetica(){
		//declara��o das vari�veis
		Double valor = 0.0; 
		Double resultado = 0.0;
		
		//loop que soma todos os valores informados
		for(int i=0;i<listaMediaAritmetica.size();i++){
			valor += listaMediaAritmetica.get(i); //+= atribui � vari�vel a soma do seu valor atual com o valor informado.
		}
		
		//divide o valor total pela quantidade de valores informados e atribui a vari�vel resultado
		resultado = valor / listaMediaAritmetica.size();
		
		//arredonda o valor para at� 2 casa decimais
		resultado = Ordenador.arredondar(resultado);
		
		//retorna o valor para o objeto que chamou o m�todo.
		return resultado;
	}
	
	public static List<Double> getValores(){
		return listaMediaAritmetica;
	}
}