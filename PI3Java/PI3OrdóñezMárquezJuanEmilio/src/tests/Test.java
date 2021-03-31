package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;
import ejercicios.Ejercicio4;
import us.lsi.common.Files2;
import us.lsi.common.IntPair;
import us.lsi.common.Tuple3;

public class Test {

	public static void main(String[] args) {
		int i = 1;
		while(i<=6) {
			test1("../PI3OrdóñezMárquezJuanEmilio/ficheros/PI3Ej1DatosEntrada"+i+".txt");
			i++;
		}test3("../PI3OrdóñezMárquezJuanEmilio/ficheros/PI3Ej3DatosEntrada.txt");
		test4("../PI3OrdóñezMárquezJuanEmilio/ficheros/PI3Ej4DatosEntrada.txt");
		test2("../PI3OrdóñezMárquezJuanEmilio/ficheros/PI3Ej2DatosEntrada.txt");
	} 
	
	public static void test1(String dirFichero) { //
		List<String> lista = Files2.streamFromFile(dirFichero).collect(Collectors.toList());
		int s = lista.size();
		if(s<=32) {
			System.out.println("Matriz de entrada ("+s+"*"+s+"):");
		}else{
			System.out.println("Matriz de entrada ("+s+"*"+s+"). No se muestra dado el tamaño");
		}Integer[][] matrizDeFichero = new Integer[s][s];
		int i = 0;
		while(i<s) {
			String[] fila = lista.get(i).split(" ");
			int j = 0;
			while(j<s) {
				matrizDeFichero[i][j] = Integer.parseInt(fila[j]);
				if(s<=32) {
					System.out.print(matrizDeFichero[i][j] + "   ");
				}j++;
			}i++;
			if(s<=32) {
				System.out.print("\n");
			}
		}if(s<=32) {
			System.out.println("\n");
		}System.out.println("Es matriz valida? " + Ejercicio1.ej1Recursivo(matrizDeFichero));
		System.out.println("================================================================");
	}
	
	public static void test2(String dirFichero) {
		List<String> lista = Files2.streamFromFile(dirFichero).collect(Collectors.toList());
		int i = 0;
		while(i<lista.size()) {
			String[] array = lista.get(i).split(",");
			List<Integer> entrada = new ArrayList<>();
			int j = 0;
			while(j<array.length) {
				entrada.add(Integer.valueOf(array[j].trim()));
				j++;
			}i++;
			System.out.println("Lista de entrada: "+entrada);
			//Tuple3<Integer,Integer,Integer> res = Ejercicio2.ej2Recursivo(entrada);
			//System.out.println("Secuencia de suma mayor en intervalo ["+res.v1+", "+res.v2+1+")");
		}
	}
	
	public static void test3(String dirFichero) {
		List<String> lista = Files2.streamFromFile(dirFichero).collect(Collectors.toList());
		int i = 0;
		while(i<lista.size()) {
			Integer n = Integer.parseInt(lista.get(i).split("=")[1]);
			System.out.println("Entero de entrada: "+n);
			System.out.println("F. Recursiva sin memoria: " + Ejercicio3.ej3RecSinMem(n));
			System.out.println("F. Recursiva con memoria: " + Ejercicio3.ej3RecConMem(n));
			System.out.println("F. Iterativa: " + Ejercicio3.ej3Iterativo(n));
			System.out.println("===============================================================");
			i++;
		}
	}
	
	public static void test4(String dirFichero) {
		List<String> lista = Files2.streamFromFile(dirFichero).collect(Collectors.toList());
		int i = 0;
		while(i<lista.size()) {
			Integer a = Integer.parseInt(lista.get(i).split(",")[0]);
			Integer b = Integer.parseInt(lista.get(i).split(",")[1]);
			System.out.println("Pares de entrada:\n(a, b) = ("+a+", "+b+")");
			System.out.println("F. Recursiva sin memoria: " + Ejercicio4.ej4RecSinMem(IntPair.of(a, b)));
			System.out.println("F. Recursiva con memoria: " + Ejercicio4.ej4RecConMem(IntPair.of(a, b)));
			System.out.println("F. Iterativa: " + Ejercicio4.ej4Iterativo(IntPair.of(a, b)));	
			System.out.println("===============================================================");
			i++;
		}
	}

}
