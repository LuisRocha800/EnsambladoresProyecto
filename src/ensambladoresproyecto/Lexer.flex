package ensambladoresproyecto;
import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%ignorecase
comentario = ";"
registro = "AX"|"BX"
%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
    return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}
    /* variables basicas de comentarios y espacios */
    TerminadorDeLinea = \r|\n|\r\n
    EntradaDeCaracter = [^\r\n]
    EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
    ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*"+ "/" ";"
    FinDeLineaComentario = "//" {EntradaDeCaracter}* {TerminadorDeLinea}?
    ContenidoComentario = ( [^*] | \*+ [^/*] )*
    ComentarioDeDocumentacion = "/**" {ContenidoComentario} "*"+ "/"

    /* Comentario */
    Comentario = {ComentarioTradicional} | {FinDeLineaComentario} | {ComentarioDeDocumentacion}

   /* Identificador */
   Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
   Digito = [0-9]
   Identificador = {Letra}({Letra}|{Digito})*
   
   /* Numero */
   Numero = 0 | [1-9][0-9]*
%%

/* Espacios en blanco y comentarios los ignorara*/
{Comentario}|{EspacioEnBlanco} { /* Ignorar */}

/* Instrucciones */
{registro} {return token(yytext(), "Registro", yyline, yycolumn);}







/* si un elemento no es agrupado se llama este metodo */
. { return token(yytext(), "Error", yyline, yycolumn); }


