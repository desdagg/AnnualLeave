package com.example.des.annualleave;

<<<<<<< HEAD


=======
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
/**
 * Created by Des on 18/11/2016.
 */

public class CurrentUser {
<<<<<<< HEAD

    private static CurrentUser userInstance;

    private String name;
    private String id;

    public static CurrentUser getInstance(String name){
        if (userInstance == null) {
            userInstance = new CurrentUser(name);
        }
        return userInstance;
    }

    private CurrentUser(String n){
=======
    private String name;
    private String id;

    public CurrentUser(String n){
>>>>>>> 5055008babee058aa44497b659a32ed610132c74
        name = n;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }
}
