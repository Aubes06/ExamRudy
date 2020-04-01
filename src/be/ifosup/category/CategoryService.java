package be.ifosup.category;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    // Création d'une liste qui contiendra des instances de la classe Category
    private List<Category> categories = new ArrayList<>();

    // Méthode qui retourne la liste des catégories
    public List<Category> getCategories(){
        return categories;
    }

    // Méthode qui ajoute dans la liste des catégories une instance
    public void addCategory(Category category){ categories.add(category); }

    // Méthode qui supprimer la liste des catégories
    public void removeCategory(Category category){
        categories.remove(category);
    }
}
