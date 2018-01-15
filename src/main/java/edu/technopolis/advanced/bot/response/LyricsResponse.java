package edu.technopolis.advanced.bot.response;

public class LyricsResponse extends Response {

  private String lyricsBody;

  private String lyricsLang;
  private String lyricsCopyright;

  public LyricsResponse(String lyricsBody, String lyricsLang, String lyricsCopyright) {
    this.lyricsBody = lyricsBody;
    this.lyricsLang = lyricsLang;
    this.lyricsCopyright = lyricsCopyright;
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

  public String getLyricsCopyright() {
    return lyricsCopyright;
  }

  public void setLyricsCopyright(String lyricsCopyright) {
    this.lyricsCopyright = lyricsCopyright;
  }

  @Override
  public String toString() {
    return "Lyrics, language " + lyricsLang + ": " +
            lyricsBody +
            "\nCopyright: " + lyricsCopyright;
  }
}
