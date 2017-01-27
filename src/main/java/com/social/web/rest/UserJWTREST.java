package com.social.web.rest;

import com.social.security.jwt.JWTConfigurer;
import com.social.security.jwt.TokenProvider;
import com.social.web.rest.dto.JWTToken;
import com.social.web.rest.util.APIEndpoint;
import com.social.web.rest.vm.LoginVM;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Camada REST responsável por expor os serviços do recurso User
 * 
 * @author Leonardo Cardena
 *
 */
@RestController
@RequestMapping(value = APIEndpoint.BASE)
public class UserJWTREST {

	@Inject
	private TokenProvider tokenProvider;

	@Inject
	private AuthenticationManager authenticationManager;

	/**
	 * @param loginVM
	 *            objeto com as credenciais do usuário que serão recebidas no
	 *            body da request
	 * @param response
	 *            response que será enviada ao cliente
	 * @return o token do usuário
	 */
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> authorize(@Valid @RequestBody LoginVM loginVM, HttpServletResponse response) {

		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginVM.getUsername(), loginVM.getPassword());

		try {
			Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
			String jwt = tokenProvider.createToken(authentication, rememberMe);
			response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
			return ResponseEntity.ok(new JWTToken(jwt));
		} catch (AuthenticationException exception) {
			return new ResponseEntity<>(
					Collections.singletonMap("AuthenticationException", exception.getLocalizedMessage()),
					HttpStatus.UNAUTHORIZED);
		}
	}
}
