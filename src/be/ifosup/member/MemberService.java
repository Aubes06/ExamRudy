package be.ifosup.member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private static List<Member> members = new ArrayList<>();

    static {
        members.add(new Member("Geoffrey", "cugnon.0710.student@ifosupwavre.be"));
        members.add(new Member("Laurent", "gorlier.0901.student@ifosupwavre.be"));
        members.add(new Member("Korenthin", "pierre.0612.student@ifosupwavre.be"));
    }
    public static List<Member> recupMembers() {
        return members;
    }

    public void ajouteMember( Member member){
        members.add(member);
    }

    public void supprime( Member member){
        members.remove(member);
    }
}