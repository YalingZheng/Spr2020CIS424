/* Reverse Polish Notation Calculator */
%{
#include <stdio.h>
#include <math.h>
int yylex (void);
void yyerror (char const *);
%}

%define api.value.type {double}
%token NUM
%left '-' '+'
%left '*' '/'
%precedence NEG /* negation--unary minus*/
%right '^'      /* exponentiation */

%% /* Grammar rules and actions follow. */
input:
  %empty
| input line
;

line:
  '\n'
| exp '\n' { printf ("%.10g\n", $1); }
;

exp:
  NUM
| exp '+' exp {$$ = $1 + $3; }
| exp '-' exp {$$ = $1 - $3; }
| exp '*' exp {$$ = $1 * $3; }
| exp '/' exp {$$ = $1 / $3; }
| exp '^' exp {$$ = pow ($1, $3); } /* Exponentiation */
| '-' exp  %prec NEG   {$$ = -$2;}            /* unary minus */
| '(' exp ')' { $$ = $2; }
;
%%

/* The lexical analyzer returns a double floating
number on the stack and the token NUM, or the numeric code of
the character read if not a number. If skips all blanks and tabs,
and returns 0 for end-of-input. */

#include <ctype.h>
#include <stdio.h>


int
yylex(void)
{
        int c = getchar();
        /* Skip white space. */
        while (c == ' ' || c == '\t'){
          c = getchar();
        }
        /* Process numbers. */
        if (c == '.' || isdigit(c)){
                ungetc(c, stdin);
                scanf("%lf",&yylval);
                return NUM;
        }
       /* Return end-of-input.*/
        else if (c == EOF) {
               return 0;
        }
       /* Return a single char. */
       else {
         return c;
        }
}

void
yyerror (char const *s)
{
        fprintf(stderr, "%s\n", s);
}

int
main (void)
{
        return yyparse();
}
