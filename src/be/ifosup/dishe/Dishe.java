package be.ifosup.dishe;

public class Dishe {
    //attributs
    private String id;
    private String label;
    private String description;
    private String price;
    private String category;
    private String categoryId;

    public Dishe(String id, String label, String description, String price, String categoryId, String category) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.price = price;
        this.category = category;
        this.categoryId = categoryId;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dishe)) return false;

        Dishe category = (Dishe) o;

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
                ", Libelé = '" + label + '\'' +
                ", Description ='" + description + '\'' +
                ", Category ='" + category + '\'' +
                ", CategoryId ='" + categoryId + '\'' +
                '}';
    }
}
