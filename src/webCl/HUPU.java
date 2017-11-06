package webCl;

public class HUPU {
  public static String htmlS(String id, int page) {
    return WebC.httpRequest("https://bbs.hupu.com/20657940.html");
  }
  public static void main(String[] args) {
    String s=htmlS("1",1);
    Main.textWrite("html.txt", s);
  }

}
