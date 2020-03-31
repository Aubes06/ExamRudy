package be.ifosup.member;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private List<Member> members = new ArrayList<>();

    public List<Member> recupMembers() {
        return members;
    }

    public void addMember( Member member){ members.add(member); }

    public void supprime( Member member){
        members.remove(member);
    }
}