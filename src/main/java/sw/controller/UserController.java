package sw.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sw.interceptor.WebSecurityConfig;
import sw.model.UserModel;
import sw.service.IUserService;
import sw.util.Captcha;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private IUserService UserServiceImpl;
	
	@GetMapping("login")
	public String showHomePage(Model model) {
		model.addAttribute("user", new UserModel());
		return "/RA/login"; // 返回index.html视图
	}
	
	
	@GetMapping("test")
	public String showHomePage() {
		return "/pages/fileUpload"; // 返回index.html视图
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(WebSecurityConfig.SESSION_KEY);
		return "redirect:/login";
	}

	/**
	 * 生成验证码
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/login/captcha.jpg")
	public void captcha(HttpServletResponse response, HttpSession session)
			throws IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		Captcha captcha = new Captcha(100, 30, 4, 5);
		session.setAttribute("captcha", captcha.getCode());
		captcha.write(response.getOutputStream());
	}

	/**
	 * 登陆认证
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return
	 */
	 @PostMapping("/login")
	public ModelAndView login(@ModelAttribute("user") @Valid UserModel user,
			BindingResult bindingResult, Model model, HttpSession session,RedirectAttributes attrs) {

		if (bindingResult.hasErrors()) {
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error.getCode() + "---"
						+ error.getArguments() + "---"
						+ error.getDefaultMessage());
			}
			return new ModelAndView("/RA/login");
		}

		Object captcha = session.getAttribute("captcha");
		if (captcha.toString().equalsIgnoreCase(user.getValicode())) {
			Integer userId = UserServiceImpl.Login(user.getName(),
					user.getPassword());
			if (userId != null) {
				session.setAttribute(WebSecurityConfig.SESSION_KEY, userId);
				return new ModelAndView("/RA/index", "user", user);
			} else {
				model.addAttribute("errorMsg", "用户名或密码错误，请重试！");
			}
		} else {
			model.addAttribute("errorMsg", "验证码出错！");
		}
		return new ModelAndView("/RA/login");
	}

}
