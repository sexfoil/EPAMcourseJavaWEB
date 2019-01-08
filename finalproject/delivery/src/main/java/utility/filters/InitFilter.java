package utility.filters;

import model.entity.CargoType;
import model.entity.Status;
import model.entity.Street;
import service.Language;
import service.delivery.ServiceCargoTypes;
import service.delivery.ServiceInvoice;
import service.delivery.ServiceStatus;
import service.delivery.ServiceStreet;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.tools.LanguageManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebFilter (filterName = "initFilter", urlPatterns = "/*")
public class InitFilter implements Filter {

    HttpSession session = null;
    ResourceBundle resource = null;
    private LanguageManager languageManager = LanguageManager.INSTANCE;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        initApplicationVariables(request);
        initSessionVariables(request);

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }

    private void initSessionVariables(HttpServletRequest request) {

        session = request.getSession();
        resource = ResourceBundle.getBundle("property.application.config");

        if (session.getAttribute("startSession") == null) {

            initLanguage();
            initPriceParams();
            initCargoParams();
            initStreetParams();
            initInvoicesParams();
            session.setAttribute("rowOnPage", getMaxRows());

            session.setAttribute("startSession", true);

        }

    }

    private void initApplicationVariables(HttpServletRequest request) {
        if (request.getServletContext().getAttribute("usersPool") == null) {
            Set<String> loginSet = new HashSet<>();
            request.getServletContext().setAttribute("usersPool", loginSet);
        }
    }

    private int getMaxRows() {
        return Integer.valueOf(resource.getString("pagination_step"));
    }

    private void initInvoicesParams() {
        ServiceStatus serviceStatus = (ServiceStatus) DeliveryServiceFactory.getInstance()
                .getService(DeliveryNames.STATUS);
        List<Status> statuses = serviceStatus.getAllStatuses();
        session.setAttribute("deliveryStatuses", statuses);

        session.setAttribute("activeInvoiceAmount", 0);
    }

    private void initPriceParams() {
        double priceRate = Double.valueOf(resource.getString("current_price_rate"));
        session.setAttribute("currentPriceRate", priceRate);
    }

    private void initCargoParams() {
        ServiceCargoTypes service =
                (ServiceCargoTypes) DeliveryServiceFactory.getInstance().getService(DeliveryNames.CARGO_TYPES);
        List<CargoType> types = service.getAllCargoTypes();
        session.setAttribute("cargoTypes", types);
    }

    private void initStreetParams() {
        ServiceStreet service = (ServiceStreet) DeliveryServiceFactory.getInstance().getService(DeliveryNames.STREETS);
        List<Street> streets = service.getAllStreetNames();
        session.setAttribute("streetsList", streets);
        session.setAttribute("streetsListSize", streets.size());
    }

    private void initLanguage() {
        session.setAttribute("languageManager", languageManager);
        session.setAttribute("locale", Language.ENG.getLocale());
        session.setAttribute("bundle", languageManager.getResourceBundle().getBaseBundleName());
        session.setAttribute("activeLang", 0);
    }
}
