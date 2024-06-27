//(1).import package
import java.sql.*;
public class JDBCClass {
    public static void main(String[] args) throws SQLException {
        
        //(2).lode and ragister
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        //(3).create connection
        String url="jdbc:postgresql://localhost:5432/JDBCjava";
        String uname ="postgres";
        String pass="root";
        Connection con=null;
        try {
            con=DriverManager.getConnection(url,uname,pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("connection etablished");

        //(4)create a statement
        // Statement st=null;
        // try {
        //     st=con.createStatement();
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        //(5)exicute a statement
        int sid=11;
        String sname ="Mona";
        int smarks=34;
        String query="insert into student values(?,?,?)";
        PreparedStatement st=con.prepareStatement(query);
        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, smarks);
        st.execute();
        // boolean flag=st.execute(query);
        // System.out.println(flag);
        // if(flag==true)
        // {
        //     System.out.println("Unsuccessfull to exicute the query");
        // }else{
        //     System.out.println("Query exicuted susscessfully.");
        // }
        // ResultSet rs=null;
        // try {
        //     rs=st.executeQuery(query);
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        
        //process result 
        // while(rs.next())
        // {
        //     System.out.print("Roll:"+rs.getInt(1)+
        //                         " Name:"+rs.getString(2)+
        //                         " Marks:"+rs.getInt(3));
        //                         System.out.println();
        // }
        // try {
        //     System.out.println(rs.next());
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        
        // try {
        //    String name= rs.getString("sname");
        //    System.out.println("The name for the query is "+name);
        // } catch (SQLException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        //close
        try {
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
