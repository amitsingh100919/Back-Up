package com.blogmiddleware.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.cruddemobackend.DAO.FriendDAO;
import com.amit.cruddemobackend.model.Friend;
import com.amit.cruddemobackend.model.User;

@RestController
public class FriendController {

	@Autowired
	private FriendDAO friendDAO;
	@GetMapping("/suggestedUsers")
	public ResponseEntity<?> suggestedUsers(HttpSession httpSession)
	{
		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		List<User> suggestedUsers = friendDAO.listOfSuggestedUsers(email);
		return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
	}
	
	
	@PostMapping("/addFriend")
	public ResponseEntity<?> addFriend(@RequestBody User toUser ,HttpSession httpSession)
	{
		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		Friend friend=new Friend();
		friend.setFromId(email); //john.s@xyz.com
		friend.setToId(toUser.getEmail()); //james.s@xyz.com
		friend.setStatus('P');//Pending
		friendDAO.addFriendRequest(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	
	@GetMapping("/pendingRequests")
	public ResponseEntity<?> pendingRequests(HttpSession httpSession)
	{

		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		List<Friend> friendRequests = friendDAO.getAllPendingRequests(email);
		return new ResponseEntity<List<Friend>>(friendRequests,HttpStatus.OK);
	}
	
	
	@PutMapping("/updatePendingRequest")
	public ResponseEntity<?> updatePendingRequest(@RequestBody Friend friend,HttpSession httpSession)
	{
		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		friendDAO.updateFriendRequest(friend);//friend status is updated to 'A' or 'D'
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	
	@GetMapping("/listOfFriends")
	public ResponseEntity<?> listOfFriends(HttpSession httpSession)
	{
		String email = (String)httpSession.getAttribute("email");
		if(email==null) {
			return new ResponseEntity<String>("{\"message\":\"Unauthorized access please sign-in\"}",HttpStatus.UNAUTHORIZED);
		}
		List<User> friends = friendDAO.listOfFriends(email);
		return new ResponseEntity<List<User>>(friends,HttpStatus.OK);
	}
}
