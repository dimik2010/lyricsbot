package edu.technopolis.advanced.bot.request;

public class LyricsRequest extends Request<RequestPayload.EmptyPayload, LyricsRequest> {
  private final String query;

  public LyricsRequest(String query) {
    this.query = query;
  }

  @Override
  protected LyricsRequest thiss() {
    return this;
  }

  @Override
  public String getQueryStart() {
    return query;
  }

  @Override
  public String toString() {
    return "LyricsRequest{" +
            "query='" + query + '\'' +
            '}';
  }
}
