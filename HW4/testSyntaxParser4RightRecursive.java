
public class testSyntaxParser4RightRecursive {

	public static void main(String[] args) {
		String s = " 5 * 6; 3*5;";
		laver2 la2 = new laver2(s);
		//int endindex = s.length();
		SyntaxParser4RightRecursive sp1 = new SyntaxParser4RightRecursive(la2);		
		sp1.S();	
		

	}

}
