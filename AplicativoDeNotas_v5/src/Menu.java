
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu extends User {
        
    public void menu(User user){
        List<String> validOptions = Arrays.asList("1", "2", "3", "4","5","6");
        System.out.println("       Menu");
        System.out.println("1 - Criar nota");
        System.out.println("2 - Atualizar nota");
        System.out.println("3 - Deletar nota");
        System.out.println("4 - Mostrar nota");
        System.out.println("5 - Listar notas");
        System.out.println("6 - Encerrar programa");
        System.out.println("Digite o numero de uma das opcoes");
        Scanner keyBoardMenu = new Scanner(System.in);
        String option = keyBoardMenu.nextLine();
        while (!validOptions.contains(option)){
            System.out.println("Digite uma opcao valida!");
            option = keyBoardMenu.nextLine();
            keyBoardMenu.close();
        }
        switch (option){
            case "1" -> {
                user.createNote();
            }
            case "2" -> {
                user.updateNote();
            }
            case "3" -> {
                user.deleteNote();
            }
            case "4" -> {
                user.getNote();
            }
            case "5" -> {
                user.listNotes();
            }
            case "6" -> System.out.println("Programa encerrado!");
            default -> System.out.println("Programa encerrado!");
        }
    }
}
