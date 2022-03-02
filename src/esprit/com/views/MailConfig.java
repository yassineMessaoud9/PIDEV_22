/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esprit.com.views;

/**
 *
 * @author yassine
 */
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvException;
import java.util.HashMap;

public class MailConfig {

    private static String EMAIL;
    private static String PASSWORD;
    private static String HOST;
    private static String PORT;

    private static MailConfig _instance;

    private static HashMap<String, String> CONFIG;

    private MailConfig() throws DotenvException {

	Dotenv dotenv = Dotenv.configure().load();

	EMAIL = dotenv.get("EMAIL");
	PASSWORD = dotenv.get("PASSWORD");
	HOST = dotenv.get("HOST");
	PORT = dotenv.get("PORT");
    }

    public HashMap<String, String> getConfig() {

	CONFIG = new HashMap<>();

	CONFIG.put("EMAIL", EMAIL);
	CONFIG.put("PWD", PASSWORD);
	CONFIG.put("HOST", HOST);
	CONFIG.put("PORT", PORT);

	return CONFIG;
    }

    public static MailConfig getInstance() {

	if (_instance == null)
	    _instance = new MailConfig();

	return _instance;
    }
}
