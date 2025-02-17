import java.util.*;
import java.util.stream.Collectors;


class User {
    private int userId;
    private String name;
    private int age;
    private List<String> favoriteBooks;

    public User(int userId, String name, int age, List<String> favoriteBooks) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.favoriteBooks = favoriteBooks;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteBooks() {
        return favoriteBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", favoriteBooks=" + favoriteBooks +
                '}';
    }
}

    class UserFilter {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User(1, "abhishek", 25, Arrays.asList("Book A", "Book B")),
                new User(2, "samuel", 30, Arrays.asList("Book C", "Book D")),
                new User(3, "abhay", 22, Arrays.asList("Book A", "Book C")),
                new User(4, "aman", 35, Arrays.asList("Book A", "Book D"))
        );

        int ageThreshold = 25;
        String requiredBook = "Book A";

        List<User> filteredUsers = users.stream()
                .filter(user -> user.getAge() > ageThreshold)
                .filter(user -> user.getFavoriteBooks().contains(requiredBook))
                .collect(Collectors.toList());

       
        filteredUsers.forEach(System.out::println);
    }
}
