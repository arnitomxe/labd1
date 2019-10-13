package imperative;

import java.util.Set;
import java.util.HashSet;
import static java.lang.Math.sqrt;

public class PerfectNumber {

	public enum STATE {
		PERFECT,
		ABUNDANT,
		DEFICIENT;
		
		static STATE getValue(int n) {
			if(isPerfect(n)) return PERFECT;
			else
				if(isAbundant(n)) return ABUNDANT;
				else return DEFICIENT;
		}
	}
	
	static public boolean isDivisor(int n, int potDivisor) {
		return n % potDivisor == 0;
	}
	
	//divisor list generator
	public static Set<Integer> divisors(int n) {
		HashSet<Integer> divisors = new HashSet<Integer>();
		for (int i=1;i<= sqrt(n);i++) {
			if(isDivisor(n,i)) {
				divisors.add(i);
				divisors.add(n/i);
			}
		}
		return divisors;
	}
	
	static public int sum(Set<Integer> divisors) {
		int sum = 0;
		for(Integer i:divisors)
			sum += i.intValue();
		return sum;
	}
	
	
	//number classifier
	static public boolean isPerfect(int n) {
		return sum(divisors(n)) - n == n;
	}
	
	static public boolean isAbundant(int n) {
		return sum(divisors(n)) - n > n;
	}
	
	static public boolean isDeficient(int n) {
		return sum(divisors(n)) - n < n;
	}
	
	static public STATE process(int n) {
		return STATE.getValue(n);
	}
	/*	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Number 6 is " + PerfectNumber.process(6));
		System.out.println("Number 8 is " + PerfectNumber.process(8));
		System.out.println("Number 20 is " + PerfectNumber.process(20));
		System.out.println("Number 16 is " + PerfectNumber.process(16));
		System.out.println("Number 1 is " + PerfectNumber.process(1));
	}
	*/

}
