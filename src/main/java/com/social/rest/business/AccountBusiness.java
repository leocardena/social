package com.social.rest.business;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.social.domain.Authority;
import com.social.domain.User;
import com.social.repository.AuthorityRepository;
import com.social.repository.UserRepository;
import com.social.rest.dto.UserDTO;
import com.social.rest.exception.EmailAlreadyInUseException;
import com.social.rest.exception.LoginAlreadyInUseException;
import com.social.rest.util.RandomUtil;
import com.social.security.util.AuthoritiesConstants;

@Service
public class AccountBusiness {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User createNewUser(UserDTO userDTO) {
		
		Optional<User> user = userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
		if (user.isPresent()) 
				throw new LoginAlreadyInUseException("O login já está em uso.");
		user = null;
		
		user = userRepository.findOneByEmail(userDTO.getEmail().toLowerCase());
		if (user.isPresent()) 
			throw new EmailAlreadyInUseException("O e-mail já está em uso.");
		user = null;
		
        User newUser = new User();
        Authority authority = authorityRepository.findOne(AuthoritiesConstants.USER.toString());
        Set<Authority> authorities = new HashSet<>();
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        newUser.setLogin(userDTO.getLogin());
        newUser.setPassword(encryptedPassword);
        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setEmail(userDTO.getEmail());
        //newUser.setBirthday(userDTO.getBirthday());
        newUser.setPhone(userDTO.getPhone());
        newUser.setCountry(userDTO.getCountry());
        newUser.setGenre(userDTO.getGenre());
        newUser.setActivated(false);
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        authorities.add(authority);
        newUser.setAuthorities(authorities);
        userRepository.save(newUser);
        return newUser;
		
	}
	

}
