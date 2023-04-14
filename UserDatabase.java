import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, User> users;

    static {
        // Initialize the user database with some example users
        users = new HashMap<>();
        users.put("admin", new User("admin", "admin123", true));
        users.put("customer", new User("customer", "customer", false));
    }

    /**
     * Checks if a user exists with the given username and password.
     *
     * @param username The username to check.
     * @param password The password to check.
     * @return True if a user exists with the given credentials, false otherwise.
     */
    public static boolean userExists(String username, String password) {
        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    /**
     * Checks if a user with the given username is an admin.
     *
     * @param username The username to check.
     * @return True if the user is an admin, false otherwise.
     */
    public static boolean isAdmin(String username) {
        User user = users.get(username);

        if (user != null && user.isAdmin()) {
            return true;
        }

        return false;
    }
}
