package org.nhom1.agilecarrentall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class AdminDataInterceptor implements HandlerInterceptor {

//	private final SystemOptionService systemOptionService;
	private final ApplicationStartupRunner applicationStartupRunner;

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		if (authentication.getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals(MemberRole.ROLE_ADMIN.toString()) ||
//				auth.getAuthority().equals(MemberRole.ROLE_OWNER.toString()))) {
//			List<SystemOption> allOptions = systemOptionService.getAllSystemOption();
//			Map<String, String> optionMap = new HashMap<>();
//			allOptions.forEach(option -> optionMap.put(option.getOptionkey(), option.getOptionValue()));
//			modelAndView.addObject("options", optionMap);
//		}
//	}
}
