package entity;

public class testTeam {
    public static void main(String[] args){
        Team team = new Team();
        Channel c1 = new Channel("Discussion", "The channel is where we can discuss about different issues");
        team.createChannel(c1);

        Channel c2 = new Channel("Speaking", "The channel is where we can practice speaking English with naive people.");
        team.createChannel(c2);

        team.print();

    }
}
