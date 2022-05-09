package recipe.com.example.food.Service.Simpl;

import java.util.Optional;
import java.util.Set;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Override
	public user createUser(user user) throws Exception {
		Optional<user> optional = userRepository.findByUserName(user.getUserName());
		if(optional.isPresent()) {
			throw new Exception("User is Alredy present in database");
		}
		else {
		  //  user user1 = optional.get();
		    userRepository.save(user);}
		return user;
		
		
	}

	@Override
	public user getUser(String userName) throws Exception {
		Optional<user> optional = userRepository.findByUserName(userName);
		if(optional.isEmpty()) {
			throw new Exception("User not exists");
		}
		
		user user2 = optional.get();
		
		return user2;
	}

	@Override
	public user deleteUser(Integer userId) {
		Optional<user> optional = userRepository.findById(userId);
		user user = optional.get();
		userRepository.delete(optional.get());
		return user;
	}

	@Override
	public user updateUser(Integer userId, user user ) throws Exception{

	Optional<user> optional = userRepository.findById(userId);
	if(optional.isPresent()) {
	user temp = optional.get();
	temp.setFirstName(user.getFirstName());
	temp.setLastName(user.getLastName());
	temp.setUserName(user.getUserName());
	temp.setRole(user.getRole());
	temp.setPassword(user.getPassword());

	userRepository.save(temp);
	}
	return user;
	}


}
