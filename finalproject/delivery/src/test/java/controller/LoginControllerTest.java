package controller;

import model.entity.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import service.delivery.ServiceUser;
import service.factory.DeliveryServiceFactory;
import utility.DeliveryNames;
import utility.tools.SecurityPassword;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertTrue;

public class LoginControllerTest extends Mockito {

    String testLogin;
    String testPass;
    User user;

    @Before
    public void inititialize() {
        testLogin = "test";
        testPass = SecurityPassword.getSecurePassword("test", "test");
        ServiceUser serviceUser = (ServiceUser) DeliveryServiceFactory.getInstance().getService(DeliveryNames.USERS);
        user = serviceUser.getUser(testLogin);
    }


    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("password")).thenReturn(testPass);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);

        new LoginController().doPost(request, response);

        assertTrue(request.getAttribute("logInError") == null);
    }
}
