
public class laver2 {
	
	/* save the information of next Token*/
	private String next_token = "";
	/* save the information of next Lexeme */
	private String next_lexeme = "";
	/* save the information of partial or whole token */
	private String memoryToken = "";
	/* save the information of partial or whole lexeme*/
	private String memoryLexeme = "";
	/* this is the input string that is going to be analyzed */
	private String s = "";
	/* this is the current index of the analyzed input*/
	private int sindex = 0;
	/* this is the end index of the analyzed input*/
	private int endindex = 0;
	/* TRUE if an invalid token is read - e.g. 195abcmn is an invalid token*/
	private boolean flag_invalid_token = false;
	
	laver2(){
		super();
	}
	
	laver2(String s){
		this.s = s;
		endindex = s.length();
	}
	
	/* Clear memory when one token is processed and prepare to scan next Token */
	public void clearMemory() {
		next_token = "";
		next_lexeme = "";
		memoryToken = "";
		memoryLexeme = "";
	}
	

	/*get next character*/
	public void getChar() {
		//System.out.println("call getNextToken " + memoryToken + " " + memoryLexeme);
		if (sindex >= endindex)
			return;
		char nextchar = s.charAt(sindex);
		//System.out.println("index is " + sindex + " next char is " + nextchar);
		switch (nextchar) {
			case '+' : {
						boolean flag = !(memoryToken.equals(""));
						if (flag) {
							next_token =  memoryToken;
							next_lexeme = memoryLexeme;
							//System.out.println("next token is ADD_OP next lexeme is +");
							return;
						}
						else {
							next_token = "ADD_OP";
							next_lexeme = "+";
							sindex++;
							return;
						}
						
					}
			case '*' : { 
					    boolean flag = !(memoryToken.equals(""));
						if (flag) {
							next_token =  memoryToken;
							next_lexeme = memoryLexeme;
							//System.out.println("next token is MULTI_OP next lexeme is *");
							return;
						}
						else {
							next_token = "MULTI_OP";
							next_lexeme = "*";
							sindex++;
							return;
						}	
						
					}
			case '=' : { 
					    boolean flag = !(memoryToken.equals(""));
						if (flag) {
							next_token =  memoryToken;
							next_lexeme = memoryLexeme;
							//System.out.println("next token is ASSIGN_OP next lexeme is =");
							return;
						}
						else {
							next_token = "ASSIGN_OP";
							next_lexeme = "=";
							sindex++;
							return;
						}	
						
				}
			case ';' : { 
						boolean flag = !(memoryToken.equals(""));
						
						if (flag) {
							next_token =  memoryToken;
							next_lexeme = memoryLexeme;
							//System.out.println("next token is SEMICOLON next lexeme is ;");
							return;
						}
						else {
							next_token = "SEMICOLON";
							next_lexeme = ";";
							sindex++;
							return;
						}	
						
			}
			case ' ': {
					boolean flag = !(memoryToken.equals(""));
					if (flag) {
						next_token =  memoryToken;
						next_lexeme = memoryLexeme;
						//System.out.println("next token is " + next_token + " next lexeme is " + next_lexeme);
						return;
					}
					else {
						sindex++;
						return;
					}	
					
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
				// is the memory empty
				if (memoryToken.equals("")) {
					// first number
					memoryToken = "INT_LITERAL";
					memoryLexeme = "" + nextchar;
					// if it is the end of the program, save it as next_token, next_lexeme
					if (sindex >= endindex -1 ) {
						next_token = memoryToken;
						next_lexeme = memoryLexeme;
					}
					sindex++;
					return;
				}
				else if (memoryToken.equals("INT_LITERAL")) {					
					memoryLexeme += nextchar;
					// if it is the end of the program, save it as next_token, next_lexeme
					if (sindex >= endindex -1 ) {
						next_token = memoryToken;
						next_lexeme = memoryLexeme;
					}
					sindex++;
					return;
							
				}
				else if (memoryToken.equals("IDENTIFIER")){
					// record this number
					memoryLexeme += nextchar;
					return;
				}
				else {
					flag_invalid_token = true;
					System.out.println("invalid token at index " + sindex + " " + memoryLexeme + nextchar);
					return;
				}				
			} // end of case 1, 2, 3, ..., 9
		default: {  // it is an IDENTIFIER
				// is the memory empty
				if (memoryToken.equals("")) {
					// first number									
					memoryToken = "IDENTIFIER";
					memoryLexeme = "" + nextchar;
					// if it is the end of the program, save it as next_token, next_lexeme
					if (sindex >= endindex -1 ) {
						next_token = memoryToken;
						next_lexeme = memoryLexeme;
					}
					sindex++;
					return;
				}				
				else if (memoryToken.equals("IDENTIFIER")){					
					memoryLexeme += nextchar;
					// if it is the end of the program, save it as next_token, next_lexeme
					if (sindex >= endindex -1 ) {
						next_token = memoryToken;
						next_lexeme = memoryLexeme;
					}
					sindex++;
					return;
				}
				else {
					System.out.println("invalid token at index " + sindex + " " + memoryLexeme + nextchar);
					flag_invalid_token = true;
					return;
				}						
				
			}	
		} 	
		
		
	}
	
	/* recursively scan characters until a token is recognized 
	 * or it is the end of the input 
	 * token content is saved in next_token
	 * lexeme content is saved in next_lexeme 
	 * */
	public void computeNextToken() {
		while ((!flag_invalid_token) && (sindex < endindex)) {
		//for (int index=0; index<18; index++) {
			    getChar();
				if (!next_token.equals("")) {
					// we finish here
					System.out.println("next token is " + next_token + " next lexeme is " + next_lexeme);
					//clearMemory();		
					return;
				}
			}
		}
	
	/* This is only for lexical analysis
	 * recursively scan each character until
	 * an invalid token shows up or the end of the string
	 * */
	public void analysis() {
		while ((!flag_invalid_token) && (sindex < endindex)) {
		//for (int index=0; index<18; index++) {
			    getChar();
				if (!next_token.equals("")) {
					// we finish here
					System.out.println("next token is " + next_token + " next lexeme is " + next_lexeme);
					clearMemory();		
				}
			}
		}
	
	/* get next_token */
	public String getNextToken() {
		return next_token;
	}
	
	/*get next_lexeme */
	public String getNextLexeme() {
		return next_lexeme;
	}
	
	/*if an invalid token is met*/
	public boolean IsInvalidToken() {
		return flag_invalid_token;
	}
	
	/* get current index of the string */
	public int getCurrentIndex() {
		return sindex;
	}
	
	public void setCurrentIndex(int curindex) {
		this.sindex = curindex ;
	}
	
	/* get the end index of the string*/
	public int getEndIndex() {
		return endindex;
	}
	
	/* get the input string (program, or sentence) */
	public String getInputString() {
		return s;
	}

}
