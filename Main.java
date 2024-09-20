import java.util.ArrayList;
import java.util.List;

class User {
    private String name;
    private String email;
    private String role;

    public User(String name, String email, String role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(String name, String email, String role) {
        User user = new User(name, email, role);
        users.add(user);
    }

    public void removeUser(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }

    public void updateUser(String email, String newName, String newRole) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                user.setName(newName);
                user.setRole(newRole);
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}

public class Main {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.addUser("Иван Иванов", "ivan@example.com", "Администратор");
        userManager.addUser("Мария Петрова", "maria@example.com", "Пользователь");

        System.out.println("Список пользователей:");
        for (User user : userManager.getUsers()) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail() + ", Роль: " + user.getRole());
        }

        userManager.updateUser("ivan@example.com", "Иван Сидоров", "Пользователь");

        System.out.println("После обновления:");
        for (User user : userManager.getUsers()) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail() + ", Роль: " + user.getRole());
        }

        userManager.removeUser("maria@example.com");

        System.out.println("После удаления:");
        for (User user : userManager.getUsers()) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail() + ", Роль: " + user.getRole());
        }
    }
}
