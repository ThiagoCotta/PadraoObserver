import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void deveNotificarClimaParaUsuario() {
        ClimaTempo climaTempo = new ClimaTempo("Juiz de Fora", "12.31.01");
        Usuario usuario = new Usuario(011, "Thiago");
        usuario.receberNotificacoes(climaTempo);
        climaTempo.enviarPrivisao();
        assertEquals("Caro(a) Thiago. A temperatura para hoje é de XºC, em Juiz de Fora", usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClimaParaUsuarios() {
        ClimaTempo climaTempo = new ClimaTempo("Juiz de Fora", "12.31.01");
        Usuario usuario1 = new Usuario(001, "Marcos");
        Usuario usuario2 = new Usuario(002, "Lucas");
        usuario1.receberNotificacoes(climaTempo);
        usuario2.receberNotificacoes(climaTempo);
        climaTempo.enviarPrivisao();
        assertEquals("Caro(a) Marcos. A temperatura para hoje é de XºC, em Juiz de Fora", usuario1.getUltimaNotificacao());
        assertEquals("Caro(a) Lucas. A temperatura para hoje é de XºC, em Juiz de Fora", usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarUsuario() {
        ClimaTempo climaTempo = new ClimaTempo("Belo Horizonte", "12.31.01");
        Usuario usuario = new Usuario(004, "Lucas");
        climaTempo.enviarPrivisao();
        assertEquals(null, usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunoTurmaA() {
        ClimaTempo climaTempo1 = new ClimaTempo("Belo Horizonte", "12.31.01");
        ClimaTempo climaTempo2 = new ClimaTempo("Contagem", "11.05.03");
        Usuario usuario1 = new Usuario(004, "Leticia");
        Usuario usuario2 = new Usuario(004, "Roger");
        usuario1.receberNotificacoes(climaTempo1);
        usuario2.receberNotificacoes(climaTempo2);
        climaTempo1.enviarPrivisao();
        assertEquals("Caro(a) Leticia. A temperatura para hoje é de XºC, em Belo Horizonte", usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }
}