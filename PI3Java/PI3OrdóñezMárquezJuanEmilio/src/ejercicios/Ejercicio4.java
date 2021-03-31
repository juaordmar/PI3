package ejercicios;

import java.util.HashMap;
import java.util.Map;

import us.lsi.common.IntPair;

public class Ejercicio4 {
	
	public static Long ej4RecSinMem(IntPair enteros) {
		Long res;
		if(enteros.first<2 && enteros.second<2) {
			res = (long)enteros.first + (enteros.second*enteros.second);
		}else if(enteros.first<2 || enteros.second<2) {
			res = (long)(enteros.first*enteros.first) + enteros.second;
		}else {
			res = ej4RecSinMem(IntPair.of(enteros.first/2, enteros.second-1)) +
					ej4RecSinMem(IntPair.of(enteros.first/3, enteros.second-2)) +
					ej4RecSinMem(IntPair.of(enteros.first-2, enteros.second/4));
		}return res;
	}
	
	public static Long ej4RecConMem(IntPair enteros) {
		return ej4RecConMemAux(enteros, new HashMap<>());
	}
	
	private static Long ej4RecConMemAux(IntPair enteros, Map<IntPair,Long> dicc) {
		Long res;
		if(dicc.containsKey(enteros)) {
			res = dicc.get(enteros);
		}else if(enteros.first<2 && enteros.second<2) {
			res = (long)enteros.first + (enteros.second*enteros.second);
		}else if(enteros.first<2 || enteros.second<2) {
			res = (long)(enteros.first*enteros.first) + enteros.second;
		}else {
			res = ej4RecConMemAux(IntPair.of(enteros.first/2, enteros.second-1), dicc) +
					ej4RecConMemAux(IntPair.of(enteros.first/3, enteros.second-2), dicc) +
					ej4RecConMemAux(IntPair.of(enteros.first-2, enteros.second/4), dicc);
		}dicc.put(enteros, res);
		return res;
	}
	
	public static Integer ej4Iterativo(IntPair enteros) {
		Integer a = enteros.first; Integer b = enteros.second;
		Integer[][] matriz = new Integer[a+1][b+1];
		int i = 0;
		while(i<=a) {
			int j = 0;
			while(j<=b) {
				if(i<2 && j<2) {
					matriz[i][j] = i + (j*j);
				}else if(i<2 || j<2) {
					matriz[i][j] = (i*i) + j;
				}else {
					matriz[i][j] = matriz[i/2][j-1] +
							matriz[i/3][j-2] +
							matriz[i-2][j/4];
				}j++;
			}i++;
		}return matriz[a][b];
	}
	
}
