package in.rtms.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rtms.main.dao.UserDao;
import in.rtms.main.dto.UserRequestDTO;
import in.rtms.main.dto.UserResponceDTO;
import in.rtms.main.entities.UserEntity;
import in.rtms.main.exceptionHandlers.BadCredentialsException;
import in.rtms.main.exceptionHandlers.UserNameAllreadyExistException;
import in.rtms.main.exceptionHandlers.UsernameNotFoundException;
import in.rtms.main.translater.UserTranslater;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserTranslater userTranslater;

//  <--------------------------------------------------------------------------------------------------->

	public Boolean checkUserExist(String username) {
		return userDao.userNameAlreadyExist(username);
	}

//  <--------------------------------------------------------------------------------------------------->

	public UserResponceDTO saveUser(UserRequestDTO userRequestDTO) throws UserNameAllreadyExistException {

		UserEntity userEntity = userTranslater.userDtoToEntity(userRequestDTO);

		if (checkUserExist(userEntity.getUsername())) {
			throw new UserNameAllreadyExistException("user with same username allready exist...");
		}
		UserEntity savedUserEntity = userDao.saveUserEntity(userEntity);
		UserResponceDTO userResponceDTO = userTranslater.userEntityToDto(savedUserEntity);

		return userResponceDTO;

	}

//  <--------------------------------------------------------------------------------------------------->

	public UserResponceDTO loginUser(String username, String password) throws UsernameNotFoundException {
		Optional<UserEntity> userOptional = userDao.loginCreater(username);

		UserEntity userEntity = userOptional.orElseThrow(() -> new UsernameNotFoundException("user not found..."));

		if (!userEntity.getPassword().equals(password)) {
			throw new BadCredentialsException("Incorrect password.");
		}
		UserResponceDTO createrResDTO = userTranslater.userEntityToDto(userEntity);

		return createrResDTO;

	}

	
//  <--------------------------------------------------------------------------------------------------->
	
	public List<UserResponceDTO> getAllUsers(){
		
		List<UserEntity> userEntities = userDao.getAllUsers();
		return userTranslater.userListEntityToDto(userEntities);
	}
	
//  <--------------------------------------------------------------------------------------------------->
	
	
}
