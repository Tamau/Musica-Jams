package com.sinch.android.rtc.sample.messaging;

/**
 * Created by taylorpiggy on 10/19/14.
 */
import java.util.ArrayList;
import java.net.URL;

public class Profile {
    private String userName;
    private String password;
    private String name;
    private int age;
    private String town;
    private FriendsList friends;
    private ArrayList<URL> clips;
    private ArrayList<String> instruments;
    private int gender; //0=male 1=female 2=prefer not to answer
    private ArrayList<String> genres;
    private ArrayList<Profile> likes = new ArrayList<Profile>();
    public Profile(String u, String p, String n, int a, String t, ArrayList<URL> c, FriendsList f,
                   ArrayList<String> i, int g, ArrayList<String> x){
        userName = u;
        password = p;
        name = n;
        age = a;
        town = t;
        clips = c;
        friends = f;
        instruments = i;
        gender = g;
        genres = x;
    }// end constructor

    public Profile(){
        userName = null;
        age = -1;
        town = null;
        clips = new ArrayList<URL>();
        instruments = new ArrayList<String>();
        gender = -1;
        genres = new ArrayList<String>();
    }// end constructor

    public void addLike( Profile profile ){
        likes.add(profile);
    } // end method addLike

    public ArrayList<Profile> getLikes(){
        return likes;
    } // end method getLikes

    public void setUserName( String name ){
        userName = name;
    } // end method setUserName

    public String getUserName(){
        return userName;
    } // end method getUserName

    public void setPassword( String password ){
        this.password = password;
    } // end method setUserName

    public String getPassword(){
        return this.password;
    } // end method getUserName

    public void setName( String name ){
        this.name = name;
    } // end method setName

    public String getName(){
        return name;
    } // end method getName

    public void setAge( int age ){
        this.age = age;
    } // end method setAge

    public int getAge(){
        return age;
    } // end method getAge

    public void setTown( String town ){
        this.town = town;
    } // end method setTown

    public String getTown(){
        return town;
    } // end method getTown

    public void addClips( ArrayList<URL> c ){
        for( URL u : c ){
            clips.add(u);
        }// end for
    }// end method setClip

    public ArrayList<URL> getClips(){
        return clips;
    } // end method getClips

    public void addInstruments( ArrayList<String> i ){
        for( String s : i ){
            instruments.add( s );
        } // end for
    } // end method addInstruments

    public ArrayList<String> getInstruments(){
        return instruments;
    } // end method getInstruments

    public void setGender( int g ){
        gender = g;
    } // end method setGender

    public int getGender(){
        return gender;
    }// end method getGender

    public void addGenres( ArrayList<String> g ){
        for( String s : g ){
            genres.add(s);
        } // end for
    } // end method addGenres

    public ArrayList<String> getGenres(){
        return genres;
    } // end method getGenres

    public void setFriendsList( FriendsList f ){
        friends = f;
    } // end method setFriendsList

    public FriendsList getFriendsList(){
        return friends;
    } // end getFriendsList

} // end class Profile
