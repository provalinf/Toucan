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

%state commentaire

idf = [A-Za-z_][A-Za-z_0-9]*
typePrimitif = int|char|boolean|byte|short|long|float|double
constante = [0-9]+
commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

%%

<YYINITIAL> "tab"              	{ return symbol(CodesLexicaux.TAB); }
<YYINITIAL> "["                	{ return symbol(CodesLexicaux.CROOUV); }
<YYINITIAL> "]"                	{ return symbol(CodesLexicaux.CROFER); }
<YYINITIAL> "("                	{ return symbol(CodesLexicaux.PARENTHEOUV); }
<YYINITIAL> ")"                	{ return symbol(CodesLexicaux.PARENTHEFERM); }

<YYINITIAL> "+"                	{ return symbol(CodesLexicaux.OP); }
<YYINITIAL> "-"                	{ return symbol(CodesLexicaux.OP); }
<YYINITIAL> "*"                	{ return symbol(CodesLexicaux.OP); }
<YYINITIAL> "/"                	{ return symbol(CodesLexicaux.OP); }
<YYINITIAL> "%"                	{ return symbol(CodesLexicaux.OP); }

<YYINITIAL> "=="               	{ return symbol(CodesLexicaux.DOUBLEEGAL); }
<YYINITIAL> "="                	{ return symbol(CodesLexicaux.EGAL); }
<YYINITIAL> ";"                	{ return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL> {typePrimitif}		{ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }
<YYINITIAL> {constante}			{ return symbol(CodesLexicaux.CSTE, yytext()); }
<YYINITIAL> {commentaireSlashSlash}			{}
<YYINITIAL> {commentaireSlashEtoile}		{ yybegin(commentaire); }
<YYINITIAL> {commentaireEtoileSlash}		{ yybegin(YYINITIAL); }

{idf}			{ return symbol(CodesLexicaux.IDF, yytext()) ; }

.                       {}
\n                      {}
