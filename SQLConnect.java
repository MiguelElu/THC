public class SQLConnect {
    private static String url = "jdbc:mysql://localhost:3306/thc";
    private static  String username = "test";
    private static  String password = "test";

    public static Connection conectar() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection(url, username, password);
            if (conn != null) {

            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return conn;
    }

    public String[] recibirUsuarios (String user, String pass){
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String data[] = new String[2];
        try {
            cn = connectSQL.conectar();
            st = cn.createStatement();
            String sql = " Select * from thc.users where usuario = ?";
            PreparedStatement preparedStmt = cn.prepareStatement(sql);
            preparedStmt.setString(1, user);
            rs = preparedStmt.executeQuery();

            if (rs.next() == true) {
                do {
                    data[1] = rs.getString(1);
                    data[2] = rs.getString(2);
                } while (rs.next())

                return data;
            }
        }catch(SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            if (rs != null);{
                rs.close();
            }
            if (st != null);{
                st.close();
            }
            if (cn != null);{
                cn.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
