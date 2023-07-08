import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    /*Teste do menu,
    Neste teste é verificado se o parâmetro, no caso abaixo seria o 6 ,
     está na lista que foram inseridas as opções de seleção do menu, em caso positivo retorna True e valida teste*/
    @Test
    void menu() {
        List<String> validOptions = Arrays.asList("1", "2", "3", "4","5","6");
        Boolean validacaotest = validOptions.contains("6");
        Assertions.assertTrue(validacaotest,"Não possui opcao em lista");
    }
}