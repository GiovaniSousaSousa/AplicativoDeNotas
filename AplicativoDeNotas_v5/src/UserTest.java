import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @org.junit.jupiter.api.Test
    public void testCreateNote() throws IOException {
        String fileName = "Desenvolver1";
        File directory = new File(new Notebook().getPath());
        File file = new File(directory, fileName);
        Assertions.assertTrue(file.createNewFile(), "arquivo não criado");
    }

    @org.junit.jupiter.api.Test
    void getNote() throws IOException {
        File arquivo = new File("notebooks/Desenvolver1");
        Assertions.assertTrue(arquivo.exists(),"Arquivo Não Deletado");
        }

    @Test
    void testdeleteNote() {
       File arquivo = new File("notebooks/Desenvolver1");
       arquivo.delete();
       Assertions.assertFalse(arquivo.exists(),"Arquivo Não Deletado");
    }

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

    @org.junit.jupiter.api.Test
    void listNotes() {
        String filePath = "notebooks/";
        File folder = new File(filePath);
        File[] files = folder.listFiles();
        Assertions.assertNotEquals(null,files);
    }
}