package com.amit.cruddemobackend.DAO;

import java.util.List;

import com.amit.cruddemobackend.model.Friend;
import com.amit.cruddemobackend.model.User;

public interface FriendDAO {
	List<User> listOfSuggestedUsers(String email);
	void addFriendRequest(Friend friend);
	List<Friend> getAllPendingRequests(String email);//loggedin user id
	void updateFriendRequest(Friend friend);
	List<User> listOfFriends(String email);

}
