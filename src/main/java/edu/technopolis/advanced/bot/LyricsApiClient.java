package edu.technopolis.advanced.bot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.technopolis.advanced.bot.request.Request;
import edu.technopolis.advanced.bot.response.LyricsResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LyricsApiClient extends ApiClient {
  LyricsApiClient(String apiSchema, String apiHost, String tokenParam) {
    super(apiSchema, apiHost, tokenParam);
  }

  <REQ extends Request> LyricsResponse get(REQ req) throws IOException {
    String queryString = getQueryString(req);
    log.info("Sending GET to [{}]", queryString);
    HttpGet request = new HttpGet(queryString);
    request.addHeader("X-Mashape-Key", "B8Sr2BTfVKmshjkGvjgGTf2cOl6xp1iGRnPjsnkQPdHTLbuNYr");
    request.addHeader("Accept", "application/json");
    return method(request);
  }

  LyricsResponse method(HttpUriRequest method)throws IOException {
    try (CloseableHttpResponse response = client.execute(method)){
      StringBuilder sb = new StringBuilder();
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))) {
        String line;
        while ((line = reader.readLine()) != null) {
          sb.append(line);
        }
      }
      ObjectNode content = MAPPER.readValue(sb.toString(), ObjectNode.class);
      JsonNode[] responseFields = new JsonNode[3];
      responseFields[0] = content.get("lyrics_body");
      responseFields[1] = content.get("lyrics_language");
      responseFields[2] = content.get("lyrics_copyright");
      String[] responseStringArray = convertJsonNodeToString(responseFields);
      log.info("Read response {}", Arrays.toString(responseFields));
      return new LyricsResponse(responseStringArray[0], responseStringArray[1], responseStringArray[2]);
    }
  }

  private  String[] convertJsonNodeToString(JsonNode[] array) {
    String[] res = new String[array.length];
    for (int i = 0; i < array.length; i++) {
      res[i] = array[i] == null ? null : array[i].textValue();
    }
    return res;
  }
}
