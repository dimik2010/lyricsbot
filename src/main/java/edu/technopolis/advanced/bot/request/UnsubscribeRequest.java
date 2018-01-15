package edu.technopolis.advanced.bot.request;

public class UnsubscribeRequest extends Request<UnsubscribePayload, UnsubscribeRequest> {

  private String query;


  public UnsubscribeRequest(String query, UnsubscribePayload payload) {
    super(payload);
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }


  @Override
  protected UnsubscribeRequest thiss() {
    return this;
  }

  @Override
  public String getQueryStart() {
    return query;
  }
}
