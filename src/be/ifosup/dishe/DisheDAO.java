package be.ifosup.dishe;
import java.sql.*;

public class DisheDAO {
    // Sélectionner tout les plats avec la jointure categories correspondante dans la base de donnée
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

    // Rechercher un plat dans la base de donnée via un terme de recherche
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

    // Ajouter un plat dans la base de donnée
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

    // Récuperer l'id d'un plat via le nom de plat
    public static String getDisheByLabel(String DisLabel) throws SQLException {
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
        String DisID = null;
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
            PreparedStatement requete = connection.prepareStatement("SELECT DisID FROM dishes WHERE DisLabel = ? ;");
            requete.setString(1, DisLabel);
            resultat = requete.executeQuery();
            if ( resultat.next() ) DisID = resultat.getString("DisID");
        }catch (SQLException e){
            System.out.println("[DisheDAO] Problème avec la requête");
        }finally {
            if (resultat != null) resultat.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return DisID;
    }

    // Supprimer un plat de la base de donnée
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

    // Modifier un plat de la base de donnée
    public static boolean EditDishe( String DisheID, String DisheName, String DisheDesc, String DishePrice ) throws SQLException {
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
            PreparedStatement requete = connection.prepareStatement("UPDATE dishes SET DisLabel = ?, DisDescription = ?, DisPrice = ? WHERE DisID = ?;");
            requete.setString(1, DisheName);
            requete.setString(2, DisheDesc);
            requete.setString(3, DishePrice);
            requete.setString(4, DisheID);

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
