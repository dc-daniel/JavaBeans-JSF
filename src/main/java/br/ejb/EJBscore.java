package br.ejb;

import br.model.usuario.Usuario;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.ejb.Stateful;
import lombok.Data;

/**
 *
 * @author daniel
 */
@Stateful
@Data
public class EJBscore {

    private Random random = new Random();

    public EJBscore() {
    }

    public int gerarNumeroAleatorio() {
        return new Random().nextInt(10);
    }

    public List<Usuario> getAll() {
       return EJBusuario.list
                .stream()
                .sorted(Comparator.comparing(Usuario::getScore).reversed())
                .collect(Collectors.toList());

    }

}
