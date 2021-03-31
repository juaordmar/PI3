/*
 * ejercicio4.c
 *
 *  Created on: 18 dic. 2020
 *      Author: LENOVO
 */

#include "ejercicio4.h"

long ej4RecSinMem(int a, int b){
	long res;
	if(a<2 && b<2){
		res = a + (b*b);
	}else if(a<2 || b<2){
		res = (a*a) + b;
	}else{
		res = ej4RecSinMem(a/2, b-1) +
				ej4RecSinMem(a/3, b-2) +
				ej4RecSinMem(a-2, b/4);
	}return res;
}

long ej4RecConMem(int a, int b){
	long matriz[a+1][b+1];
	return ej4RecConMemAux(a, b, matriz);
}

long ej4RecConMemAux(int a, int b, long matriz[a+1][b+1]){
	long res;
	if(a<2 && b<2){
		matriz[a][b] = a + (b*b);
	}else if(a<2 || b<2){
		matriz[a][b] = (a*a) + b;
	}else{
		matriz[a][b] = ej4RecConMemAux(a/2, b-1, matriz) +
				ej4RecConMemAux(a/3, b-2, matriz) +
				ej4RecConMemAux(a-2, b/4, matriz);
	}return matriz[a][b];
}

long ej4Iterativo(int a, int b){
	long matriz[a+1][b+1];
	int i = 0;
	while(i<=a){
		int j = 0;
		while(j<=b){
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


