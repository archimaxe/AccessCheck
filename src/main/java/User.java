public class User {
    private String login;
    private String password;
    public String email;
    private int age;

    public User(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Пользователь: {" +
                "login = '" + login + '\'' +
                ", email = '" + email + '\'' +
                ", age = " + age +
                '}';
    }
}
