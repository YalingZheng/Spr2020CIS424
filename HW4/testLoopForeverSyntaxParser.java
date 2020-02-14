
public class testLoopForeverSyntaxParser {

	public static void main(String[] args) {
		String s = "curnumber = 5 * 6";
		laver2 la2 = new laver2(s);
		//int endindex = s.length();
		LoopForeverSyntaxParser sp1 = new LoopForeverSyntaxParser(la2);		
		sp1.S();	
		

	}

}
