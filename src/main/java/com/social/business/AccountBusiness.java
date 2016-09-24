package com.social.business;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.social.domain.Authority;
import com.social.domain.CommentParent;
import com.social.domain.Profile;
import com.social.domain.User;
import com.social.repository.AuthorityRepository;
import com.social.repository.ProfileRepository;
import com.social.repository.UserRepository;
import com.social.security.util.AuthoritiesConstants;
import com.social.security.util.SecurityUtils;
import com.social.web.rest.dto.UserDTO;
import com.social.web.rest.exception.EmailAlreadyInUseException;
import com.social.web.rest.exception.KeyNotFoundException;
import com.social.web.rest.exception.LoginAlreadyInUseException;
import com.social.web.rest.exception.LoginNotFoundException;
import com.social.web.rest.util.RandomUtil;

@Service
public class AccountBusiness {
	
	private final Logger log = LoggerFactory.getLogger(AccountBusiness.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailBusiness mailBusiness;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public User createNewUser(UserDTO userDTO) {
		Optional<User> user = userRepository.findOneByUsername(userDTO.getLogin().toLowerCase());
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
        newUser.setUsername(userDTO.getLogin());
        newUser.setPassword(encryptedPassword);
        newUser.setPhone(userDTO.getPhone());
        newUser.setEmail(userDTO.getEmail());
        newUser.setActivated(false);
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        authorities.add(authority);
        newUser.setAuthorities(authorities);
        
        CommentParent commentParent = new CommentParent();
        
        Profile newProfile = new Profile();
        newProfile.setName(userDTO.getFirstName() + " " + userDTO.getLastName());
        newProfile.setBirthday(userDTO.getBirthday());
        newProfile.setCountry(userDTO.getCountry());
        newProfile.setGenre(userDTO.getGenre());
        newProfile.setUser(newUser);
        newProfile.setCommentParent(commentParent);
        
        profileRepository.save(newProfile);
		mailBusiness.sendActivationEmail(newUser , "http://localhost:8080");
		
		log.debug("Novo Profile criado: {}", newProfile);
		
        return newUser;
		
	}
	
    public User activateRegistration(String key) {
        Optional<User> userOptional = userRepository.findOneByActivationKey(key);
        if (!userOptional.isPresent())
        	throw new KeyNotFoundException("A chave de ativação não é válida");
        User user = userOptional.get();
        user.setActivated(true);
        user.setActivationKey(null);
        userRepository.save(user);
        log.debug("Ativação de conta efetuada para o usuário: {}", user);
        return user;
    }

	public UserDTO getUserWithAuthorities() {
		Optional<User> userOptional = userRepository.findOneByUsername(SecurityUtils.getCurrentUserLogin());
		if (!userOptional.isPresent())
			throw new LoginNotFoundException("Login não encontrado");
		User user = userOptional.get();
		user.getAuthorities().size(); 
		// eagerly load the association
		Optional<Profile> profileOptional = profileRepository.findOneByUser(user);
		if (!profileOptional.isPresent())
			throw new LoginNotFoundException("Profile não encontrado");
		Profile profile = profileOptional.get();
        log.debug("User with Authorities pesquisado, profile: {}", profile);
        return new UserDTO(profile);
	}
	
}
