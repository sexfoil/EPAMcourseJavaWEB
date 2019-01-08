package utility.filters;

import utility.tools.LanguageManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "cabinetFilter", urlPatterns = "/cabinet/*")
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

        System.out.println("CABINET FILTER WORKING!!!");

        String display = (String) req.getAttribute("displayMain");
        System.out.println(display);
        System.out.println(req.getAttribute("history"));
        req.setAttribute("displayMain", "WTF???");



        String lang = req.getParameter("lang");
        String page = display == null ? null : req.getParameter("page");

//        if (lang != null) {
//            if (display != null) {
//
//            } else {
//
//            }
//        } else {
//            session = req.getSession();
//
//            session.setAttribute("cabinetPage", page);
//            System.out.println("page=" + page);
//        }
//


        if (lang == null) {
            session = req.getSession();
            session.setAttribute("cabinetPage", page);
            System.out.println("page=" + page);
        }
//        else {
//            req.setAttribute("displayPage", true);
//            System.out.println("disp=" + req.getAttribute("displayPage"));
//        }


        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
