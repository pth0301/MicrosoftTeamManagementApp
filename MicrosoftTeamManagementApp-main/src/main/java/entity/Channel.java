package entity;  
import java.util.ArrayList;

public class Channel {
    private String displayName;
    private String description;
    private String memberType;
    public String getMemberType() {
        return memberType;
    }
    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    private ArrayList<Member> members = new ArrayList<Member>();


    public Channel(){
        
    }
    public ArrayList<Member> getMembers() {
        return members;
    }

    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Channel(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    
    }
    public String toString(){
        return String.format("Channel - %s - %s", displayName, description);
    }
    
    

}
