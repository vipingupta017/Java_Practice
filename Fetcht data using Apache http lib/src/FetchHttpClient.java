import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class FetchHttpClient {
	public static void main(String args[]) {

		String url = "https://en.wikipedia.org/wiki/Amazon.com";

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		try {
			HttpResponse response = client.execute(request);
			
			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String result = "";
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.concat(line + '\n');

				Pattern p = Pattern.compile(".*<(h1|h2|h3|h4|h5|h6)>([^</]*)</(h1|h2|h3|h4|h5|h6)>.*");
				Matcher m = p.matcher(line);
				if (m.matches()) {
					String tdValue = m.group(2);
					System.out.println("content:" + tdValue);
				}
				p = Pattern.compile(".*<(h1|h2|h3|h4|h5|h6)([^>]*)>([^>]*)</(h1|h2|h3|h4|h5|h6)>.*");
				m = p.matcher(line);
				if (m.matches()) {
					String tdValue = m.group(3);
					System.out.println("content:" + tdValue);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			request.releaseConnection();
		}
	}
}