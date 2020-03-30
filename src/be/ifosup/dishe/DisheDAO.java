package be.ifosup.dishe;

import java.sql.*;

public class DisheDAO {

    public static DisheService getDishes() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
        DisheService dishes = new DisheService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT DisID,DisLabel,DisDescription,DisPrice,CatID,CatLabel FROM dishes LEFT OUTER JOIN categories on CatID=DisCatID ORDER BY CatLabel ASC,DisLabel ASC;");
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                dishes.addDishes(new Dishe(resultat.getString("DisID"),resultat.getString("DisLabel"),resultat.getString("DisDescription"),resultat.getString("DisPrice"),resultat.getString("CatID"),resultat.getString("CatLabel")));
            }
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return dishes;
    }

    public static DisheService getDishesCategories() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
        DisheService dishes = new DisheService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT DisID,DisLabel,DisDescription,DisPrice,CatID,CatLabel FROM categories LEFT OUTER JOIN dishes on DisCatID=CatID ORDER BY CatLabel ASC,DisLabel ASC;");
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                dishes.addDishes(new Dishe(resultat.getString("DisID"),resultat.getString("DisLabel"),resultat.getString("DisDescription"),resultat.getString("DisPrice"),resultat.getString("CatID"),resultat.getString("CatLabel")));
            }
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return dishes;
    }

    public static DisheService getDishesCategoriesBySearch( String search ) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
        DisheService dishes = new DisheService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }
        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT DisID,DisLabel,DisDescription,DisPrice,CatID,CatLabel FROM categories LEFT OUTER JOIN dishes on DisCatID=CatID WHERE DisLabel LIKE ? ORDER BY CatLabel ASC,DisLabel ASC;");
            requete.setString(1,"%"+search+"%");
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                dishes.addDishes(new Dishe(resultat.getString("DisID"),resultat.getString("DisLabel"),resultat.getString("DisDescription"),resultat.getString("DisPrice"),resultat.getString("CatID"),resultat.getString("CatLabel")));
            }
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return dishes;
    }

    public static DisheService getDishe(String DisID) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
        DisheService dishes = new DisheService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[DisheDAO] Connexion à la base de données établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT DisID,DisLabel,DisDescription,DisPrice,CatID,CatLabel FROM dishes LEFT OUTER JOIN categories ON CatID=DisCatID WHERE DisID = ? ;");
            requete.setString(1,DisID);
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                dishes.addDishes(new Dishe(resultat.getString("DisID"),resultat.getString("DisLabel"),resultat.getString("DisDescription"),resultat.getString("DisPrice"),resultat.getString("CatID"),resultat.getString("CatLabel")));
            }
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return dishes;
    }

    public static DisheService getDisheByCategoryID(String CatID) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
        DisheService dishes = new DisheService();

        try{
            connection = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("SELECT DisID,DisLabel,DisDescription,DisPrice,CatID,CatLabel FROM categories LEFT OUTER JOIN dishes ON DisCatID=CatID WHERE CatID = ? ;");
            requete.setString(1,CatID);
            resultat = requete.executeQuery();
            while ( resultat.next() ){
                dishes.addDishes(new Dishe(resultat.getString("DisID"),resultat.getString("DisLabel"),resultat.getString("DisDescription"),resultat.getString("DisPrice"),resultat.getString("CatID"),resultat.getString("CatLabel")));
            }
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return dishes;
    }

    public static boolean addDishe( String label, String description, String price, String categoryId ) throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("INSERT INTO dishes (DisLabel, DisDescription, DisPrice, DisCatID) VALUES (?, ?, ?, ?);");
            requete.setString(1, label);
            requete.setString(2, description);
            requete.setString(3, price);
            requete.setString(4, categoryId);
            requete.executeUpdate();
            resultat = true;
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return resultat;
    }

    public static boolean delDishe( String DisID ) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("[DisheDAO] Pilote de la base de donnée chargé");
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
            System.out.println("[DisheDAO] Connexion à la base de donnée établie");
        }catch (SQLException e){
            System.out.println(e);
        }

        try{
            statement = connection.createStatement();
            PreparedStatement requete = connection.prepareStatement("DELETE FROM dishes WHERE DisID = ? ;");
            requete.setString(1, DisID);
            requete.execute();
            resultat = true;
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return resultat;
    }
}
