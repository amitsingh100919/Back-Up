package com.amit.cruddemobackend.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amit.cruddemobackend.DAO.FriendDAO;
import com.amit.cruddemobackend.model.Friend;
import com.amit.cruddemobackend.model.User;
@Repository
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUsers(String email) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from user_table where email in (select email from user_table where email!=? minus (select fromId from friend_table where toId=? union select toId from friend_table where fromId=?))");
		sqlQuery.setString(0, email);
		sqlQuery.setString(1, email);
		sqlQuery.setString(2, email);
		sqlQuery.addEntity(User.class);
		List<User> suggestedUsers=sqlQuery.list();
		return suggestedUsers;
	}

	public void addFriendRequest(Friend friend) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(friend);}
			catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	public List<Friend> getAllPendingRequests(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Friend where toId=? and status=?");
		query.setString(0, email);
		query.setCharacter(1, 'P');
		List<Friend> friendRequests=query.list();
		return friendRequests;
	}

	public void updateFriendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A')
			session.update(friend);//update friend set status='A' where id=?
		else
			session.delete(friend);//delete from friend where id=?
		
	}

	public List<User> listOfFriends(String email) {
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=
		session.createSQLQuery("select * from user_table where email in"
				+ "(select fromId from friend_table where toId=? and status='A' "
				+ " union "
				+ "select toId from friend_table where fromId=? and status='A')");
		query.setString(0, email);
		query.setString(1, email);
		query.addEntity(User.class);
		List<User> friends=query.list();
		return friends;
	}

}
