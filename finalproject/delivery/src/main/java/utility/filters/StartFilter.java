package utility.filters;

import service.Language;
import utility.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter (filterName = "initFilter", urlPatterns = "/index.jsp")
public class StartFilter implements Filter {

    private HttpSession session = null;
    private FilterConfig filterConfig = null;
    private LanguageManager languageManager = LanguageManager.INSTANCE;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        session = req.getSession();

        if (session.getAttribute("startApp") == null) {
            session.setAttribute("locale", Language.ENG.getLocale());
            session.setAttribute("bundle", languageManager.getResourceBundle().getBaseBundleName());
            session.setAttribute("activeLang", 0);
            session.setAttribute("languageManager", languageManager);

            session.setAttribute("startApp", true);

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
