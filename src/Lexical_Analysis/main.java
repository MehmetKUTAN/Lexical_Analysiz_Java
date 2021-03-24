package Lexical_Analysis;



import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class main extends JFrame{

    public static void main(String[] args) {

    	lexical_analysis lexer = new lexical_analysis("file.txt");
        System.out.println("\t Hoþ Geldiniz \n");
        System.out.println("Lexical Analysiz");
        System.out.println("-----------------");
        while (!lexer.isExausthed()) {
            System.out.printf("%-18s --------------------------------->:  %s \n",lexer.currentLexema() , lexer.currentToken());
            lexer.kontrol_sagla();
        }

        if (lexer.isSuccessful()) {
           JOptionPane.showMessageDialog(null, "Ýsleminiz Tamamlandi Console Ekranindan Sonuclari görebilirsiniz");
        } else {
        	JOptionPane.showMessageDialog(null,"Dosya Acma Hatasi "+lexer.errorMessage());
            
        }
    }
}