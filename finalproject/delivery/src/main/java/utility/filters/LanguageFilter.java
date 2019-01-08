package utility.filters;

import service.Language;
import utility.tools.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "languageFilter", urlPatterns = "/*")
public class LanguageFilter implements Filter {

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

        session = req.getSession();
        String lang = req.getParameter("lang");

        if (lang != null) {
            languageManager = (LanguageManager) session.getAttribute("languageManager");
            Locale locale;
            switch (lang) {
                case "0":
                    session.setAttribute("activeLang", 0);
                    locale = Language.values()[0].getLocale();
                    break;
                case "1":
                    session.setAttribute("activeLang", 1);
                    locale = Language.values()[1].getLocale();
                    break;
                case "2":
                    session.setAttribute("activeLang", 2);
                    locale = Language.values()[2].getLocale();
                    break;
                default:
                    locale = Language.ENG.getLocale();
            }

            languageManager.changeLocale(locale);
            session.setAttribute("locale", locale);
            session.setAttribute("bundle", languageManager.getResourceBundle().getBaseBundleName());

            //LanguageManager.INSTANCE.changeLocale((Locale) session.getAttribute("locale"));

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

}
