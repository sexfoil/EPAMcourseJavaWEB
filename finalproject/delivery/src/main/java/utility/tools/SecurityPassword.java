package utility.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityPassword {

    public static String getSecurePassword(String pass, String login) {
        return generateSecurePassword(pass, login);
    }

    public static boolean checkPassword(String inputPassword, String login, String pass) {
        return pass.equals(getSecurePassword(inputPassword, login));
    }


    private static String generateSecurePassword(String password, String login) {
        String generatedPassword = null;

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(getSalt(login));
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static byte[] getSalt(String login) {
        return login.getBytes();
    }

}
