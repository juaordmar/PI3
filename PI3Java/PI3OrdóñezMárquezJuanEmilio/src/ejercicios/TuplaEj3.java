package ejercicios;

import java.math.BigInteger;

public class TuplaEj3 {
	
	BigInteger a = null;
	BigInteger b = null;
	BigInteger c = null;
	BigInteger res = null;
	
	public static TuplaEj3 create(BigInteger a, BigInteger b, BigInteger c, BigInteger res) {
		return new TuplaEj3(a, b, c, res);
	}
	
	private TuplaEj3(BigInteger a, BigInteger b, BigInteger c, BigInteger res) {
		super();
		this.a = a;
		this.b = b; 
		this.c = c;
		this.res = res;
	}
	
	public static TuplaEj3 nx(TuplaEj3 t) {
		t.a = t.b;
		t.b = t.c;
		t.c = t.res;
		t.res = t.c.multiply(BigInteger.valueOf(4)).add(t.b).add(t.a);
		return t;
	}

}
