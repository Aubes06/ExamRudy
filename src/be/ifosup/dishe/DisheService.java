package be.ifosup.dishe;

import java.util.ArrayList;
import java.util.List;

public class DisheService {

    // Création d'une liste qui contiendra des instances de la classe Dishe
    private List<Dishe> dishes = new ArrayList<>();

    // Méthode qui retourne la liste des catégories
    public List<Dishe> getDishes(){ return dishes; }

    public void addDishes(Dishe dishe){
        dishes.add(dishe);
    }

    public void removeCategory(Dishe dishe){
        dishes.remove(dishe);
    }
}
