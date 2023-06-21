import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private int id;
    private String nome;
    private String ultimaNotificacao;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void receberNotificacoes(ClimaTempo climaTempo) {
        climaTempo.addObserver(this);
    }

    public void update(Observable turma, Object arg1) {
        this.ultimaNotificacao = "Caro(a) " + this.nome +"."+ turma.toString();
    }
}
