package utility.filters;

import service.Language;
import utility.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

@WebFilter (filterName = "initFilter", urlPatterns = "/*")
public class InitFilter implements Filter {

    //private FilterConfig filterConfig = null;
    private LanguageManager languageManager = LanguageManager.INSTANCE;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        initApplicationVariables(request);
        initSessionVariables(request);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

    private void initSessionVariables(HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("startSession") == null) {
            session.setAttribute("locale", Language.ENG.getLocale());
            session.setAttribute("bundle", languageManager.getResourceBundle().getBaseBundleName());
            session.setAttribute("activeLang", 0);
            session.setAttribute("languageManager", languageManager);
            session.setAttribute("rowOnPage", getMaxRows());

            session.setAttribute("startSession", true);
        }

    }

    private void initApplicationVariables(HttpServletRequest request) {
        if (request.getServletContext().getAttribute("usersPool") == null) {
            Set<String> loginSet = new HashSet<>();
            //loginSet.add("slaventiy");
            request.getServletContext().setAttribute("usersPool", loginSet);
        }
    }

    private int getMaxRows() {
        ResourceBundle resource = ResourceBundle.getBundle("property.application.config");
        return Integer.valueOf(resource.getString("pagination_step"));
    }
}
