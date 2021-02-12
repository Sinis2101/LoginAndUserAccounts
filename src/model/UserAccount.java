package model;

public class UserAccount {

    private String username;
    private String password;
    private String profilePic;
    private Genre genre;
    private String career;
    private String birthday;
    private Browser favBrowser;

    public UserAccount(String username, String password, String profilePic, Genre genre, String career, String birthday, Browser favBrowser) {

        this.username = username;
        this.password = password;
        this.profilePic = profilePic;
        this.genre = genre;
        this.career = career;
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
    public String getProfilePic() {
        return profilePic;
    }
    public Genre getGenre() {
        return genre;
    }
    public String getCareer() {
        return career;
    }
    public String getBirthday() {
        return birthday;
    }
    public Browser getFavBrowser() {
        return favBrowser;
    }
}
