import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_-+=<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        System.out.print("Include uppercase letters? (Y/N): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include lowercase letters? (Y/N): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include numbers? (Y/N): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("Y");

        System.out.print("Include symbols? (Y/N): ");
        boolean includeSymbols = scanner.next().equalsIgnoreCase("Y");

        String generatedPassword = generatePassword(length, includeUppercase, includeLowercase, includeNumbers, includeSymbols);
        System.out.println("Generated Password: " + generatedPassword);
    }

    public static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSymbols) {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();

        String characters = "";
        if (includeUppercase) {
            characters += UPPERCASE;
        }
        if (includeLowercase) {
            characters += LOWERCASE;
        }
        if (includeNumbers) {
            characters += NUMBERS;
        }
        if (includeSymbols) {
            characters += SYMBOLS;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
