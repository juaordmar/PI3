package ejercicios;

import java.util.List;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple3;

public class Ejercicio2 {
	
	public static Tuple3<Integer,Integer,Integer> ej2Recursivo(List<Integer> entrada){
		return ej2RecAux(entrada, 0, 0, 0, 0, 0);
	}
	
	private static Tuple3<Integer,Integer,Integer> ej2RecAux(List<Integer> entrada,
			int n, int a, int b, int maxb, int max){
		if(n<entrada.size()) {
			if(entrada.get(n) > maxb + entrada.get(n)) {
				a = n;
				maxb = entrada.get(n);
			}else {
				maxb = maxb + entrada.get(n);
				if(max<maxb) {
					return ej2RecAux(entrada, n+1, a, n, maxb, maxb);
				}else {
					return ej2RecAux(entrada, n+1, a, b, maxb, max);
				}
			}
		}Tuple3<Integer,Integer,Integer> res = Tuple.create(a, b, max);
		return res;
	} 
	
	//Este ejercicio no está presentado ya que no he podido comprobar si funciona adecuadamente
	
}
