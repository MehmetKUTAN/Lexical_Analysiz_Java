package Lexical_Analysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;


public class lexical_analysis {
    private StringBuilder input = new StringBuilder();
    private Set<Character> characters = new HashSet<Character>();
    private Token token;
    private String lexema_analyze;
    private boolean kontrol = false;
    private String message_hata = "";
    

    public lexical_analysis(String file) {
        try (Stream<String> st = Files.lines(Paths.get(file))) {
            st.forEach(input::append);
        } catch (IOException ex) {
        	kontrol = true;
        	message_hata = "Dosya Bulunamadi " + file;
            return;
        }

        characters.add('\t');
        characters.add('\n');
        characters.add((char) 8);
        characters.add((char) 9);
        characters.add((char) 11);
        characters.add((char) 12);
        characters.add((char) 32);

        kontrol_sagla();
    }

    public void kontrol_sagla() {
        if (kontrol) {
            return;
        }

        if (input.length() == 0) {
        	kontrol = true;
            return;
        }

        sayma();

        if (sirasi_ile_token_bul()) {
            return;
        }

        kontrol = true;

        if (input.length() > 0) {
        	message_hata = "Bilinmeyen sembol: '" + input.charAt(0) + "'";
        }
    }

   

    private boolean sirasi_ile_token_bul() {
        for (Token tokenn : Token.values()) {
            int bul = tokenn.eslesme(input.toString());

            if (bul != -1) {
                token = tokenn;
                lexema_analyze = input.substring(0, bul);
                input.delete(0, bul);
                return true;
            }
        }

        return false;
    }
    
    private void sayma() {
        int sayac = 0;

        while (characters.contains(input.charAt(sayac))) {
        	sayac++;
        }

        if (sayac > 0) {
            input.delete(0, sayac);
        }
    }

   
   
    public String currentLexema() {
        return lexema_analyze;
    }
    
    public Token currentToken() {
        return token;
    }

    public String errorMessage() {
        return message_hata;
    }
    
    public boolean isSuccessful() {
        return message_hata.isEmpty();
    }
    public boolean isExausthed() {
        return kontrol;
    }
    
}
