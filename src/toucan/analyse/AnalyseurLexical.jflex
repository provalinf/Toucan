package toucan.analyse ;

import java_cup.runtime.*;
import toucan.arbre.*;

%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}


idf = [A-Za-z_][A-Za-z_0-9]*
typePrimitif = int|char|boolean|byte|short|long|float|double
constante = [0-9]+

InputCharacter = [^\r\n]
LineTerminator = \r|\n|\r\n
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*


%%

<YYINITIAL> "tab"              	{ return symbol(CodesLexicaux.TAB); }
<YYINITIAL> "["                	{ return symbol(CodesLexicaux.CROOUV); }
<YYINITIAL> "]"                	{ return symbol(CodesLexicaux.CROFER); }
<YYINITIAL> "("                	{ return symbol(CodesLexicaux.PAROUV); }
<YYINITIAL> ")"                	{ return symbol(CodesLexicaux.PARFER); }

<YYINITIAL> "+"                	{ return symbol(CodesLexicaux.OP, yytext()); }
<YYINITIAL> "-"                	{ return symbol(CodesLexicaux.OP, yytext()); }
<YYINITIAL> "*"                	{ return symbol(CodesLexicaux.OP, yytext()); }
<YYINITIAL> "/"                	{ return symbol(CodesLexicaux.OP, yytext()); }
<YYINITIAL> "%"                	{ return symbol(CodesLexicaux.OP, yytext()); }

<YYINITIAL> "=="               	{ return symbol(CodesLexicaux.DOUBLEEGAL); }
<YYINITIAL> "="                	{ return symbol(CodesLexicaux.EGAL); }
<YYINITIAL> ";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL> {typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }
<YYINITIAL> {constante}			{ return symbol(CodesLexicaux.CSTE, yytext()); }

<YYINITIAL> {idf}			{ return symbol(CodesLexicaux.IDF, yytext()) ; }
<YYINITIAL> {Comment}                   { /*Ignore */ }
.                       {}
\n|\r                   {}
