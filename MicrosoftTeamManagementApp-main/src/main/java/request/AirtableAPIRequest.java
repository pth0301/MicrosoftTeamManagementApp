package request;

import java.net.URI; // identify the resources on the internet

// an object that represents the request we want to send
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;

public class AirtableAPIRequest extends Request{
	
	private final String BASE_ID = "app5WKXKJaKTLR4Mw";
	private final String TABLE_ID = "tblRBT1Xgmu4IT7OR";
	private final String API_KEY = "patP7aWBuMyPn1ZkC.808eb01a7b33e9dfec92ed3313eb952aa9203d2a68838e8ac8f658eb66901399";
	private final String URL = "https://api.airtable.com/v0/" + BASE_ID + "/" + TABLE_ID;

	@Override
	public HttpRequest postRequest(String bodyString) { // methods override from abstract request class
		BodyPublisher requestBody = BodyPublishers.ofString(bodyString);
		
		// Request want to send with instances Builder class--> provides a bunch of methods 
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL)) // to be modified(methods of Builder class)
				.POST(requestBody)
				.header("Authorization", "Bearer " + API_KEY)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}

	@Override
	public HttpRequest getRequest() {		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL))
				.GET()
				.header("Authorization", "Bearer " + API_KEY)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}

}
