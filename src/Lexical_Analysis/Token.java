package Lexical_Analysis;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {
	
	STRING ("\"[^\"]+\""),
	INTEGER ("\\d"), 
	  
    TK_MINUS ("-"), 
    TK_PLUS ("\\+"), 
    TK_MUL ("\\*"), 
    TK_DIV ("/"), 
    TK_NOT ("~"), 
    TK_AND ("&"),  
    TK_OR ("\\|"),  
    TK_LESS ("<"),
    TK_LEG ("<="),
    TK_GT (">"),
    TK_GEQ (">="), 
    TK_EQ ("=="),
    TK_ASSIGN ("="),
    TK_OPEN ("\\("),
    TK_CLOSE ("\\)"), 
    TK_SEMI (";"), 
    TK_COMMA (","), 
    TK_KEY_DEFINE ("define"), 
    TK_KEY_AS ("as"),
    TK_KEY_IS ("is"),
    TK_KEY_IF ("if"), 
    TK_KEY_THEN ("then"), 
    TK_KEY_ELSE ("else"), 
    TK_KEY_ENDIF ("endif"),
    OPEN_BRACKET ("\\{"),
    CLOSE_BRACKET ("\\}"),
    DIFFERENT ("<>"),
   
    IDENTIFIER ("\\w+");
   
    private final Pattern pattern;

    Token(String derle) {
        pattern = Pattern.compile("^" + derle);
    }

    int eslesme(String string) {
        Matcher eslesme = pattern.matcher(string);

        if (eslesme.find()) {
            return eslesme.end();
        }
        return -1;
    }
}