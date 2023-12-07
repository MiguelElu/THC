import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


       System.out.println(iniciarsession());


    }

    public static boolean iniciarsession(){

        System.out.println("Ingrese Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese Contraseña:");
        String pass = sc.nextLine();
       String data[]= SQL.recibirUsuarios(usuario,pass);
        if( usuario.equals(data[0] ) && pass.equals(data[1])){

            return true;
        }
        else {
            return false;
        }
    }
}