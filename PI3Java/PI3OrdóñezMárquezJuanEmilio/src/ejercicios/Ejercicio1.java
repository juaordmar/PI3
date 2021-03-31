package ejercicios;

import java.util.HashSet;
import java.util.Set;

public class Ejercicio1 {
	
	public static Boolean ej1Recursivo(Integer[][] matriz) {
		 return ej1RecAux(matriz, 0, 0, matriz.length);
	}
	
	private static Boolean ej1RecAux(Integer[][] matriz, int i, int j, int tam) {
		int maxFila = i + (tam-1);
		int maxColumna = j + (tam-1);
		Set<Integer> vertices = new HashSet<>();
		vertices.add(matriz[i][j]);
		vertices.add(matriz[maxFila][j]);
		vertices.add(matriz[i][maxColumna]);
		vertices.add(matriz[maxFila][maxColumna]);
		Boolean res = vertices.size()==4 || tam==1;
		if(tam%2==0) {
			if(res==true) {
				return ej1RecAux(matriz, i, j, tam/2)
						&& ej1RecAux(matriz, i+tam/2, j, tam/2)
						&& ej1RecAux(matriz, i, j+tam/2, tam/2)
						&& ej1RecAux(matriz, i+tam/2, j+tam/2, tam/2);
			}else {
				return res;
			}
		}else{
			return res;
		}
	}
	
}
