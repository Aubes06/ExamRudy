package be.ifosup.login;

import java.sql.*;

public class LoginDAO {
    public static boolean valid(String email, String password) throws SQLException {
        boolean action = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String dbUrl= "jdbc:mysql://localhost:3306/restaurants?serverTimezone=UTC";
        String dbUser= "root";
        String dbPassword= "";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultat = null;
        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("Connexion OK");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT UseID,UseName,UseEmail FROM users WHERE UseEmail= ? and UsePassword = MD5(?)");
            requete.setString(1,email);
            requete.setString(2,password);
            resultat =requete.executeQuery();
            if (resultat.next()){
                action=true;
            }
        }catch (SQLException e){
            System.out.println("Problème avec la requête");
        }finally {
            if (resultat != null){
                resultat.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
        }
        return action;
    }
}
