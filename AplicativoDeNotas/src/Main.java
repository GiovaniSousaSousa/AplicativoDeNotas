
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao aplicativo de notas!");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        User user = new User();
        System.out.println("*-*-*-Menu-*-*-*");
        System.out.println("1 - Create note");
        System.out.println("2 - Update note");
        System.out.println("3 - Delete note");
        System.out.println("Digite o numero de uma das opcoes");
        Scanner keyBoard = new Scanner(System.in);
        String option = keyBoard.nextLine();
        if ("1".equals(option)){
            user.createNote();
        }
        if ("2".equals(option)){
            user.getNote();
        }
        
        
    }
    
}
