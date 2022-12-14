package ensambladoresproyecto;
import compilerTools.TextColor;
import java.awt.Color;

%%
%class LexerColoresPalabras
%type TextColor
%char 
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
simbolodiez = "include"

stack_segment = ".stack"|".stack segment"|"stack segment"
data_segment = ".data"|".data segment"|"data segment"
code_segment = ".code"|".code segment"|"code segment"
model = ".model small"
ends = "ENDS"
byte_ptr = "byte ptr"
word_ptr = "word ptr"

delimitador = "$"
interrogacion = "?"
mas = "+"
menos = "-"

numero_decimal = ("(-"{Digito}+")")|{Digito}+
numero_hexadecimal = [0-9a-fA-F]+H
numero_binario = [0-1]+B

espacio=[ \t\r\n]+
espaciodos = " "
comentario = ";"
coma = ","

db = "db"|"DB"
dw = "dw"|"DW"
dup = "dup"

dupdec = ({dup} {corchete_abre} {numero_decimal} {corchete_cierra})
dupbin = ({dup} {corchete_abre} {numero_binario} {corchete_cierra})
duphex = ({dup} {corchete_abre} {numero_hexadecimal} {corchete_cierra})
dupsin = ({dup} {corchete_abre} {mensaje} {corchete_cierra})
dupdec_esp = ({dup} {espaciodos} {corchete_abre} {numero_decimal} {corchete_cierra})
dupbin_esp = ({dup} {espaciodos} {corchete_abre} {numero_binario} {corchete_cierra})
duphex_esp = ({dup} {espaciodos} {corchete_abre} {numero_hexadecimal} {corchete_cierra})
dupsin_esp = ({dup} {espaciodos} {corchete_abre} {mensaje} {corchete_cierra})

mensaje = ({comillas} {comillasdos})
           

dospuntos = ":"

/*eti = ({Identificador} {dospuntos})*/

corchete_abre = "("
corchete_cierra = ")"

parentesis_abre = "["
parentesis_cierra = "]"

parentesis = ({parentesis_abre} {parentesis_cierra})

parentesis_con_registros = ({parentesis_abre} {registro} {parentesis_cierra})
parentesis_con_registros_y_digitos = ({parentesis_abre} {registro} {mas} {numero_decimal} {parentesis_cierra})
parentesis_con_identificador_y_registro = ({parentesis_abre} {Identificador} {mas} {registro} {parentesis_cierra})
parentesis_con_identificador_y_registro2 = ({parentesis_abre} {Identificador} {espacio} {mas} {espacio} {registro} {parentesis_cierra})
parentesis_con_registros_digitos = ({parentesis_abre} {registro} {mas} {registro} {mas} {numero_decimal} {parentesis_cierra})
parentesis_con_registros_digitos2 = ({parentesis_abre} {registro} {espaciodos} {mas} {espaciodos} {registro} {espaciodos} {mas} {espaciodos} {numero_decimal} {parentesis_cierra})

delim = ( {comillassimples} {delimitador} {comillassimples} )

%{
    private TextColor textColor(long start, int size, Color color){
     return new TextColor((int)start, size, color);
    }
%}

   /* Identificador */
   Letra = [A-Za-z????_????????????????????????]
   Digito = [0-9]+
   Identificador = {Letra}({Letra}|{Digito})*
   
   /* Numero */
   Numero = 0 | [1-9][0-9]*
%%

/* Espacios en blanco */
{espacio} { /* Ignorar */}

{coma} {/* Ignorar */ }

/* Instrucciones */
{registro} {return textColor(yychar, yylength(), new Color(237, 87, 98));}
{instruccion} { return textColor(yychar, yylength(), new Color(255, 196, 72)); }
{simbolouno} { return textColor(yychar, yylength(), new Color(40, 253, 35));}
{simbolodos} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simbolotres} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simbolocuatro} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simbolocinco} { return textColor(yychar, yylength(), new Color(40, 253, 35));}
{simboloseis} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simbolosiete} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simboloocho} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{simbolonueve} { return textColor(yychar, yylength(), new Color(40, 253, 35));}
{interrogacion} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }
{byte_ptr} {return textColor(yychar, yylength(), new Color(40, 253, 35));}
{word_ptr} {return textColor(yychar, yylength(), new Color(40, 253, 35));}

{stack_segment} { return textColor(yychar, yylength(), new Color(195, 17, 75)); }
{data_segment} { return textColor(yychar, yylength(), new Color(195, 17, 75)); }
{code_segment} { return textColor(yychar, yylength(), new Color(195, 17, 75)); }

{numero_decimal} { return textColor(yychar, yylength(), new Color(1, 178, 255)); } 
{numero_hexadecimal} { return textColor(yychar, yylength(), new Color(1, 178, 255)); } 
{numero_binario} { return textColor(yychar, yylength(), new Color(1, 178, 255)); } 

";".* { return textColor(yychar, yylength(), new Color(4, 133, 0)); }

{simbolodiez} { return textColor(yychar, yylength(), new Color(40, 253, 35)); }

/*{Identificador} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }*/

{db} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }
{dw} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }
{dup} { return textColor(yychar, yylength(), new Color(255, 255, 255)); }



/* si un elemento no es agrupado se llama este metodo*/
. { /* Ignorar */ }


