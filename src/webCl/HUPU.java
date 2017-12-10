package webCl;

public class HUPU {
  public static String htmlS(String id, int page) {
    return WebC.httpRequest("http://bbs.csdn.net/topics/392284846?page=1");
  }
  public static void main(String[] args) {
    String s=htmlS("1",1);
    Main.textWrite("html1.txt", s);
  }

}
