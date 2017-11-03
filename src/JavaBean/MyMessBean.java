package JavaBean;

public class MyMessBean {
  public String mail;
  public String url;
  public String tag;
  public String rowid;
  private String state;
  public String getMail() {
    return mail;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
 
  public String getTag() {
    return tag;
  }
  public void setTag(String tag) {
    this.tag = tag;
  }
  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getRowid() {
    return rowid;
  }
  public void setRowid(String rowid) {
    this.rowid = rowid;
  }
}
