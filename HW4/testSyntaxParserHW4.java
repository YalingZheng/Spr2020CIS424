public class testSyntaxParserHW4 {

	public static void main(String[] args) {
		String s = "    (5+6)*     3";
		laverHW4 la4 = new laverHW4(s);
		//int endindex = s.length();
		SyntaxParserHW4 sp1 = new SyntaxParserHW4(la4);		
		sp1.EXPR();	
		

	}

}
