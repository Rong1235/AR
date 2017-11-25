package sw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.UserDao;
import sw.entity.User;
import sw.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Integer Login(String name, String password) {
		 List<User> userList = userDao.findByNameAndPassword(name, password);
		 if(null == userList || userList.size()==0)	
			 return null;
		 return userList.get(0).getId();
	}

}
