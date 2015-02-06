package sikayetVar;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

public class HttpRequests {
	private String htmlCodeOfPage;
	private String url;
	private String MAIN_URL = "https://www.sikayetvar.com/sikayetler";

	public String sendGetRequest() throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.setFollowRedirects(false);
		httpClient.start();

		ContentResponse response = httpClient.GET(url);
		htmlCodeOfPage = response.getContentAsString();
		httpClient.stop();

		return htmlCodeOfPage;
	}
	
	public String sendPostRequest(int i) throws Exception {
		URL obj = new URL(MAIN_URL);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add request header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.8,tr;q=0.6");

		String urlParameters = "ignoreAjax=1&page=" + Integer.toString(i);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}