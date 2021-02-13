package model;

import javafx.scene.image.Image;
import java.util.ArrayList;

public class UserAccount {

    private String username;
    private String password;
    private Image profilePic;
    private Genre genre;
    private ArrayList<String> careers;
    private String birthday;
    private String favBrowser;

    public UserAccount(String username, String password, Image profilePic, Genre genre, ArrayList<String> careers, String birthday, String favBrowser) {

        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
        this.genre = genre;
        this.careers = careers;
        this.birthday = birthday;
        this.favBrowser = favBrowser;

    }

    // GETTERS

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public Image getProfilePic() {
        return profilePic;
    }
    public Genre getGenre() {
        return genre;
    }
    public ArrayList<String> getCareers() {
        return careers;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getFavBrowser() {
        return favBrowser;
    }
}
