package ensambladoresproyecto;
import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColors
%type TextColor
%char 
registro = "AX"|"BX"
%{
    private TextColor textColor(long start, int size, Color color){
     return new TextColor((int)start, size, color);
    }
%}
    /* variables basicas de comentarios y espacios */
    TerminadorDeLinea = \r|\n|\r\n
    EntradaDeCaracter = [^\r\n]
    EspacioEnBlanco = {TerminadorDeLinea} | [ \t\f]
    ComentarioTradicional = "/*" [^*] ~"*/" | "/*" "*" "/" ";"
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

/* Espacios en blanco los ignorara (no los coloreara), comentarios los pintara de color verde*/
{Comentario} { return textColor(yychar, yylength(), new Color(0, 128, 0)); }
{EspacioEnBlanco} { /* Ignorar */}

/* Coloreara instrucciones de color azul*/
/* Instrucciones */
{registro} {return textColor(yychar, yylength(), new Color(65, 165, 238));}

/* si un elemento no es agrupado se llama este metodo*/
. { /* Ignorar */ }


