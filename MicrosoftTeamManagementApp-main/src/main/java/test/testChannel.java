package test;

import java.io.IOException;
import java.io.StringWriter;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

import request.ChannelRequest;

public class testChannel {
    public void createChannel(String teamId){
        // HttpClient is used to send all requests
        HttpClient client = HttpClient.newHttpClient();
        
        // Create Json object to string 
        JsonObject jsonObject = Json.createObjectBuilder()
        
        .add("displayName", "Project1")
        .add("description", "The channel is where we can learn more about project management and teamwork")
        .add("membershipType", "private")
        .build();
        
        // Convert JSON object into string
        StringWriter stringWriter = new StringWriter();
        try(JsonWriter jsonWriter = Json.createWriter(stringWriter)){
            jsonWriter.write(jsonObject);
        }
        String requestBody = stringWriter.toString();
        
        // Create an instance of channel request
        ChannelRequest channelReq = new ChannelRequest();
        HttpRequest postRequest = channelReq.postRequest(requestBody, teamId);

        try{
            HttpResponse<String> response = client.send(postRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Code status: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}



    }
    public static void main(String[] args){
        // Create an instances of teams to get team_id
        testTeamAPI checker = new testTeamAPI();
        checker.joinedTeams();
        String teamId = checker.getTeamId();

        if (teamId != null) {
            testChannel tester = new testChannel();
            tester.createChannel(teamId);
        } else {
            System.out.println("Failed to fetch teamId.");
        }
    }
}
