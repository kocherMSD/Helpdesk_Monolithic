package org.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.helpdesk.db.dao.AuthenticateDao;
import org.helpdesk.webservice.support.AuthorizationServiceHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rst.oauth2.google.security.GoogleProfile;

@Controller
@Component
public class MainController {

	 private static Logger LOGGER = LoggerFactory.getLogger(MainController.class);
	    private static ObjectMapper OM = new ObjectMapper();
	    @Autowired
	    private HttpServletRequest context;
	    @Autowired
	    private AuthenticateDao authenticateDao;
	// @Autowired private OAuth2RestOperations oauth2RestTemplate;
	// @Autowired private OAuth2ProtectedResourceDetails oAuth2ProtectedResourceDetails;

	@RequestMapping(value = "/*admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

	  ModelAndView model = new ModelAndView();
	  model.addObject("title", "Spring Security Login Form - Database Authentication");
	  model.addObject("message", "This page is for ROLE_ADMIN only!");
	  model.setViewName("admin");
	  return model;

	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView defaultURL(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		GoogleProfile profile = getGoogleProfile();
		
      profile.getEmail();
      ModelAndView model=null;
      if(profile.getVerifiedEmail())
  	     model = new ModelAndView("landing","user", profile.getEmail());
      else
         model = new ModelAndView("login","user", profile.getEmail());
  
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	 ///model.setView(model.getView());

	  return model;

	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLogin(Model model, LoginForm loginform) {
		//logger.info("Login page");
		if (!model.containsAttribute("error")) {
			model.addAttribute("error", false);
		}
		model.addAttribute("loginAttribute", loginform);
		return "login";
	}
	
	/**
	 * The POST method to submit login credentials.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, LoginForm loginform, Locale locale, HttpServletRequest request) throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,locale);
		String formattedDate = dateFormat.format(date);
		
		String username = loginform.getUsername();
		String password = loginform.getPassword();
	
		
		//logger.info("Login attempt for username "+ username+" at: "+formattedDate);
		
		// A simple authentication manager
		if(username != null && password != null){
			
			if( username.equals("pkocher") &&	password.equals(authenticateDao.getPassword(username)) ){
				// Set a session attribute to check authentication then redirect to the welcome uri; 
				request.getSession().setAttribute("LOGGEDIN_USER", loginform);
				request.getSession().setAttribute("ACCESS_LEVEL", authenticateDao.getAccessLevel(username));

				return "redirect:/landing";
			}else{
				return "redirect:/login.failed";
			}
		}else{
			return "redirect:/login.failed";
		}
	}
		
	/**
	 * The login failed controller
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login.failed", method = RequestMethod.GET)
	public String loginFailed(Model model, LoginForm loginForm) {
		//logger.debug("Showing the login failed page");
		model.addAttribute("error", true);
		model.addAttribute("loginAttribute", loginForm);
		return "login";
	}


/*	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		GoogleProfile profile = getGoogleProfile();
		
      profile.getEmail();
  	  ModelAndView model = new ModelAndView("landing","user", profile.getEmail());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	//  model.setViewName("createCase");

	  return model;

	}*/
	
	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public ModelAndView landing(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
	//	GoogleProfile profile =getExpGoogleProfile();
	  ModelAndView model = new ModelAndView("landing","user", "pkocher");
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	//  model.setViewName("login");

	  return model;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
	  ModelAndView model = new ModelAndView("login","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("login");

	  return model;

	}
	
	@RequestMapping(value = "/createCase", method = RequestMethod.GET)
	public ModelAndView createCase(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
	  ModelAndView model = new ModelAndView("createCase","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("createCase");

	  return model;

	}
	
	@RequestMapping(value = "/createCaseOr", method = RequestMethod.GET)
	public ModelAndView createCaseOr(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");

	  ModelAndView model = new ModelAndView("createCase","user", "pkocher");
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("createCase");

	  return model;

	}
	
	
	
	@RequestMapping(value = "/viewAllCase", method = RequestMethod.GET)
	public ModelAndView viewCase(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
		
	  ModelAndView model = new ModelAndView("viewAllCase","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("viewAllCase");

	  return model;

	}
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
		
	  ModelAndView model = new ModelAndView("view","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("view");

	  return model;

	}
	
	
	@RequestMapping(value = "/takeAppointment", method = RequestMethod.GET)
	public ModelAndView takeAppointment(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");

	  ModelAndView model = new ModelAndView("takeAppointment","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("takeAppointment");

	  return model;

	}
	
	
	@RequestMapping(value = "/notesAll", method = RequestMethod.GET)
	public ModelAndView notes(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");

	  ModelAndView model = new ModelAndView("notesAll","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("notesAll");

	  return model;

	}
	
	
	@RequestMapping(value = "/appointment", method = RequestMethod.GET)
	public ModelAndView appointment(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");

	  ModelAndView model = new ModelAndView("appointment","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("appointment");

	  return model;

	}
	
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
		
    
	  ModelAndView model = new ModelAndView("profile","user", userData.getUsername());
	  
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("profile");

	  return model;

	}
	
	@RequestMapping(value = "/productcatalogue", method = RequestMethod.GET)
	public ModelAndView productcatalogue(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
	
	 LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
	  ModelAndView model = new ModelAndView("productcatalogue","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("productcatalogue");

	  return model;

	}
	
	@RequestMapping(value = "/productcatalogueAdmin", method = RequestMethod.GET)
	public ModelAndView ProductcatalogueAdmin(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
	LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
	userData.getUsername();
	  ModelAndView model = new ModelAndView("productcatalogueAdmin","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("productcatalogueAdmin");

	  return model;

	}
	
	
	@RequestMapping(value = "/messageboard", method = RequestMethod.GET)
	public ModelAndView messageboard(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
			
	  ModelAndView model = new ModelAndView("messageboard","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("messageboard");

	  return model;

	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
			
	  ModelAndView model = new ModelAndView("search","user", userData.getUsername());
	  if (error != null) {
		model.addObject("error", "Invalid username and password!");
	  }

	  if (logout != null) {
		model.addObject("msg", "You've been logged out successfully.");
	  }
	  model.setViewName("search");

	  return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		LoginForm userData = (LoginForm) context.getSession().getAttribute("LOGGEDIN_USER");
		
	  ModelAndView model = new ModelAndView("403","user", userData.getUsername());
		
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addObject("username", userDetail.getUsername());
	  }
		
	  model.setViewName("403");
	  return model;

	}
	
	
	 
	
}