/*
 * tests.c
 *
 *  Created on: 30 nov. 2020
 *      Author: LENOVO
 */

#include "tests.h"

int main(){
	test1("ficheros/PI3Ej1DatosEntrada1.txt");
	test1("ficheros/PI3Ej1DatosEntrada2.txt");
	test1("ficheros/PI3Ej1DatosEntrada3.txt");
	test1("ficheros/PI3Ej1DatosEntrada4.txt");
	test1("ficheros/PI3Ej1DatosEntrada5.txt");
	test1("ficheros/PI3Ej1DatosEntrada6.txt");
	test3("ficheros/PI3Ej3DatosEntrada.txt");
	test4("ficheros/PI3Ej4DatosEntrada.txt");
}

void test1(char * file){
	iterator it1 = file_iterable_pchar(file);
	iterator it2 = file_iterable_pchar(file);
	int tam = iterable_size(&it1);
	int matriz[tam][tam];
	nuevaMatriz(tam, matriz, &it2);
	printf("Matriz de entrada (%d * %d):\n", tam, tam);
	if(tam<=32){
		int a = 0;
		while (a<tam){
			int b = 0;
			while(b<tam){
				if(b==tam-1){
					printf("%5d\n", matriz[a][b]);
				}else{
					printf("%5d", matriz[a][b]);
				}b++;
			}a++;
		}
	}else{
		printf("No se muestra dado el tamaño\n");
	}bool res = ej1Recursivo(tam, matriz);
	char * validez = res ? "true" : "false";
	printf("\nEs matriz valida?: %s\n==========================================\n",validez);
}

void nuevaMatriz(int n, int matriz[n][n], iterator* i){
	int j = 0;
	while(iterable_has_next(i)){
		char * linea = (char *)iterable_next(i);
		iterator it = split_iterable_pchar(linea, " ");
		int k = 0;
		while(iterable_has_next(&it)){
			char* num = (char *)iterable_next(&it);
			int n = int_parse_s(num);
			matriz[j][k] = n;
			k++;
		}j++;
	}
}

void test3(char * file){
	iterator f = file_iterable_pchar(file);
	while(iterable_has_next(&f)){
		char * linea = (char *)iterable_next(&f);
		char * pos_igual = strrchr(linea, '=');
		char * num = strdup(pos_igual+1);
		printf("Entero de entrada: %s\n",num);
		printf("F. Recursiva sin memoria: %llu \n", ej3RecSinMem(int_parse_s(num)));
		printf("F. Recursiva con memoria: %llu \n", ej3RecConMem(int_parse_s(num)));
		printf("F. Iterativa: %llu \n", ej3Iterativo(int_parse_s(num)));
		printf("===============================================================\n");
	}
}


void test4(char * file){
	iterator f = file_iterable_pchar(file);
	while(iterable_has_next(&f)){
		char * linea = (char *)iterable_next(&f);
		strtok(linea, ","); //consigo el primer valor de la linea
		int a = int_parse_s(linea);
		char * limit = strtok(NULL, " "); //consigo el segundo valor de la linea
		int b = int_parse_s(limit);
		printf("Pares de entrada:\n(a, b) = (%i, %i)\n",a,b);
		printf("F. Recursiva sin memoria: %li\n", ej4RecSinMem(a,b));
		printf("F. Recursiva con memoria: %li\n", ej4RecConMem(a, b));
		printf("F. Iterativa: %li\n", ej4Iterativo(a,b));
		printf("===============================================================\n");
	}
}







