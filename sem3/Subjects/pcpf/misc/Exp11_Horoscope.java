import java.util.Scanner;
import java.time.LocalDate;

public class Horoscope {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get the user's birthday
    System.out.print("Enter your birth date (DD/MM/YYYY): ");
    String birthdayStr = input.nextLine();

    // Convert the birthday string to a LocalDate object
    LocalDate birthday = LocalDate.parse(birthdayStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    // Get the user's horoscope
    String horoscope = getHoroscope(birthday);

    // Print the horoscope
    System.out.println("Your horoscope is: " + horoscope);
  }

  public static String getHoroscope(LocalDate birthday) {
    // Determine the user's zodiac sign based on their birthday
    if (birthday.getMonthValue() == 1 && birthday.getDayOfMonth() >= 20 || birthday.getMonthValue() == 2 && birthday.getDayOfMonth() <= 18) {
      return "Aquarius";
    } else if (birthday.getMonthValue() == 2 && birthday.getDayOfMonth() >= 19 || birthday.getMonthValue() == 3 && birthday.getDayOfMonth() <= 20) {
      return "Pisces";
    } else if (birthday.getMonthValue() == 3 && birthday.getDayOfMonth() >= 21 || birthday.getMonthValue() == 4 && birthday.getDayOfMonth() <= 19) {
      return "Aries";
    } else if (birthday.getMonthValue() == 4 && birthday.getDayOfMonth() >= 20 || birthday.getMonthValue() == 5 && birthday.getDayOfMonth() <= 20) {
      return "Taurus";
    } else if (birthday.getMonthValue() == 5 && birthday.getDayOfMonth() >= 21 || birthday.getMonthValue() == 6 && birthday.getDayOfMonth() <= 20) {
      return "Gemini";
    } else if (birthday.getMonthValue() == 6 && birthday.getDayOfMonth() >= 21 || birthday.getMonthValue() == 7 && birthday.getDayOfMonth() <= 22) {
      return "Cancer";
    } else if (birthday.getMonthValue() == 7 && birthday.getDayOfMonth() >= 23 || birthday.getMonthValue() == 8 && birthday.getDayOfMonth() <= 22) {
      return "Leo";
    } else if (birthday.getMonthValue() == 8 && birthday.getDayOfMonth() >= 23 || birthday.getMonthValue() == 9 && birthday.getDayOfMonth() <= 22) {
      return "Virgo";
    } else if (birthday.getMonthValue() == 9 && birthday.getDayOfMonth() >= 23 || birthday.getMonthValue() == 10 && birthday.getDayOfMonth() <= 22) {
      return "Libra";
    } else if (birthday.getMonthValue() == 10 && birthday.getDayOfMonth() >= 23 || birthday.getMonthValue() == 11 && birthday.getDayOfMonth() <= 21) {
      return "Scorpio";
    } else if (birthday.getMonthValue() == 11 && birthday.getDayOfMonth() >= 22 || birthday.getMonthValue() == 12 && birthday.getDayOfMonth() <= 21) {
      return "Sagittarius";
    } else if (birthday.getMonthValue() == 12 && birthday.getDayOfMonth() >= 22 || birthday.getMonthValue() == 1 && birthday.getDayOfMonth() <= 19) {
      return "Capricorn";
    } else {
      return "Invalid birth date";
    }
  }
}

