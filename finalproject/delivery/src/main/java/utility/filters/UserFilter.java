package utility.filters;

import model.entity.user.User;
import service.delivery.ServiceInvoice;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.tools.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "userFilter", urlPatterns = "/*")
public class UserFilter implements Filter {

    private HttpSession session = null;
    private FilterConfig filterConfig = null;
    //private LanguageManager languageManager = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null && session.getAttribute("updateInvoices") != null) {
            ServiceInvoice serviceInvoice = (ServiceInvoice) DeliveryServiceFactory.getInstance()
                    .getService(DeliveryNames.INVOICES);
            int active = serviceInvoice.getAmountInvoicesByStatus(user.getId(), 1);
            session.setAttribute("activeInvoiceAmount", active);
            session.setAttribute("updateInvoices", null);
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
