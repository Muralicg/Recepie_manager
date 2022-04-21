package recipe.com.example.food.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import recipe.com.example.food.entity.user;

@Service
public interface UserService {
	
	public user createUser(user user) throws Exception;
	
	public user getUser(String userName) throws Exception;

	public user deleteUser(Integer userId);

}
