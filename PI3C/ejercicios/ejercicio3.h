/*
 * ejercicio3.h
 *
 *  Created on: 18 dic. 2020
 *      Author: LENOVO
 */

#ifndef EJERCICIO3_H_
#define EJERCICIO3_H_

#include "types/types.h"
#include "types/hash_table.h"

long long ej3RecSinMem(int n);
long long ej3RecConMem(int n);
long long ej3RecConMemAux(int n, hash_table* m);
long long ej3Iterativo(int n);

#endif /* EJERCICIO3_H_ */
