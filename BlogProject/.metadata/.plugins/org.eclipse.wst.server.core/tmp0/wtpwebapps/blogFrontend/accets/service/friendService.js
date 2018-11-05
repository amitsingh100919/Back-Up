app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL = "http://localhost:8081/blogmiddleware"
	friendService.getSuggestedUsers=function(){
		return $http.get(BASE_URL+ "/suggestedUsers")
	}
	
	friendService.addFriend=function(user){//toId in friend table
		return $http.post(BASE_URL + "/addFriend",user)
	}
	friendService.getPendingRequests=function(){
		return $http.get(BASE_URL + "/pendingRequests")
	}
	friendService.updateFriendRequest=function(friendRequest){
		//{'id':754,'fromId':'john.s@xyz.com','toId':'james.s@xyz.com',status:'A'}
		return $http.put(BASE_URL + "/updatePendingRequest",friendRequest)
	}
	friendService.listOfFriends=function(){
		return $http.get(BASE_URL + "/listOfFriends")
	}
	
	return friendService;
})