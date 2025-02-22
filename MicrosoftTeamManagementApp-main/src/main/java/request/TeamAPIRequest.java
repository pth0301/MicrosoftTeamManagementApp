package request;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;

public class TeamAPIRequest extends Request{

    private final String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJub25jZSI6ImJMd210TGExeHpQQThzWHVJMlNwNXJXN0h2YTAwZ1ppVk9WZTNFa1RNRzgiLCJhbGciOiJSUzI1NiIsIng1dCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC85ZDYwMjNiNC1mNGNlLTRkNjYtOTY5MC0xYThjMWY0ZjdkYTYvIiwiaWF0IjoxNzE3NjA2NzMyLCJuYmYiOjE3MTc2MDY3MzIsImV4cCI6MTcxNzY5MzQzMiwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFWUUFxLzhXQUFBQTFUR0dvQjRsbHFtMHROTWZHd3ZOaUpXajZXS1VBckJhY0RmcENvTFJseUkzNHBQK3pUeHJTVXhnaitQZ0ZiVU5lZTFZalBhNmNRTmlWdW83UG04Q0VMbUhPRDVKd3FYcWlDeTZEWm5pWUs0PSIsImFtciI6WyJwd2QiLCJtZmEiXSwiYXBwX2Rpc3BsYXluYW1lIjoiR3JhcGggRXhwbG9yZXIiLCJhcHBpZCI6ImRlOGJjOGI1LWQ5ZjktNDhiMS1hOGFkLWI3NDhkYTcyNTA2NCIsImFwcGlkYWNyIjoiMCIsImZhbWlseV9uYW1lIjoiVHJ1b25nIiwiZ2l2ZW5fbmFtZSI6IlRoYW8gTmd1eWVuIiwiaWR0eXAiOiJ1c2VyIiwiaXBhZGRyIjoiMjQwNTo0ODAyOjFmNjpjNTQwOjg4ZWM6OTk1NTpjYzc3OjRlZTEiLCJuYW1lIjoiVGhhbyBOZ3V5ZW4gVHJ1b25nIiwib2lkIjoiZmFjNDJkZmItMzY2Ni00MDQ5LTk3N2MtYjZjMGQzOTJiMzdmIiwicGxhdGYiOiIzIiwicHVpZCI6IjEwMDMyMDAzODZERTg1RUYiLCJyaCI6IjAuQWNZQXRDTmduYzcwWmsyV2tCcU1IMDk5cGdNQUFBQUFBQUFBd0FBQUFBQUFBQURHQUJFLiIsInNjcCI6IkNhbGVuZGFycy5SZWFkV3JpdGUgQ2hhbm5lbC5SZWFkQmFzaWMuQWxsIENoYXQuUmVhZCBDaGF0LlJlYWRCYXNpYyBDb250YWN0cy5SZWFkV3JpdGUgRGV2aWNlTWFuYWdlbWVudFJCQUMuUmVhZC5BbGwgRGV2aWNlTWFuYWdlbWVudFNlcnZpY2VDb25maWcuUmVhZC5BbGwgRGlyZWN0b3J5LlJlYWRXcml0ZS5BbGwgRmlsZXMuUmVhZFdyaXRlLkFsbCBHcm91cC5SZWFkV3JpdGUuQWxsIEdyb3VwTWVtYmVyLlJlYWRXcml0ZS5BbGwgSWRlbnRpdHlSaXNrRXZlbnQuUmVhZC5BbGwgTWFpbC5SZWFkIE1haWwuUmVhZFdyaXRlIE1haWxib3hTZXR0aW5ncy5SZWFkV3JpdGUgTm90ZXMuUmVhZFdyaXRlLkFsbCBvcGVuaWQgUGVvcGxlLlJlYWQgUGxhY2UuUmVhZCBQcmVzZW5jZS5SZWFkIFByZXNlbmNlLlJlYWQuQWxsIFByaW50ZXJTaGFyZS5SZWFkQmFzaWMuQWxsIFByaW50Sm9iLkNyZWF0ZSBQcmludEpvYi5SZWFkQmFzaWMgcHJvZmlsZSBSZXBvcnRzLlJlYWQuQWxsIFNpdGVzLlJlYWRXcml0ZS5BbGwgVGFza3MuUmVhZFdyaXRlIFRlYW1NZW1iZXIuUmVhZC5BbGwgVGVhbU1lbWJlci5SZWFkV3JpdGUuQWxsIFRlYW13b3JrVGFnLlJlYWQgVGVhbXdvcmtUYWcuUmVhZFdyaXRlIFVzZXIuUmVhZCBVc2VyLlJlYWRCYXNpYy5BbGwgVXNlci5SZWFkV3JpdGUgVXNlci5SZWFkV3JpdGUuQWxsIGVtYWlsIiwic3ViIjoiUnZSXzlydTBNRGJuVEt0NlZ4akZINUZOcGIyd29hR1R3enNkTlBvWmlRdyIsInRlbmFudF9yZWdpb25fc2NvcGUiOiJBUyIsInRpZCI6IjlkNjAyM2I0LWY0Y2UtNGQ2Ni05NjkwLTFhOGMxZjRmN2RhNiIsInVuaXF1ZV9uYW1lIjoiYWRtaW50ZWFtQG1lYWRvd2lsbGEub25taWNyb3NvZnQuY29tIiwidXBuIjoiYWRtaW50ZWFtQG1lYWRvd2lsbGEub25taWNyb3NvZnQuY29tIiwidXRpIjoiRkR5MUQtOXplVUdJQS16YUJYSlRBUSIsInZlciI6IjEuMCIsIndpZHMiOlsiNjJlOTAzOTQtNjlmNS00MjM3LTkxOTAtMDEyMTc3MTQ1ZTEwIiwiYjc5ZmJmNGQtM2VmOS00Njg5LTgxNDMtNzZiMTk0ZTg1NTA5Il0sInhtc19jYyI6WyJDUDEiXSwieG1zX3NzbSI6IjEiLCJ4bXNfc3QiOnsic3ViIjoiNVpHb2R0OGFnTVpjUXBZZnhqV2hHU0hVME1HOUNURncyWUlIakNodzljTSJ9LCJ4bXNfdGNkdCI6MTcxNjczNzMwNn0.aijPfqVAehm0Hv0nVtFuO5O53zowQ0Z80i3a5g08pMXcfB_MsQ3MvAPiVjKO_kZVrbFWVPS-t4s2rnM2WRFosSVAyFf9ZT7z3KldYHcxmMYtZpQhdv7h0DgCM5NrZGuaVWkLBH_0xnD2pd69j72Wh5HWPEXjVtGeHq_WkwAeG7jB9fL3PZ24LmtWnrbdk5vKUqEp0ZMGqc1fXvFjHqFIeJzn-1iDNLPznZE3vEEA63huAeGx75xfSqpPH-YS7_Furc8CNHMUl_YujQ2XOPIKlDEcP6tzlYov8opuuFz3H307rCs-j0fnNNez4PkcoPeFm6omXU20V5IZHTcPLjOg9g";
    @Override
    public HttpRequest getRequest(){
        HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://graph.microsoft.com/v1.0/me/joinedTeams"))
				.GET()
				.header("Authorization", "Bearer " + ACCESS_TOKEN)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}
    @Override
    public HttpRequest postRequest(String bodyString) {
		
		// input can be passed into body is string --> use method ofString()
		BodyPublisher requestBody = BodyPublishers.ofString(bodyString);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://graph.microsoft.com/v1.0/teams"))
				.POST(requestBody)
				.header("Authorization", "Bearer " + ACCESS_TOKEN)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}
    
}
