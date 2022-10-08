package EnsambladoresProyecto;

import jflex.exceptions.SilentExit;

public class ExecuteJFlex {
    
    public static void main(String omega[]){
        String lexerFile = System.getProperty("user.dir") + "/src/ensambladoresproyecto/Lexer.flex",
               lexerFileColor = System.getProperty("user.dir") + "/src/ensambladoresproyecto/LexerColors.flex";
    
// generar las rutas de los archivos .flex en un array string    
        try {
        jflex.Main.generate(new String[]{lexerFile, lexerFileColor});
    } catch (SilentExit ex){
      System.out.println("Error al compilar/generar el archivo flex: " + ex);
    }
    }
}
// C:\EnsambladoresProyecto\src\ensambladoresproyecto\Lexer.flex