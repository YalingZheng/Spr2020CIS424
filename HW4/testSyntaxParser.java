
public class testSyntaxParser1 {

	public static void main(String[] args) {
		String s = "curnumber = 5 * 6";
		laver2 la2 = new laver2(s);
		//int endindex = s.length();
		syntaxparser1 sp1 = new syntaxparser1(la2);		
		sp1.S();	
		
		String s2 = "curnumber = 5 * 6;;;";
		la2 = new laver2(s2);
		//int endindex = s.length();
		sp1 = new syntaxparser1(la2);		
		sp1.S();	
	}

}
