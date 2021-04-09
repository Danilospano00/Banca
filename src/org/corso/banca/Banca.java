package Banca.Banca.src.org.corso.banca;

public class Banca {

    private static int prossimoNumeroContoCorrente = 1;
    private static int indiceContiCorrenti = 0;
    private ContoCorrente[] contiCorrenti;
    
    public Banca() {
        contiCorrenti = new ContoCorrente[10];
    }

    public void apriContoCorrente(String nome, String cognome, String codiceFiscale, int valoreIniziale) {
        Cliente proprietario = new Cliente(nome, cognome, codiceFiscale);
        ContoCorrente conto = new ContoCorrente("" + prossimoNumeroContoCorrente, 1000, valoreIniziale, proprietario);
        contiCorrenti[indiceContiCorrenti++] = conto;
        prossimoNumeroContoCorrente++;
    }

    public void operaPrelievo(int importo, String nContoCorrente) {
        for (int i = 0; i < contiCorrenti.length-1; i++) {
            if (contiCorrenti[i].getnContoCorrente().equals(nContoCorrente)) {
                contiCorrenti[i].prelievo(importo);
                break;
            }
        }
    }

    public void operaPrelievoCF(int importo, String codiceFiscale){
        for(int i = 0; i<contiCorrenti.length-1; i++){
            if(contiCorrenti[i].getProprietario().getCodiceFiscale().equals(codiceFiscale)){
                contiCorrenti[i].prelievo(importo);
                break;
            }
        }
    }

    public void operaVersamento(int importo, String nContoCorrente) {
        for (int i = 0; i < contiCorrenti.length-1; i++) {
            if (contiCorrenti[i].getnContoCorrente().equals(nContoCorrente)) {
                contiCorrenti[i].versamento(importo);
                break;
            }
        }
    }

    public ContoCorrente[] getContiCorrenti() {
        return contiCorrenti;
    }


}
