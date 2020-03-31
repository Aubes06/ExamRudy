package be.ifosup.member;

public class Member {
    private String nom;
    private String email;

    public Member(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
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
        return "Todo{" +
                "nom = '" + nom + '\'' +
                ", email ='" + email + '\'' +
                '}';
    }
}