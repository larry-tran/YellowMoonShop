/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtr.google;

/**
 *
 * @author Admin
 */
public class Constants {
    public static String GOOGLE_CLIENT_ID = "405464542510-30phjlh1mkdbjtnobpo7q5bpf192i2qn.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "-i3fqeQQSQ0AZOnvKAMYsxuc";
  public static String GOOGLE_REDIRECT_URI = "http://localhost:8084/AccessGoogle/LoginGoogleServlet";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
