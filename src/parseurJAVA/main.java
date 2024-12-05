package parseurJAVA;

public class main {

	public static void main(String[] args) {
		String[] testChains = {"cdcbc", "bcdcbdcbc", "cbdcbdcbc", "ccdcbdcdbbcr", "cdcbbb", "cdcb", ""};

        for (String ch : testChains) {
            TokenManager tm = new TokenManager(ch);
            ParseurG7 parseur = new ParseurG7(tm);

            try {
                parseur.parse();
                System.out.println(ch + " est valide");
            } catch (RuntimeException exp) {
                System.out.println(ch + " n'est pas valide");
                System.out.println(exp.getMessage());
            }
        }
	}

}
