package request;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;

public class GraphAPIRequest extends Request{
	
	// Consistent attributes access-token 
	private final String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJub25jZSI6IjctVTdjeGxPNVBiUTJYYndxTVpObVN1N1VlWENYNEtuZGVTb3FCR3FTdFkiLCJhbGciOiJSUzI1NiIsIng1dCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCIsImtpZCI6IkwxS2ZLRklfam5YYndXYzIyeFp4dzFzVUhIMCJ9.eyJhdWQiOiIwMDAwMDAwMy0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC85ZDYwMjNiNC1mNGNlLTRkNjYtOTY5MC0xYThjMWY0ZjdkYTYvIiwiaWF0IjoxNzE3MTY3NTAxLCJuYmYiOjE3MTcxNjc1MDEsImV4cCI6MTcxNzI1NDIwMSwiYWNjdCI6MCwiYWNyIjoiMSIsImFpbyI6IkFWUUFxLzhXQUFBQTIvaWhSUEVWclhqWlRwcEpGR1FKMlIzQ3UxMEVINzExQkRWYWwyV212Q2JOTi9yUlJKelBMSnBHSjZ4QTM4L09BS0w4Z1o5UnJMandrLzZmeE5FVGJXYTVMQ3JyaVg4cHVUanBZc3oxRmdrPSIsImFtciI6WyJwd2QiLCJtZmEiXSwiYXBwX2Rpc3BsYXluYW1lIjoiR3JhcGggRXhwbG9yZXIiLCJhcHBpZCI6ImRlOGJjOGI1LWQ5ZjktNDhiMS1hOGFkLWI3NDhkYTcyNTA2NCIsImFwcGlkYWNyIjoiMCIsImZhbWlseV9uYW1lIjoiVHJ1b25nIiwiZ2l2ZW5fbmFtZSI6IlRoYW8gTmd1eWVuIiwiaWR0eXAiOiJ1c2VyIiwiaXBhZGRyIjoiMjAwMTplZTA6NGE2ZjpiZmYwOmMzYzpjZTM6ZDg4MDoyNjYzIiwibmFtZSI6IlRoYW8gTmd1eWVuIFRydW9uZyIsIm9pZCI6ImZhYzQyZGZiLTM2NjYtNDA0OS05NzdjLWI2YzBkMzkyYjM3ZiIsInBsYXRmIjoiMyIsInB1aWQiOiIxMDAzMjAwMzg2REU4NUVGIiwicmgiOiIwLkFjWUF0Q05nbmM3MFprMldrQnFNSDA5OXBnTUFBQUFBQUFBQXdBQUFBQUFBQUFER0FCRS4iLCJzY3AiOiJDYWxlbmRhcnMuUmVhZFdyaXRlIENoYW5uZWwuUmVhZEJhc2ljLkFsbCBDaGF0LlJlYWQgQ2hhdC5SZWFkQmFzaWMgQ29udGFjdHMuUmVhZFdyaXRlIERldmljZU1hbmFnZW1lbnRSQkFDLlJlYWQuQWxsIERldmljZU1hbmFnZW1lbnRTZXJ2aWNlQ29uZmlnLlJlYWQuQWxsIERpcmVjdG9yeS5SZWFkV3JpdGUuQWxsIEZpbGVzLlJlYWRXcml0ZS5BbGwgR3JvdXAuUmVhZFdyaXRlLkFsbCBHcm91cE1lbWJlci5SZWFkV3JpdGUuQWxsIElkZW50aXR5Umlza0V2ZW50LlJlYWQuQWxsIE1haWwuUmVhZCBNYWlsLlJlYWRXcml0ZSBNYWlsYm94U2V0dGluZ3MuUmVhZFdyaXRlIE5vdGVzLlJlYWRXcml0ZS5BbGwgb3BlbmlkIFBlb3BsZS5SZWFkIFBsYWNlLlJlYWQgUHJlc2VuY2UuUmVhZCBQcmVzZW5jZS5SZWFkLkFsbCBQcmludGVyU2hhcmUuUmVhZEJhc2ljLkFsbCBQcmludEpvYi5DcmVhdGUgUHJpbnRKb2IuUmVhZEJhc2ljIHByb2ZpbGUgUmVwb3J0cy5SZWFkLkFsbCBTaXRlcy5SZWFkV3JpdGUuQWxsIFRhc2tzLlJlYWRXcml0ZSBUZWFtTWVtYmVyLlJlYWQuQWxsIFRlYW1NZW1iZXIuUmVhZFdyaXRlLkFsbCBUZWFtd29ya1RhZy5SZWFkIFRlYW13b3JrVGFnLlJlYWRXcml0ZSBVc2VyLlJlYWQgVXNlci5SZWFkQmFzaWMuQWxsIFVzZXIuUmVhZFdyaXRlIFVzZXIuUmVhZFdyaXRlLkFsbCBlbWFpbCIsInN1YiI6IlJ2Ul85cnUwTURiblRLdDZWeGpGSDVGTnBiMndvYUdUd3pzZE5Qb1ppUXciLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiQVMiLCJ0aWQiOiI5ZDYwMjNiNC1mNGNlLTRkNjYtOTY5MC0xYThjMWY0ZjdkYTYiLCJ1bmlxdWVfbmFtZSI6ImFkbWludGVhbUBtZWFkb3dpbGxhLm9ubWljcm9zb2Z0LmNvbSIsInVwbiI6ImFkbWludGVhbUBtZWFkb3dpbGxhLm9ubWljcm9zb2Z0LmNvbSIsInV0aSI6IkZQZTFrdGVCT0VxSklsQXlHZW53QWciLCJ2ZXIiOiIxLjAiLCJ3aWRzIjpbIjYyZTkwMzk0LTY5ZjUtNDIzNy05MTkwLTAxMjE3NzE0NWUxMCIsImI3OWZiZjRkLTNlZjktNDY4OS04MTQzLTc2YjE5NGU4NTUwOSJdLCJ4bXNfY2MiOlsiQ1AxIl0sInhtc19zc20iOiIxIiwieG1zX3N0Ijp7InN1YiI6IjVaR29kdDhhZ01aY1FwWWZ4aldoR1NIVTBNRzlDVEZ3MllJSGpDaHc5Y00ifSwieG1zX3RjZHQiOjE3MTY3MzczMDZ9.XOIMJ0A_tDl9zigv0-BqcGQXG1J7FDI7v8xmhOTrqnKn5m7SZ2kcKlFYHrdDW7RwVZNYLO9iXgMbDRaTBJ0OxFQLkfmEszUqCclWm_Rw86pqYBtQEeArhcDxySXULtlaEGFsed8bdrSYqwTl9H-l-N2katNbHILXwB5z7NesWe-ScN2hKw9RFXpsIQibIDIMTBifTZZDKLG_a4q3IG_js-F8RJILK4EWl2L8cVsV8JRMcQgecRrMhDTtZ2HVKr_XUg1hBSDy6NCTPF2h9sT3Qa5fHWryFh2J2NNGktImbNovOpe95GEF9xcyzwVjPAwVZPrj2Zwj21HgC_0UwD5qQQ";
	String URL;
	
	@Override
	public HttpRequest postRequest(String bodyString) {
		
		// input can be passed into body is string --> use method ofString()
		BodyPublisher requestBody = BodyPublishers.ofString(bodyString);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL)) // to be modified
				.POST(requestBody)
				.header("Authorization", "Bearer " + ACCESS_TOKEN)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}

	@Override
	public HttpRequest getRequest() {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(URL)) // to be modified
				.GET()
				.header("Authorization", "Bearer " + ACCESS_TOKEN)
				.header("Content-Type", "application/json")
				.build();
		return request;
	}
	
	public static void main(String [] args) {
		
	}
}
