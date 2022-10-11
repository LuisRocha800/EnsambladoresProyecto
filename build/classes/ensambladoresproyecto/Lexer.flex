package ensambladoresproyecto;
import compilerTools.Token;

%%
%class Lexer
%type Token
%line
%column
%ignorecase
comentario = ";"
registro = "AX"|"BX"|"CX"|"DX"|"AH"|"AL"|"BL"|"BH"|"CH"|"CL"|"DH"|"DL"|"DI"|"SI"|"BP"|"SP"|"DS"|"ES"|"SS"|"CS"
instruccion = "STD"|"AAD"|"CLD"|"CWD"|"IRET"|"MOVSW"|"DIV"|"IMUL"|"POP"|"IDIV"|"SHL"|"XCHG"|"ADD"|"LDS"|"JNS"|"JS"|"LOOPNE"|"JAE"|"JCXZ"|"JL"|"ENDS"
simbolouno = "AAA"|"CLC"|"CMPSW"|"INTO"|"MOVSB"|"PUSHA"|"DEC"|"IDIV"|"INT"|"NOT"|"ADC"|"CMP"|"LES"|"RCL"|"JA"|"JC"|"JGE"|"JNA"|"JNC"|"JNL"
simbolodos = "PUSHF"|"STI"|"AAM"|"CLI"|"DAA"|"LAHF"|"MUL"|"INC"|"NEG"|"PUSH"|"MOV"|"ROR"|"SUB"|"XOR"|"JNAE"|"JNE"|"JNLE"|"JNZ"|"JZ"|"LOOPNZ"
simbolotres = "NOP"|"RET"|"STOSB"|"AAS"|"CMC"|"DAS"|"DEC"|"IDIV"|"DIV"|"IMUL"|"AND"|"LEA"|"OR"|"SAR"|"JB"|"JE"|"JLE"|"JNB"|"JNG"|"JNO"
simbolocuatro = "LODSB"|"POPA"|"SCASW"|"STOSW"|"CBW"|"CMPSB"|"MUL"|"INC"|"INT"|"NOT"|"TEST"|"ADC"|"CMP"|"LES"|"JO"|"LOOP"|"JBE"|"JG"|"JMP"|"JNBE"
simbolocinco = "HLT"|"LODSW"|"POPF"|"STC"|"XLATB"|"AAA"|"POP"|"IDIV"|"NEG"|"PUSH"|"RCL"|"SHL"|"XCHG"|"ADD"|"JNGE"|"JNP"|"JP"|"LOOPE"|"JA"|"JC"
simboloseis = "CLC"|"CMPSW"|"INTO"|"STI"|"AAM"|"CLI"|"DEC"|"DIV"|"MUL"|"IDIV"|"LDS"|"MOV"|"SAR"|"ROR"|"JNS"|"JS"|"JGE"|"JNA"|"LOOPNE"|"JAE"
simbolosiete = "MOVSB"|"PUSHA"|"STD"|"DAA"|"LAHF"|"NOP"|"IMUL"|"INC"|"INT"|"POP"|"ROR"|"SUB"|"TEST"|"LEA"|"JNAE"|"JNE"|"JNC"|"JNL"|"JZ"|"LOOPNZ"
simboloocho = "AAD"|"CLD"|"CWD"|"RET"|"STOSB"|"AAS"|"NEG"|"NOT"|"IDIV"|"PUSH"|"XOR"|"AND"|"RCL"|"ADC"|"JB"|"JE"|"JCXZ"|"JL"|"JLE"|"JNB"
simbolonueve = "IRET"|"MOVSW"|"PUSHF"|"CMC"|"DAS"|"LODSB"|"DEC"|"IMUL"|"NEG"|"NOT"|"LEA"|"OR"|"CMP"|"XCHG"|"JO"|"LOOP"|"JNLE"|"JNZ"|"JNG"|"JNO"
simbolodiez = "include"|"@data"

stack_segment = ".stack"|".stack segment"|"stack segment"
data_segment = ".data"|".data segment"|"data segment"
code_segment = ".code"|".code segment"|"code segment"

delimitador = "$"

numero_decimal = ("(-"{Digito}+")")|{Digito}+
numero_hexadecimal = [0-9a-fA-F]+H
numero_binario = [0-1]+B

espacio=[ \t\r\n]+
comentario = ";"
coma = ","

db = "db"|"DB"
dw = "dw"|"DW"
dup = "dup"

comillas = \'.*|\".*
comillasdos = \'|\"

dupuno = ({dup} {corchete_abre} .* {corchete_cierra})

mensajeuno = ({comillas} {comillasdos})


corchete_abre = "("
corchete_cierra = ")"

%{
    private Token token(String lexeme, String lexicalComp, int line, int column){
    return new Token(lexeme, lexicalComp, line+1, column+1);
    }
%}

   /* Identificador */
   Letra = [A-Za-zÑñ_ÁÉÍÓÚáéíóúÜü]
   Digito = [0-9]+
   Identificador = {Letra}({Letra}|{Digito})*
   
   /* Numero */
   Numero = 0 | [1-9][0-9]*
%%

/* Espacios en blanco */
{espacio} { /* Ignorar */}

{coma} {/* Ignorar */ }

/* Instrucciones */
{registro} {return token(yytext(), "Registro", yyline, yycolumn);}
{instruccion} { return token(yytext(), "Pseudoinstruccion", yyline, yycolumn); }
{simbolouno} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolodos} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolotres} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolocuatro} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolocinco} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simboloseis} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolosiete} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simboloocho} { return token(yytext(), "Simbolo", yyline, yycolumn); }
{simbolonueve} { return token(yytext(), "Simbolo", yyline, yycolumn); }

{stack_segment} { return token(yytext(), "Pseudoinstruccion", yyline, yycolumn); }
{data_segment} { return token(yytext(), "Pseudoinstruccion", yyline, yycolumn); }
{code_segment} { return token(yytext(), "Pseudoinstruccion", yyline, yycolumn); }

{numero_decimal} { return token(yytext(), "Numero Decimal", yyline, yycolumn); } 
{numero_hexadecimal} { return token(yytext(), "Numero Hexadecimal", yyline, yycolumn); } 
{numero_binario} { return token(yytext(), "Numero Binario", yyline, yycolumn); } 

{corchete_abre} {/* Ignorar */ }
{corchete_cierra} { /* Ignorar */}

/* ignora los comentarios*/
";".* { /* Ignorar */ }

{delimitador} {return token(yytext(), "Simbolo", yyline, yycolumn);}

{simbolodiez} { return token(yytext(), "Simbolo", yyline, yycolumn); }

{db} { return token(yytext(), "DByte", yyline, yycolumn); }
{dw} { return token(yytext(), "DWord", yyline, yycolumn); }


{mensajeuno} { return token(yytext(), "Variable", yyline, yycolumn); }

{dupuno} { return token(yytext(), "Pseudoinstruccion", yyline, yycolumn); }

/* si un elemento no es agrupado se llama este metodo */
. { return token(yytext(), "Error", yyline, yycolumn); }


