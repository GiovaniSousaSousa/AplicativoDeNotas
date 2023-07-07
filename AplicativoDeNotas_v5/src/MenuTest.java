import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void menu() {
        List<String> validOptions = Arrays.asList("1", "2", "3", "4","5","6");
        Boolean validacaotest = validOptions.contains("6");
        Assertions.assertTrue(validacaotest,"Não possui opcao em lista");
    }
}