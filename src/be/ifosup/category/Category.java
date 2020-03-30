package be.ifosup.category;

public class Category {
    //attributs
    private String id;
    private String label;
    private String nbPlat;

    public Category(String id, String label, String nbPlat) {
        this.id = id;
        this.label = label;
        this.nbPlat = nbPlat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getNbPlat() {
        return this.nbPlat;
    }

    public void setNbPlat(String nbPlat) {
        this.nbPlat = nbPlat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (getLabel() != null ? !getLabel().equals(category.getLabel()) : category.getLabel() != null) return false;
        return getLabel() != null ? getLabel().equals(category.getLabel()) : category.getLabel() == null;
    }

    @Override
    public int hashCode() {
        int result = getLabel() != null ? getLabel().hashCode() : 0;
        result = 31 * result + (getLabel() != null ? getLabel().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Categroy{" +
                "ID = '" + id + '\'' +
                ", Libelé='" + label + '\'' +
                ", Nombre de plat ='" + nbPlat + '\'' +
                '}';
    }
}
