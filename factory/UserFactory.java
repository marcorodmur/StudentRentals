package factory;

import model.Homeowner;
import model.Student;
import model.User;

/**
 * Factory for creating users.
 */
public class UserFactory {

    public static User createUser(String type, int id, String name) {
        if (type.equalsIgnoreCase("student")) {
            return new Student(id, name);
        } else if (type.equalsIgnoreCase("homeowner")) {
            return new Homeowner(id, name);
        }
        throw new IllegalArgumentException("Unknown user type");
    }
}
