package utility;

public enum Pages {
    CABINET_HISTORY_JSP("cabhistorypage.jsp"),
    CABINET_SETTINGS_JSP("cabsettingspage.jsp"),
    CABINET_JSP("cabinetpage.jsp"),
    CALCULATOR_JSP("calculpage.jsp"),
    INFO_JSP("infopage.jsp"),
    LOGIN_JSP("loginpage.jsp"),
    ORDER_JSP("orderpage.jsp"),
    REGISTER_JSP("registerpage.jsp");

    private String url;
    private String path = "/WEB-INF/jsp/";

    Pages(String pageName) {
        url = path + pageName;
    }

    public String getUrl() {
        return url;
    }

}
