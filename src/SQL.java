import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class SQL {
    private static String url = "jdbc:mysql://localhost:3306/thc";
    private static String username = "test";
    private static String password = "test";
    static Scanner sc = new Scanner(System.in);
    public static Connection conectar() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            if (conn != null) {

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return conn;
    }

    public static String[] recibirUsuarios(String user, String pass) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String data[] = new String[2];
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " Select * from thc.users where Name = ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, user);
            rs = preparedStmt.executeQuery();

            if (rs.next() == true) {
                do {
                    data[0] = rs.getString(1);
                    data[1] = rs.getString(2);
                } while (rs.next());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) ;
                {
                    rs.close();
                }
                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return data;
    }
    public static void buscarPaciente(){

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String data[][] = new String[7][100];

        System.out.println("Nombre a buscar:");
        String nombre = "%"+sc.nextLine()+"%";
        int i = 0;
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " Select * from thc.pacientes where nombre like ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, nombre);
            rs = preparedStmt.executeQuery();

            if (rs.next() == true) {
                do {
                    data[i][0] = String.valueOf(rs.getInt(1));
                    data[i][1] = rs.getString(2);
                    data[i][2] = rs.getString(3);
                    data[i][3] = rs.getString(4);
                    data[i][4] = rs.getString(5);
                    data[i][5] = String.valueOf(rs.getFloat(6));
                    i++;
                } while (rs.next());
                    data[0][6] = String.valueOf(i);
                for (int i2=0; i2 <Integer.parseInt(data[0][6]); i2++){
                    System.out.println();
                    for (int j=0; j<6; j++){
                        System.out.print(data[i2][j]+"  ");
                    }
                }


            } else { System.out.print("Sin Resultados");}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) ;
                {
                    rs.close();
                }
                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        System.out.println();
    }

    public static void agregarUsuario() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese Contraseña:");
        String pass = sc.nextLine();
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " insert into thc.users (Name,Pass)" +
                    " values (?,?)";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, usuario);
            preparedStmt.setString(2, pass);
          preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void agregarPaciente() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese raza:");
        String raza = sc.nextLine();
        System.out.println("Ingrese Dueño:");
        String dueño = sc.nextLine();
        System.out.println("Ingrese Fecha de nacimiento:");
        String fecha = sc.nextLine();
        System.out.println("Ingrese Peso:");
        Float peso =Float.valueOf(sc.nextLine());
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " insert into thc.pacientes ( nombre, raza, dueño, fdenacimiento, peso)" +
                    " values (?,?,?,?,?)";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, raza);
            preparedStmt.setString(3, dueño);
            preparedStmt.setString(4, fecha);
            preparedStmt.setFloat(5, peso);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void agregarRegistro() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese ID del paciente:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese su nota:");
        String nota = sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();

        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " insert into thc.registros ( idpaciente,  nota, fecha)" +
                    " values (?,?,?)";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setInt(1, id);
            preparedStmt.setString(2, nota);
            preparedStmt.setString(3, dtf.format(now));

            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void buscarRegistro(){

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String data[][] = new String[4][100];

        System.out.println("Id a buscar:");
        int id = Integer.parseInt(sc.nextLine());
        int i = 0;
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " Select * from thc.registros where idpaciente = ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setInt(1, id);
            rs = preparedStmt.executeQuery();

            if (rs.next() == true) {
                do {
                    data[i][0] = String.valueOf(rs.getInt(1));
                    data[i][1] = String.valueOf(rs.getInt(2));
                    data[i][2] = rs.getString(3);
                    data[i][3] = rs.getString(4);

                    i++;
                } while (rs.next());
                data[0][4] = String.valueOf(i);

                for (int i2=0; i2 <Integer.parseInt(data[0][4]); i2++){
                    System.out.println();
                    for (int j=0; j<4; j++){
                        System.out.print(data[i2][j]+"  ");
                    }
                }

            } else {System.out.print(  "Sin Registros");}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) ;
                {
                    rs.close();
                }
                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        System.out.println();

    }

    public static void modificarUsuario() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese Usuario:");
        String usuario = sc.nextLine();
        System.out.println("Ingrese Contraseña nueva:");
        String pass = sc.nextLine();
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " update thc.users " +
                    "SET Pass = ?" +
                    " where Name like ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, pass);
            preparedStmt.setString(2, usuario);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void modificarPaciente() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese Id del paciente a modificar:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese raza:");
        String raza = sc.nextLine();
        System.out.println("Ingrese Dueño:");
        String dueño = sc.nextLine();
        System.out.println("Ingrese Fecha de nacimiento:");
        String fecha = sc.nextLine();
        System.out.println("Ingrese Peso:");
        Float peso =Float.valueOf(sc.nextLine());
        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " update thc.pacientes " +
                    "SET nombre = ?,raza = ?, dueño = ?,fdenacimiento = ?, peso = ?" +
                    " where id = ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, nombre);
            preparedStmt.setString(2, raza);
            preparedStmt.setString(3, dueño);
            preparedStmt.setString(4, fecha);
            preparedStmt.setFloat(5, peso);
            preparedStmt.setInt(6, id);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public static void modificarRegistro() {
        Connection cn = null;
        Statement st = null;

        System.out.println("Ingrese Id del registro a modificar");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese nueva Nota:");
        String nota = sc.nextLine();

        try {
            cn = SQL.conectar();
            st = cn.createStatement();
            String sql = " update thc.registros " +
                    "SET nota = ?" +
                    " where idnota = ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, nota);
            preparedStmt.setInt(2, id);
            preparedStmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (st != null) ;
                {
                    st.close();
                }
                if (cn != null) ;
                {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

}
