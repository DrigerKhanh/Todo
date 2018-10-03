package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SecurityController {

	@Autowired
	private AuthenticationTrustResolver authenticationTrustReslolver;
	
	@GetMapping
	public String index()
	{
		return "redirect:/login";
	}
	
	@GetMapping(value="/login")
	public String login()
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authenticationTrustReslolver.isAnonymous(authentication))
		{
			return "login";
		}
		return "redirect:/todo";
	}
}
