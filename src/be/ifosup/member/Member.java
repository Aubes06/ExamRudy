package be.ifosup.member;

public class Member {
    // ATTRIBUT
    private String id;
    private String name;
    private String email;

    // CONSTRUCTOR
    public Member(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // GETTER
    public String getId() {
        return id;
    }
    public String getNom() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    //SETTER
    public void setId(String id) { this.id = id; }
    public void setNom(String nom) {
        this.name = nom;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        if (getNom() != null ? !getNom().equals(member.getNom()) : member.getNom() != null) return false;
        return getEmail() != null ? getEmail().equals(member.getEmail()) : member.getEmail() == null;
    }

    @Override
    public int hashCode() {
        int result = getNom() != null ? getNom().hashCode() : 0;
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Informations {" +
                "id = '" + id + '\'' +
                "nom = '" + name + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }
}