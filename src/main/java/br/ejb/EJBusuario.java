package br.ejb;

import br.model.usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import lombok.Data;

/**
 *
 * @author daniel
 */
@Stateless
@Data
public class EJBusuario {

    public static List<Usuario> list;
    String respota;

    public EJBusuario() {
        if (list == null) {
            list = new ArrayList<>();
        }
    }

    public void add(String nome) {
        boolean aux = false;

        for (Usuario i : list) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                i.setScore(i.getScore() + 1);
                aux = true;
                break;
            }
        }
        if (!aux) {
            list.add(new Usuario(nome, 1));

        }
    }

    public void verificar(String nome, int num1, int num2, int resultado) {
        if (num1 + num2 == resultado) {
            this.add(nome);
            respota = "RESPOTA CORRETA";
        } else {
            respota = "RESPOSTA ERRADA ";
        }

    }

    public String retResultadoSoma() {

        return respota;

    }

}
