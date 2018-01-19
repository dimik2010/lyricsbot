package edu.technopolis.advanced.bot.response;

public class LyricsResponse extends Response {
  private final String URL_PREV_MESSAGE = "ПРОДОЛЖАЙТЕ ЧТЕНИЕ НА: ";
  private String lyricsBody;

  private String lyricsLang;

  private String backlinkURL;

  public LyricsResponse(String lyricsBody, String lyricsLang, String backlinkURL) {
    this.lyricsBody = lyricsBody;
    this.lyricsLang = lyricsLang;
    this.backlinkURL = backlinkURL;
  }


  public String getLyricsBody() {
    return lyricsBody;
  }

  public void setLyricsBody(String lyricsBody) {
    this.lyricsBody = lyricsBody;
  }

  public String getLyricsLang() {
    return lyricsLang;
  }

  public void setLyricsLang(String lyricsLang) {
    this.lyricsLang = lyricsLang;
  }



  @Override
  public String toString() {
    return "Lyrics, language " + lyricsLang + ": \n" +
            lyricsBody + "\n" + URL_PREV_MESSAGE + backlinkURL;
  }
}
