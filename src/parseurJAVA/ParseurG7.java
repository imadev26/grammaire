package parseurJAVA;

public class ParseurG7 {
	    private TokenManager tm;
	    private char tc; 

	    private void avancer() {
	        tc = tm.suivant();
	    }

	    private void consommer(char attendu) {
	        if (tc == attendu)
	            avancer();
	        else
	            throw new RuntimeException("Attendu: " + attendu + ", trouvé: " + tc);
	    }

	    public ParseurG7(TokenManager tm) {
	        this.tm = tm;
	        avancer(); 
	    }

	    private void S() {
	        if (tc == 'b') {
	            // S → bSb
	            consommer('b');
	            S();
	            consommer('b');
	        } else if (tc == 'c') {
	            // S → cAc
	            consommer('c');
	            A();
	            consommer('c');
	        } else {
	            throw new RuntimeException(tc + " token non valide pour S");
	        }
	    }

	    private void A() {
	        if (tc == 'b') {
	            // A → bAA
	            consommer('b');
	            A();
	            A();
	        } else if (tc == 'c') {
	            // A → cASAb
	            consommer('c');
	            A();
	            S();
	            A();
	            consommer('b');
	        } else if (tc == 'd') {
	            // A → dcb
	            consommer('d');
	            consommer('c');
	            consommer('b');
	        } else {
	            throw new RuntimeException(tc + " token non valide pour A");
	        }
	    }

	    public void parse() {
	        S();
	        if (tc != '#') {
	            throw new RuntimeException(tc + ": fin de chaîne attendue");
	        }
	    }
}
