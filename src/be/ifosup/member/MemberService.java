package be.ifosup.member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private static List<Member> members = new ArrayList<>();

    static {
        members.add(new Member("Apprendre le Java", "Formations"));
        members.add(new Member("Préparer un steack", "Formations"));
        members.add(new Member("Manger le steack", "Slurp"));
    }
    public static List<Member> recupMembers() {
        return members;
    }

    public void ajouteTodo( Member todo){
        members.add(todo);
    }

    public void supprime( Member todo){
        members.remove(todo);
    }
}