package test;

import java.io.IOException;
import java.io.StringReader;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import request.TeamAPIRequest;

public class testTeamAPI {
    private String teamId;

    public void joinedTeams(){
        HttpClient client = HttpClient.newHttpClient();

        TeamAPIRequest TeamReq = new TeamAPIRequest();

        HttpRequest getRequest = TeamReq.getRequest();

        try{
            HttpResponse<String> response = client.send(getRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Code status: " + response.statusCode());
            //System.out.println("Response Body: " + response.body());
            // // Parse the JSON respons into "JsonObject"
            JsonReader jsonReader = Json.createReader(new StringReader(response.body()));
            JsonObject jsonObject = jsonReader.readObject();

            // // Access the "value" array
            JsonArray valueArray = jsonObject.getJsonArray("value");
            if (valueArray != null && !valueArray.isEmpty()){
                this.teamId = valueArray.getJsonObject(0).getString("id");
                System.out.println("TeamId: " + this.teamId); 
            }
            // for (JsonObject team : valueArray.getValuesAs(JsonObject.class)) {
            //     String teamId = team.getString("id");

            //     // System.out.println("ID: " + team.getString("id"));
            //     // System.out.println("Name: " + team.getString("displayName"));
            //     // System.out.println("Description: " + team.getString("description", "No description"));
            //     // System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    // public static void main(String[] args){
    //     testTeamAPI checker = new testTeamAPI();
    //     checker.joinedTeams();
    public String getTeamId() {
        return teamId;
    }

        
    // }
}
