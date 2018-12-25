package utility.filters;

import utility.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "cabinetFilter", urlPatterns = "/cabinet/*")
public class CabinetFilter implements Filter {

    private HttpSession session = null;
    private FilterConfig filterConfig = null;
    private LanguageManager languageManager = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String lang = req.getParameter("lang");
        if (lang == null) {
            session = req.getSession();
            String page = req.getParameter("page");
            session.setAttribute("cabinetPage", page);
            System.out.println("page=" + page);
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
