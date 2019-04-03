/**
 *
 * C'est la classe pour la connexion au BDD
 * Pour ceci, nous avons utilise le logiciel WAMPSERVER64.
 */
package Base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connect {
    private static String url = "jdbc:mysql://localhost:3306/amplirt";
    private static String user = "root";
    private static String password = "abc123";
    private static Connection conn = null;
    
    public static Connection getConnect(){
       try {
           //chargement du pilote MySQL, récupération d’un objet de type Class
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connection BASE OK!");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Problem: database driver class");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Problem connexion, verifier login/mdp");
            ex.printStackTrace();
        } 
       return conn;
    }

    
}
