package sortingandsearching;

public class SquareRoot {

	public static double sqrt(double x){
		double lo,hi;
		if(x<1){
			lo =x;
			hi=1;
		}else{
			lo=1;
			hi=x;
		}
		while(compare(lo,hi)==Ordering.SMALLER){
			double  mid = lo+0.5*(hi-lo);
			Ordering diff = compare(mid*mid,x);
			if(diff==Ordering.SMALLER){
				lo = mid;
			}
			else if(diff==Ordering.LARGER){
				hi=mid;
			}
			else{
				return mid;
			}
		}
		return lo;

	}

	public static Ordering compare(double a, double b){
		final double EPSILON = 0.000001;
		double diff = (a-b)/b;
		return diff<-EPSILON? Ordering.SMALLER:
			(diff>EPSILON)?Ordering.LARGER:Ordering.EQUAL;
	}

	private static enum Ordering {
		SMALLER, EQUAL, LARGER
	}

	public static void main(String[] args){
		System.out.println(sqrt(1000000));
	}

}
