import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    /*Teste do método de criação de notas,
    nele é criado um arquivo e após verificado se o arquivo pode ser localizado dentro do diretório "Notebooks",
     em caso positivo, retorna True, validando o teste.*/
    @org.junit.jupiter.api.Test
    public void testCreateNote() throws IOException {
        String fileName = "Desenvolver5";
        File directory = new File(new Notebook().getPath());
        File file = new File(directory, fileName);
        Assertions.assertTrue(file.createNewFile(), "arquivo não criado");
    }

    /*Teste do método de visualização de notas,
    Nele é verificado se é possível localizar o documento referenciado, em caso positivo retorna True e valida teste.*/
    @org.junit.jupiter.api.Test
    void getNote() throws IOException {
        File arquivo = new File("notebooks/Desenvolver2");
        Assertions.assertTrue(arquivo.exists(),"Arquivo Localizado");
        }

        /*Teste do método de delete de notas,
        Nele é realizada a exclusão do arquivo referenciado e após verificado se está sendo localizado dentro do diretorio "Notebooks",
        Caso não seja localizado, retorna False e valida teste.*/
    @Test
    void testdeleteNote() {
       File arquivo = new File("notebooks/Desenvolver3");
       arquivo.delete();
       Assertions.assertFalse(arquivo.exists(),"Arquivo Não Deletado");
    }

    /*Teste do método de atualização de notas,
     Em primeiro momento é recuperada informação que consta na nota, após atualizada informação
     e por fim validado se a informação da nota anterior é igual a atual, em caso falso, valida teste.*/
    @org.junit.jupiter.api.Test
    void updateNote() throws IOException {
        String filePath = "notebooks/teste";
        String fileContent = Files.readString(Path.of(filePath));
        FileWriter fw = new FileWriter(filePath, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("teste3");
        bw.newLine();
        bw.close();
        String filePath2 = "notebooks/Desenvolver1";
        String fileContent2 = Files.readString(Path.of(filePath));
        Assertions.assertNotEquals(fileContent,fileContent2);
    }

    /*Teste de apresentação de arquivos em lista,
    Primeiramente é recuperado o nome dos arquivos que estão dentro do diretorio,
    após recuperar os arquivos eles são inseridos dentro de um array e por fim verificado se o array está nulo,
    retorna False e valida teste. */
    @org.junit.jupiter.api.Test
    void listNotes() {
        String filePath = "notebooks/";
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        Assertions.assertNotEquals(null,files);
    }
}