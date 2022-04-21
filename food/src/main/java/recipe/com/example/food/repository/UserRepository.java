package recipe.com.example.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import recipe.com.example.food.entity.user;


@Repository
public interface UserRepository extends JpaRepository<user,Integer>  {

	public Optional<user> findByUserName(String userName);

	
	
	

}
