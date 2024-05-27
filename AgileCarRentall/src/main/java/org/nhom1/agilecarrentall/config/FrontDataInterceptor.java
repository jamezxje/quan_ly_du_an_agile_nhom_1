package org.nhom1.agilecarrentall.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class FrontDataInterceptor implements HandlerInterceptor {
	private final ApplicationStartupRunner applicationStartupRunner;
//	private final CommonDataService commonDataService;

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//		if (modelAndView != null && !request.getRequestURI().startsWith("/dashboard/")) {
//
//			List<BrandItemResponseDTO> brands = commonDataService.getBrands();
//
//			modelAndView.addObject("brands", brands);
//			modelAndView.addObject("options", applicationStartupRunner.getOptionMap());
//		}
//	}
}
