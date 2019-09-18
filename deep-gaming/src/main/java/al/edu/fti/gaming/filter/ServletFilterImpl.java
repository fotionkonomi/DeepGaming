//package al.edu.fti.gaming.filter;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
//@WebFilter("/*")
//public class ServletFilterImpl implements Filter {
//    private String requestedPath;
//    FilterConfig filterConfig;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
//            throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        
//        HttpServletResponse response = (HttpServletResponse) resp;
//        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        for(SimpleGrantedAuthority authority : user.get) {
//        	
//        }
//        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
//            response.sendRedirect(request.getContextPath() + "/error");
//        } else if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
//            response.sendRedirect(request.getContextPath() + "/error");
//        } else {
//            chain.doFilter(request, response);
//        }
//    }
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//}