package sw.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import sw.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {  
	  
	 //jpa 方法名就是查询语句,只要规法写方法名一切就都可以完成(当然.有时候会造成方法名又臭又长) 
	  User findByEmail(String email);//根据邮箱查询 
	  List<User> findByName(String name);//根据用户名查询 
	  
	  List<User> findByNameAndPassword(String name,String password);
	    
	  //select * from test.users where email='imgod@qq.com' and name='imgod'; 
	  List<User> findByNameAndEmail(String name,String email);//根据用户名和邮箱进行查询 
	    
	  //select * from test.users where email='imgod@qq.com' and name='imgod4444' order by id desc; 
	  List<User> findByNameAndEmailOrderByIdDesc(String name,String email);//根据用户名和邮箱进行查询,排序 
	    
	  //select * from test.users where email='imgod@qq.com' and name='imgod4444' order by id desc limit 2; 
	  List<User> findTop2ByNameAndEmailOrderByIdDesc(String name,String email);//根据用户名和邮箱进行查询,排序,前两个 
	  
	  //根据邮箱进行分页查询 
	  List<User> findByEmail(String email,Pageable pageable);//根据用户名和邮箱进行查询 

}
