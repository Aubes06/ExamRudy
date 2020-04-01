package be.ifosup.dishe;

public class Dishe {
    // ATTRIBUTES
    private String id;
    private String label;
    private String description;
    private String price;
    private String categoryId;
    private String category;

    // CONSTRUCTOR
    public Dishe(String id, String label, String description, String price, String categoryId, String category) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.price = price;
        this.category = category;
        this.categoryId = categoryId;
    }

    // GETTER
    public String getId() {
        return id;
    }
    public String getLabel() {
        return this.label;
    }
    public String getDescription() {
        return this.description;
    }
    public String getPrice() {
        return this.price;
    }
    public String getCategoryId() {
        return this.categoryId;
    }
    public String getCategory() {
        return this.category;
    }

    // SETTER
    public void setId(String id) {
        this.id = id;
    }
    public void setLabel(String label) { this.label = label; }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
    public void setCategory(String category) {
        this.category = category;
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
