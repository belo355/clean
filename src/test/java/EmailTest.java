
import dominio.aluno.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailTest {

    @Test
    void naoDeveriaCriarEmailsComEnderecoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email("null"));
        assertThrows(IllegalArgumentException.class, () -> new Email("emailInvalido"));
    }

    @Test
    void criarEmailComSucesso() {
        //todo: pendente finalizar
    }

}
