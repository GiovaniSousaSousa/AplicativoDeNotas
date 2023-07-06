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
        Scanner keyBoardCreate = new Scanner(System.in);
        String title = keyBoardCreate.nextLine();
        System.out.println("Conteudo: ");
        String content = keyBoardCreate.nextLine();
        Note note = new Note(title, content, LocalDate.now(), LocalDateTime.now());
        String fileName = title+".txt";
        keyBoardCreate.close();
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
            buffer.write("Title: "+note.getTitle());
            buffer.newLine();
            buffer.write("dateCreated:"+note.getDateCreated());
            buffer.newLine();
            buffer.write("lastModified: "+note.getLastModified());
            buffer.newLine();
            buffer.write("content: "+note.getContent());
            buffer.newLine();
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
        Scanner keyBoardGet = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoardGet.nextLine();
        keyBoardGet.close();
        Path file = Paths.get(notebook.getPath()+title+".txt");
        try{
            // Realiza a leitura de todas as linhas do arquivo
            List<String> lines = Files.readAllLines(file);
            StringJoiner joiner = new StringJoiner(". ");
            for (String item : lines) {
                joiner.add(item);
            }
            String content = joiner.toString();
            note.setTitle(title);
            note.setContent(content);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(note.getContent());
    }
    
    @Override
    public void deleteNote(){
        Notebook notebook = new Notebook();
        Scanner keyBoardDelete = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoardDelete.nextLine();
        String filePath = notebook.getPath()+title+".txt";
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("Arquivo excluido com sucesso.");
        } else {
            System.out.println("Nao foi possivel excluir o arquivo.");
        }
        keyBoardDelete.close();
    }
    @Override
    public void updateNote(){
        Notebook notebook = new Notebook();
        Scanner keyBoardUpdate = new Scanner(System.in);
        System.out.println("Digite o titulo da nota: ");
        String title = keyBoardUpdate.nextLine();
        String file = notebook.getPath()+title+".txt";
        System.out.println("Digite o conteudo: ");
        String content = keyBoardUpdate.nextLine();
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
    
    @Override
    public void listNotes(){
        Notebook notebook = new Notebook();
        String directory = notebook.getPath();

        File folder = new File(directory);
        File[] files = folder.listFiles();
        System.out.println("*****Lista de notas*****");
        if (files != null) {
            for (File archive : files) {
                if (archive.isFile()) {
                    System.out.println(archive.getName());
                }
            }
        }
    }
}
