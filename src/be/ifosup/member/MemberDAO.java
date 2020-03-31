package be.ifosup.member;

import java.sql.*;

public class MemberDAO {
    public static MemberService getMembers() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[MemberDAO] Pilote de la base de donnée chargé");
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
        MemberService members = new MemberService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[MemberDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT UseID,UseEmail,UseName FROM users ORDER BY UseName ASC;");
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                members.addMember(new Member(resultat.getString("UseID"),resultat.getString("UseName"),resultat.getString("UseEmail")));
            }
        }catch (SQLException e){
            System.out.println("[MemberDAO] Problème avec la requête");
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
        return members;
    }

    public static boolean addMember( String email, String name, String password ) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[MemberDAO] Pilote de la base de donnée chargé");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String dbUrl= "jdbc:mysql://localhost:3306/restaurants?serverTimezone=UTC";
        String dbUser= "root";
        String dbPassword= "";
        Connection connection = null;
        Statement statement = null;
        boolean resultat = false;

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[MemberDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("INSERT INTO users (UseEmail,UsePassword,UseName) VALUES (?, MD5(?), ?);");
            requete.setString(1, email);
            requete.setString(2, password);
            requete.setString(3, name);
            requete.executeUpdate();
            resultat = true;
        }catch (SQLException e){
            System.out.println("[MemberDAO] Problème avec la requête");
        }finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return resultat;
    }

    public static boolean delMember( String UseID ) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[MemberDAO] Pilote de la base de donnée chargé");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        String dbUrl= "jdbc:mysql://localhost:3306/restaurants?serverTimezone=UTC";
        String dbUser= "root";
        String dbPassword= "";
        Connection connection = null;
        Statement statement = null;
        boolean resultat = false;

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[MemberDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("DELETE FROM users WHERE UseID = ?;");
            requete.setString(1, UseID);
            requete.execute();
            resultat = true;
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("[MemberDAO] Problème avec la requête");
        }finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return resultat;
    }
}
