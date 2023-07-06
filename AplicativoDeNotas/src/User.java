import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User extends Note implements NoteService{
   
    @Override
    public void createNote(){
        System.out.println("Titulo: ");
        Scanner keyBoard = new Scanner(System.in);
        String title = keyBoard.nextLine();
        System.out.println("Conteudo: ");
        String content = keyBoard.nextLine();
        Note note = new Note(title, content, LocalDate.now(), LocalDateTime.now());
        String fileName = title+".txt";
        keyBoard.close();
        try {
            File directory = new File(new Notebook().getPath());
            File file = new File(directory, fileName);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("Nota com este titulo ja existe.");
            }
            FileWriter writer = new FileWriter(file);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(note.toString());
            buffer.close();
        }
        catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void getNote(){
        Notebook notebook = new Notebook();
        Note note = new Note();
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoard.nextLine();
        Path file = Paths.get(notebook.getPath()+title+".txt");
        try{
            // Realiza a leitura de todas as linhas do arquivo
            List<String> lines = Files.readAllLines(file);
            StringJoiner joiner = new StringJoiner(", ");
            for (String item : lines) {
                joiner.add(item);
            }
            String content = joiner.toString();
            note.setTitle(title);
            note.setContent(content);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(note.toString());
    }
    
    @Override
    public void deleteNote(){
        Notebook notebook = new Notebook();
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoard.nextLine();
        String filePath = notebook.getPath()+title;
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Arquivo excluído com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o arquivo.");
        }
        keyBoard.close();
    }
    @Override
    public void updateNote(){
        Notebook notebook = new Notebook();
        Scanner keyBoard = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoard.nextLine();
        String file = notebook.getPath()+title;
        System.out.println("Digite o conteudo: ");
        String content = keyBoard.nextLine();
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.newLine();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
