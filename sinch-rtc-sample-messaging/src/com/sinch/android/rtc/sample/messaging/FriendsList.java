package com.sinch.android.rtc.sample.messaging;

/**
 * Created by jasoncapili on 10/18/14.
 */
import java.util.ArrayList;

public class FriendsList {
    ArrayList<Profile> friends;

    public FriendsList(){
        friends = new ArrayList<Profile>();
    } // end constructor

    public void addFriend( Profile p ){
        friends.add(p);
    } // end method addFriend

    public void addFriends( ArrayList<Profile> p ){
        for( Profile s : p ){
            friends.add(s);
        } // end for
    } // end method addFriends

    public void removeFriend( Profile p ){
        for( int counter = 0; counter < friends.size(); counter++ ){
            if( p.getName().equals(friends.get(counter).getName())){
                friends.remove( counter );
            } // end if
        } // end for
    } // end method removeFriend
} // end class FriendsList
