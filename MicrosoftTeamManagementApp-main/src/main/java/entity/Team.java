package entity;
import java.util.ArrayList;

public class Team {
    private String displayName;
    private String discription;
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Channel> channels = new ArrayList<>();
    
    
    public String getDiscription() {
        return discription;
    }

    public String getDisplayName() {
        return displayName;
    }
    public ArrayList<Member> getMembers() {
        return members;
    }
    public ArrayList<Channel> getChannels() {
        return channels;
    }
    public Team(){

    }
    public void createChannel(Channel channel){
        if(!channels.contains(channel)){
            channels.add(channel);
        }
        System.out.println("The channel has been created.");
    }
    public void addMembers(Member member){
        if (!members.contains(member)){
            members.add(member);
        }
        System.out.println("The member has been added.");
    }
    public void print(){
        for (int i = 0; i < channels.size(); i++){
            System.out.println((i + 1) + ". " + channels.get(i).toString());
        }
    }
}
