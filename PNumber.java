import java.util.Set;
import java.util.HashSet;
import static java.lang.Math.sqrt;

public class PNumber {

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
	
	static public String detect(int n) {
		if(isPerfect(n)) return "Perfect";
		else
			if(isAbundant(n)) return "Abundant";
			else return "Deficient";
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Number 6 is " + PNumber.detect(6));
		System.out.println("Number 8 is " + PNumber.detect(8));
		System.out.println("Number 20 is " + PNumber.detect(20));
		System.out.println("Number 16 is " + PNumber.detect(16));
		System.out.println("Number 1 is " + PNumber.detect(1));
	}

}
