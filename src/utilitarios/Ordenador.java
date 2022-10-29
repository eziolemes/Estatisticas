package utilitarios;

import java.math.BigDecimal;
import java.util.List;

public class Ordenador {

	public static List<Double> crescente(List<Double> lista){
		Double aux = 0.0;

		for(int i = 0; i< lista.size(); i++){
			for(int j = 0; j<(lista.size() - 1); j++){
				if(lista.get(j) > lista.get(j + 1)){
					aux = lista.get(j);
					lista.set(j, lista.get(j+1));
					lista.set(j+1, aux);
				}
			}
		}
		
		return lista;
	}
	
	public static Double arredondar(Double valor){
		BigDecimal arredondar = new BigDecimal(valor);
		arredondar = arredondar.setScale(2, BigDecimal.ROUND_HALF_UP); 
		valor = Double.parseDouble(arredondar.toString());
		
		return valor;
	}
}
