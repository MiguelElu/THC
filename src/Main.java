public class Main {
    public static void main(String[] args) {


        String data[] = SQL.recibirUsuarios("admin","admin");
       System.out.println(data[0]);
        System.out.println(data[1]);
         SQL.buscarPaciente("%test%");

    }
}