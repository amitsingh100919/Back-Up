app.controller('FriendCtrl',function($scope,$location,FriendService,$rootScope){
	function getAllSuggestedUsers(){
	FriendService.getSuggestedUsers().then(
			function(response){
				$scope.suggestedUsers=response.data
			},function(response){
				if(response.status==401)
					$location.url("/signin")
			
			})
	}
	function getPendingRequests(){
		FriendService.getPendingRequests().then(function(response){
			$scope.friendRequests=response.data;
		},
		function(response){
			if(response.status==401)
				$location.url("/signin")
		
		})
	}
	$scope.addFriend=function(user){
		FriendService.addFriend(user).then(function(response){
			getAllSuggestedUsers()
		},function(response){
			if(response.status==401)
				$location.url("/signin")
		
		})
	}
	//friendRequest: {'id':754,'fromId':'john.s@xyz.com','toId':'james.s@xyz.com',status:'P'}
	//onclick Accept , status='A'
	//onclick Delete,  status='D'
	//after assignment stat {'id':754,'fromId':'john.s@xyz.com','toId':'james.s@xyz.com',status:'A'}[or 'D']
	$scope.updateFriendRequest=function(friendRequest,status){
		friendRequest.status=status //status is updated in the JSON object [A/D]
		//friendRequest object status is updated to either A or D
		FriendService.updateFriendRequest(friendRequest).then(function(response){
			getPendingRequests()
		},function(response){
			if(response.status==401)
				$location.url("/signin")
		
		})
		
	}
	
	FriendService.listOfFriends().then(function(response){
		$scope.friends=response.data//List of User objects
	},
	function(response){
		if(response.status==401)
			$location.url("/signin")
	
	})
	
	
	getAllSuggestedUsers();
	getPendingRequests();
})