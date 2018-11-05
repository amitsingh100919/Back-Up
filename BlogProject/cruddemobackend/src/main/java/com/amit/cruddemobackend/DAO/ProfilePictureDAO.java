package com.amit.cruddemobackend.DAO;

import com.amit.cruddemobackend.model.ProfilePicture;

public interface ProfilePictureDAO {

	void upload(ProfilePicture profilePicture);
	ProfilePicture getProfilePic(String email);
}
