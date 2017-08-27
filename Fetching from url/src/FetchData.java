import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetchData {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://en.wikipedia.org/wiki/Amazon.com");
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String line;
			while ((line = in.readLine()) != null) {
				//System.out.println(line);
				Pattern p = Pattern.compile(".*<(h1|h2|h3|h4|h5|h6)>([^</]*)</(h1|h2|h3|h4|h5|h6)>.*");
				Matcher m = p.matcher(line);
				if (m.matches()) {
					String tdValue = m.group(2);
					System.out.println("Heading Content:" + tdValue);
				}
				p = Pattern.compile(".*<(h1|h2|h3|h4|h5|h6)([^>]*)>([^>]*)</(h1|h2|h3|h4|h5|h6)>.*");
				m = p.matcher(line);
				if (m.matches()) {
					String tdValue = m.group(3);
					System.out.println("Heading Content:" + tdValue);
				}
			}
			in.close();
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("I/O Error: " + e.getMessage());
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("String Exception: " + e.getMessage());
		}
	}

}