package be.ifosup.dishe;

import java.util.ArrayList;
import java.util.List;

public class DisheService {
    private List<Dishe> dishes = new ArrayList<>();

    public List<Dishe> getDishes(){
        return dishes;
    }

    public void addDishes(Dishe dishe){
        dishes.add(dishe);
    }

    public void removeCategory(Dishe dishe){
        dishes.remove(dishe);
    }
}
