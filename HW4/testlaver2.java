
public class testlaver2 {

	public static void main(String[] args) {
		String s = "curnumber = 5 * 6;";
		System.out.println("Lexical Anaysis result for " + s);
		laver2 la2 = new laver2(s);
		int endindex = s.length();
		System.out.println("endindex of s is " + endindex);
		la2.analysis();
		
		System.out.println();
		System.out.println("**********************************");
		System.out.println();
		
		String s2 = "curnumber = 5.3 * 6;";
		System.out.println("Lexical Anaysis result for " + s2);
		laver2 la22 = new laver2(s2);
		int endindex2 = s2.length();
		System.out.println("endindex of s is " + endindex2);
		la22.analysis();
	}

}
