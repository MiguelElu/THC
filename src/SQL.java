import java.sql.*;

public class SQL {
    private static String url = "jdbc:mysql://localhost:3306/thc";
    private static String username = "test";
    private static String password = "test";

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
    public static void buscarPaciente(String nombre){

        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String data[][] = new String[7][100];
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
        for (int i2=0; i2 <Integer.parseInt(data[0][6]); i2++){
            System.out.println();
            for (int j=0; j<6; j++){
                System.out.print(data[i2][j]+"  ");
            }
        }


    }

}
