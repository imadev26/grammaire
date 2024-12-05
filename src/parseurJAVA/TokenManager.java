package parseurJAVA;

public class TokenManager {
	private String entree;
    private int iCourant; 

    public TokenManager(String ch) {
        this.entree = ch;
        this.iCourant = 0;
    }

    char suivant() {
        if (iCourant < entree.length())
            return entree.charAt(iCourant++);
        return '#'; 
    }
}
