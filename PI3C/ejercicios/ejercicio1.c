/*
 * ejercicio1.c
 *
 *  Created on: 30 nov. 2020
 *      Author: LENOVO
 */

#include "ejercicio1.h"

bool ej1Recursivo(int a, int matriz[a][a]){
	return ej1RecAux(a, matriz, 0, 0, a);
}

bool ej1RecAux(int a, int matriz[a][a], int i, int j, int tam) {
	int maxFila = i + (tam-1);
	int maxColumna = j + (tam-1);
	set vertices = set_empty(int_type);
	set_add(&vertices, &matriz[i][j]);
	set_add(&vertices, &matriz[maxFila][j]);
	set_add(&vertices, &matriz[i][maxColumna]);
	set_add(&vertices, &matriz[maxFila][maxColumna]);
	bool res = set_size(&vertices)==4 || tam==1;
	if(tam%2==0) {
		if(res==true) {
			return ej1RecAux(a, matriz, i, j, tam/2)
					&& ej1RecAux(a, matriz, i+tam/2, j, tam/2)
					&& ej1RecAux(a, matriz, i, j+tam/2, tam/2)
					&& ej1RecAux(a, matriz, i+tam/2, j+tam/2, tam/2);
		}else {
			return res;
		}
	}else{
		return res;
	}
}
