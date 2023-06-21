import java.util.Observable;

public class ClimaTempo extends Observable {
    private String cidade;
    private String versaoAplicativo;

    public ClimaTempo(String cidade, String versaoAplicativo) {
        this.cidade = cidade;
        this.versaoAplicativo = versaoAplicativo;
    }

    public void enviarPrivisao() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return  " A temperatura para hoje é de XºC" +
                ", em " + cidade;
    }
}
