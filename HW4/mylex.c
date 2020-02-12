/*** Definition section ***/

%%
   /*** Rules section ***/
   /* [0-9]+ matches a string of one or more digits */
[0-9]+ {
        /* yytext is a string containing the matched texts. */
        printf("Saw an integer: %s\n", yytext);
}
.|\n {  /* Ignore all other characters. */ }

%%
/*** C Code section ***/

int yywrap(){}

int main(void)
{
        /* Call the lexer, then quit. */
        yylex();
        return 0;
}