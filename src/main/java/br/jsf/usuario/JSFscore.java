package br.jsf.usuario;

import br.ejb.EJBscore;
import br.ejb.EJBusuario;
import br.model.usuario.Usuario;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import lombok.Data;

@Named(value = "jSFscore")
@SessionScoped
@Data
public class JSFscore implements Serializable {

    Random random = new Random();

    @EJB
    private EJBusuario eJBusuario;

    @EJB
    private EJBscore ejbscore;

    private String nome = "";
    private int num1 = 0;
    private int num2 = 0;
    private int resposta;
    private String resultado = "";

    public JSFscore() {
    }

    @PostConstruct
    public void iniciarJogo() {
        num1 = ejbscore.gerarNumeroAleatorio();
        num2 = ejbscore.gerarNumeroAleatorio();

    }

    public void verificarSoma() {

        eJBusuario.verificar(nome, num1, num2, resposta);

        limpar();
        iniciarJogo();

    }

    public void limpar() {
        nome = "";
        resposta = 0;
    }

    public String resultado() {

        return eJBusuario.retResultadoSoma();

    }

    public List<Usuario> getAll1() {
        return ejbscore.getAll();
    }

}
