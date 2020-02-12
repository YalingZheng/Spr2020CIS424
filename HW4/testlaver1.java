
public class testlaver1 {

	public static void main(String[] args) {
		String s = "curnumber = 5 * 6;";
		System.out.println("Lexical Anaysis result for " + s);
		laver1 la1 = new laver1(s);
		int endindex = s.length();
		System.out.println("endindex of s is " + endindex);
		la1.analysis(0, endindex);
		
		System.out.println();
		System.out.println("**********************************");
		System.out.println();
		
		String s2 = "curnumber = 5.3 * 6;";
		System.out.println("Lexical Anaysis result for " + s2);
		laver1 la2 = new laver1(s2);
		int endindex2 = s2.length();
		System.out.println("endindex of s is " + endindex2);
		la2.analysis(0, endindex);
	}

}
