app.controller('homeCtrl',function($rootScope,$scope,$http,$location){
	console.log("in home ctrl")
		$http.get("http://localhost:8081/blogmiddleware/getNotification").then(function(response){
			$rootScope.notifications = response.data
			$rootScope.notificationCount = $rootScope.notifications.length
			console.log(response.data)
		},function(response){
			if(response.status==401)
				$location.url("/signin")
		}
		)
	
})