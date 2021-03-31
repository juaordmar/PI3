/*
 * ejercicio3.c
 *
 *  Created on: 18 dic. 2020
 *      Author: LENOVO
 */

#include "ejercicio3.h"

long long ej3RecSinMem(int n){
	long long res = 0;
	if(n>2){
		res = 4 * (ej3RecSinMem(n-1)) + ej3RecSinMem(n-2) + ej3RecSinMem(n-3);
	}else if(n==1 || n==2){
		res = 1;
	}else{
		res = 2;
	}return res;
}

long long ej3RecConMem(int n){
	hash_table supu = hash_table_empty(int_type, long_pair_type);
	return ej3RecConMemAux(n, &supu);
}

long long ej3RecConMemAux(int n, hash_table* m){
	long long res = 0;
	if(hash_table_contains(m, &n)){
		res = *((long long *)hash_table_get(m, &n));
	}else {
		if(n==1 || n==2){
			res = 1;
		}else if(n==0){
			res = 2;
		}else{
			res = 4 * (ej3RecConMemAux(n-1, m)) + ej3RecConMemAux(n-2, m) + ej3RecConMemAux(n-3, m);
		}hash_table_put(m, &n, &res);
	}return res;
}

long long ej3Iterativo(int n){
	int i = 3;//res = f(3), c = f(2), b = f(1), a = f(0)
	long long a = 2; long long b = 1; long long c = 1;
	long long res = 7;
	if(n>2) {
		while(i<n) {
			a = b;
			b = c;
			c = res;
			res = (4 * c) + b + a;
			i++;
		}return res;
	}else if(n==1 || n==2) {
		return b;
	}else {
		return a;
	}
}


