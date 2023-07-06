
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Bem vindo ao aplicativo de notas!");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        User user = new User();
        Menu menu = new Menu();
        menu.menu(user);
        
        
    }
    
}
