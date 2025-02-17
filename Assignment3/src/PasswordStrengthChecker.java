import java.util.Scanner;

public class PasswordStrengthChecker {
    public static String checkPasswordStrength(String password) {
        if (password.length() < 8) {
            return "Weak Password";
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        String specialCharacters = "@#$%&*!";

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialCharacters.contains(String.valueOf(ch))) hasSpecial = true;
        }

        if (hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Strong Password";
        } else {
            return "Weak Password";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        System.out.println(checkPasswordStrength(password));
    }
}
