
public class laver1 {
	
	private String next_token = "";
	private String next_lexeme = "";
	private String s = "";
	
	laver1(){
		super();
	}
	
	laver1(String s){
		this.s = s;
	}
	
	public void clearMemory() {
		next_token = "";
		next_lexeme = "";
	}
	
	protected void OutputLexemeInMemory() {
		if (!next_lexeme.equals("")) {
			System.out.println("next token is " + next_token + " next lexeme is " + next_lexeme);
			clearMemory();					
		}
	}
	
	public void analysis(int beginindex, int endindex) {
		if (beginindex >= endindex)
			return;
		
		char nextchar = s.charAt(beginindex);
		//System.out.println("index is " + beginindex + " next char is " + nextchar);
		 
		switch (nextchar) {
			case '+' : {
					OutputLexemeInMemory();
					System.out.println("next token is ADD_OP next lexeme is +");
					clearMemory();
					analysis(beginindex + 1, endindex);
					break;
					}
			case '*' : { 
					OutputLexemeInMemory();
					System.out.println("next token is MULTI_OP next lexeme is *");
					clearMemory();
					analysis(beginindex + 1, endindex);
					break;
					}
			case '=' : { 
				OutputLexemeInMemory();
				System.out.println("next token is ASSIGN_OP next lexeme is =");
				clearMemory();
				analysis(beginindex + 1, endindex);
				break;
				}
			case ';' : { 
				OutputLexemeInMemory();
				System.out.println("next token is SEMI_COLON next lexeme is ;");
				clearMemory();
				analysis(beginindex + 1, endindex);
				break;
			}
			case ' ': {
				OutputLexemeInMemory();
				analysis(beginindex + 1, endindex);
				break;
			}
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9': {
				if (next_token.equals("")) {
					next_token = "INT_LITERAL";
					next_lexeme = "" + nextchar; 
					//System.out.println("next_lexeme is " + next_lexeme);
					analysis(beginindex + 1, endindex);
				}
				else if (next_token.equals("INT_LITERAL")) {
					next_lexeme += nextchar;
					//System.out.println("next_lexeme is " + next_lexeme);
					analysis(beginindex + 1, endindex);
				}
				else if (next_token.equals("IDENTIFIER")){
					next_lexeme += nextchar;
					//System.out.println("next_lexeme is " + next_lexeme);
					analysis(beginindex + 1, endindex);
				}
				else {
					System.out.println("invalid token at index " + beginindex + " " + next_lexeme + nextchar);
				}
				break;
			} // end of case 1, 2, 3, ..., 9
		default: {
				// all other cases, we categorize it as an identifier
				if (next_token.equals("")) {
					next_token = "IDENTIFIER";
					next_lexeme = "" + nextchar; 
					//System.out.println("next_lexeme is " + next_lexeme);
					analysis(beginindex + 1, endindex);
				}
				else if (next_token.contentEquals("INT_LITERAL")) {
					System.out.println("invalid token at index " + beginindex + " " + next_lexeme + nextchar);
					return;
				}
				else if (next_token.contentEquals("IDENTIFIER")){
					next_lexeme += nextchar;
					//System.out.println("next_lexeme is " + next_lexeme);
					analysis(beginindex + 1, endindex);
				}
				else {
					System.out.println("invalid token at index " + beginindex + " " + next_lexeme + nextchar);
				}
				break;
			}	
		} 
	} 
}
