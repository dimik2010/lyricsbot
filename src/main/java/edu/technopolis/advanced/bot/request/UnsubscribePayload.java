package edu.technopolis.advanced.bot.request;


public class UnsubscribePayload implements RequestPayload {
  String url;

  public UnsubscribePayload(String url) {
    this.url = url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUrl() {
    return url;
  }
}
