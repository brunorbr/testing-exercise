package utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailValidator {
    private final String apiKey;
    private final HttpClient client;
    private HttpResponse<String> response;
    List<String> containedUrls;

    public MailValidator(){
        this.client = HttpClient.newHttpClient();
        PropertiesReader properties = new PropertiesReader("./test.properties");
        this.apiKey = properties.getAPIkey();
        this.containedUrls = new ArrayList<String>();
    }

    public HttpRequest requestBuilder(String userMail) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI("https://mailsac.com/api/addresses/"
                        +userMail
                        +"/messages"))
                .header("Mailsac-Key", apiKey)
                .GET()
                .build();
    }

    public HttpResponse<String> getResponseBody(String userMail) throws IOException, InterruptedException, URISyntaxException {
        return response = client.send(requestBuilder(userMail),
                HttpResponse.BodyHandlers.ofString());
    }

    public void parseURL() throws IOException, InterruptedException {
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(response.body());
        while (urlMatcher.find()) {
            containedUrls.add(response.body().substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
    }

    public String getValidationURL(String userMail) throws IOException, InterruptedException, URISyntaxException {
        TimeUnit.SECONDS.sleep(10);
        getResponseBody(userMail);
        parseURL();
        return containedUrls.get(0);
    }
}
