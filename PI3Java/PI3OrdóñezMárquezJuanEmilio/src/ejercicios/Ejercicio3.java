package ejercicios;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio3 {
	
	public static BigInteger ej3RecSinMem(Integer n) {
		BigInteger res = null;
		if(n>2) {
			res = (ej3RecSinMem(n-1)).multiply(BigInteger.valueOf(4))
					.add(ej3RecSinMem(n-2).add(ej3RecSinMem(n-3)));
		}else if(n==1 || n==2) {
			res = BigInteger.ONE;
		}else {
			res = BigInteger.TWO;
		}return res;
	}
	
	public static BigInteger ej3RecConMem(Integer n) {
		return ej3RecConMemAux(n, new HashMap<>());
	}
	
	private static BigInteger ej3RecConMemAux(Integer n, Map<Integer,BigInteger> m) {
		BigInteger res;
		if(m.containsKey(n)) {
			res = m.get(n);
		}else {
			if(n==1 || n==2) {
				res = BigInteger.ONE;
			}else if(n==0){
				res = BigInteger.TWO;
			}else {
				res = (ej3RecConMemAux(n-1, m)).multiply(BigInteger.valueOf(4))
						.add(ej3RecConMemAux(n-2, m).add(ej3RecConMemAux(n-3, m)));
			}m.put(n, res);
		}return res;
	}
	
	public static BigInteger ej3IterativoTupla(Integer n) { //f(n) = 4*f(n-1) + f(n-2) + f(n-3)
		Integer i = 3;//res = f(3), c = f(2), b = f(1), a = f(0)
		BigInteger a = BigInteger.TWO; BigInteger b = BigInteger.ONE; 
		BigInteger res = BigInteger.valueOf(7);
		TuplaEj3 t = TuplaEj3.create(a, b, b, res);
		if(n>2) {	
			while(i<n) {
				TuplaEj3.nx(t);
				i++;
			}return t.res;
		}else if(n==1 || n==2) {
			return b;
		}else {
			return a;
		}
		
	}
	
	public static BigInteger ej3Iterativo(Integer n) {
		Integer i = 3;//res = f(3), c = f(2), b = f(1), a = f(0)
		BigInteger a = BigInteger.TWO; BigInteger b = BigInteger.ONE; BigInteger c = BigInteger.ONE;
		BigInteger res = BigInteger.valueOf(7);
		if(n>2) {
			while(i<n) {
				a = b;
				b = c;
				c = res;
				res = c.multiply(BigInteger.valueOf(4)).add(b).add(a);
				i++;
			}return res;
		}else if(n==1 || n==2) {
			return b;
		}else {
			return a;
		}
	}
	
}
