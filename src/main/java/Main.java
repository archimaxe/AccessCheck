import java.util.Scanner;
/*
Функционал программы
+   Создание Scanner для чтения логина и пароля пользователя из консоли;
+    Создание checked исключения UserNotFoundException;
+    Создание checked исключения AccessDeniedException;
+    Выбрасывать ошибку UserNotFoundException, если логин или пароль введены не верно;
+    Выбрасывать ошибку AccessDeniedException, если возраст пользователя меньше 18 лет;
+    Если ошибок не возникло, вывести сообщение "Доступ представлен".
 */

public class Main {
    public static User[] getUsers(){
        User id0 = new User("admin", "qwerty", "admin@mail.ru", 26);
        User hacker = new User("hacker", "123456", "hacker_2010@mail.ru", 11);
        User protect = new User("protect", "1qazaq1", "2010@mail.ru", 14);
        return new User[]{id0, hacker, protect};
    }

    public static void validateUser(User user) throws AccessDeniedException{
        if (user.getAge() < 18){
            throw new AccessDeniedException("Доступ предоставляется от 18 лет!");
        } else {
            System.out.println("Авторизация пройдена успешно!");
        }

//        return;
    }

        public static User getUserByLogoPass(String login, String password) throws UserNotFoundException{
            User[] users = getUsers();
            for (User tmpUser : users){
                if (login.equals(tmpUser.getLogin()) && password.equals(tmpUser.getPassword())){
                    return tmpUser;
                }
//                System.out.println(login.equals(tmpUser.getLogin()));
//                System.out.println(password.equals(tmpUser.getPassword()));
            }
            throw new UserNotFoundException("Неправильный логин или пароль!");
        //        return getUserByLogoPass(login, password);
        }

    public static void main(String[] args) throws AccessDeniedException, UserNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String inputLogin = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String inputPassword = scanner.nextLine();

        User user = getUserByLogoPass(inputLogin, inputPassword);
        validateUser(user);
    }
}
