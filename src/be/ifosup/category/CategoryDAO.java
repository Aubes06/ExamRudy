package be.ifosup.category;

import java.sql.*;

public class CategoryDAO {

    public static CategoryService getCategories() throws SQLException {
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
        CategoryService categories = new CategoryService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("Connexion OK");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT CatID,CatLabel,COUNT(DisID) AS NbPlat FROM categorys LEFT OUTER JOIN dishes_categorys ON DisCatCatID=CatID LEFT OUTER JOIN dishes ON DisID=DisCatDisID GROUP BY CatID ORDER BY CatLabel ASC;");
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                categories.addCategory(new Category(resultat.getString("CatID"),resultat.getString("CatLabel"),resultat.getString("NbPlat")));
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
        return categories;
    }

    public static CategoryService getCategory(String CatID) throws SQLException {
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
        CategoryService categories = new CategoryService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("Connexion OK");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT CatID,CatLabel,COUNT(DisID) AS NbPlat FROM categorys LEFT OUTER JOIN dishes_categorys ON DisCatCatID=CatID LEFT OUTER JOIN dishes ON DisID=DisCatDisID WHERE CatID = ? GROUP BY CatID ;");
            requete.setString(1,CatID);
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                categories.addCategory(new Category(resultat.getString("CatID"),resultat.getString("CatLabel"),resultat.getString("NbPlat")));
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
        return categories;
    }
}
