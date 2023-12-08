import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {


       System.out.println(iniciarsession());
       menu();


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

    public static void menu() {
      System.out.println("Porfavor tecle alguno de los comandos para ejecutar la accion: agregar usuario, agregar paciente, " +
              "agregar registro, " +
              "modificar paciente, modificar registro, desplegar pacientes, desplegar registros");
      String res = sc.nextLine();
        switch (res){
            case "agregar usuario":
               SQL.agregarUsuario();
               break;
            case "agregar paciente":
               SQL.agregarPaciente();
                break;
            case "agregar registro":
                SQL.agregarRegistro();
                break;
            case "desplegar pacientes":
                SQL.buscarPaciente();
                break;
            case "desplegar registros":
                SQL.buscarRegistro();
                break;
            case "modificar usuario":
                SQL.modificarUsuario();
                break;

        }

    }
}