package recipe.com.example.food;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.tomcat.jni.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import recipe.com.example.food.Service.RecipeService;
import recipe.com.example.food.Service.UserService;
import recipe.com.example.food.entity.Category;
import recipe.com.example.food.entity.recipes;
import recipe.com.example.food.entity.user;
import recipe.com.example.food.repository.RecipeRepository;
import recipe.com.example.food.repository.UserRepository;

@SpringBootTest
public class UserTest {
	
	@MockBean
	UserRepository recipeRepository;
	
	@Autowired
	UserService recipeService;
	private user getUser() {
		user user = new user();
		
		user.setFirstName("Murali");
		user.setLastName("Reddy");
		user.setUserName("Murali123");
		user.setPassword("Murali@123");
		user.setUserId(2);
		
		return user;
		
	}
	
	@Test
	void testAddUser() throws Exception{
		user user = getUser();
		when(recipeRepository.save(user)).thenReturn(user);
		assertEquals(user,recipeService.createUser(user));
	}
	
	 
	@Test
	void GetUser() throws Exception{
		user user = getUser();
		
		String UserName = "Murali123";
		//int Id = 2;
		//Optional<user> user11 = userRepository.findByUserName(user.getUserName());
		when(recipeRepository.findByUserName("Murali123")).thenReturn(Optional.of(user));
		assertEquals(user,recipeService.getUser(user.getUserName()));
	}
	
	@Test
	void DeleteUser() throws Exception{
		user user = getUser();
	    when(recipeRepository.findById(2)).thenReturn(Optional.of(user));
	    recipeService.deleteUser(2);
	    
	}
	
	@Test
	void UpdateUser() throws Exception {
		user user = getUser();
		user.setUserName("Ramesh123");
		when(recipeRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
		//user.setUserName("Ramesh123");
		when(recipeRepository.save(user)).thenReturn(user);
		assertThat(recipeService.updateUser(2, user)).isEqualTo(user);
		
	}
}

