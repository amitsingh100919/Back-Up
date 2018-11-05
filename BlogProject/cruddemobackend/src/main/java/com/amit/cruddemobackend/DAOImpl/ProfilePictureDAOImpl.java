package com.amit.cruddemobackend.DAOImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amit.cruddemobackend.DAO.ProfilePictureDAO;
import com.amit.cruddemobackend.model.ProfilePicture;
@Repository
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	 @Autowired
	 private SessionFactory sessionFactory;
	public void upload(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		
	}

	public ProfilePicture getProfilePic(String email) {
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class, email);
		System.out.println("DAO " + email + " " + profilePicture);
		return profilePicture;
	}

}
