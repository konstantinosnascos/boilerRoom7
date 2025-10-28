package com.example.menu;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * En hjälpklass för att säkert läsa in användarinput från konsolen.
 * Hanterar automatisk felhantering och validering av inmatning.
 */
public class InputHelper {
    private final Scanner scanner;

    /**
     * Skapar en ny InputHelper med specificerad Scanner.
     *
     * @param scanner Scanner-objektet att använda för inmatning (får inte vara null)
     * @throws IllegalArgumentException om scanner är null
     */
    public InputHelper(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner får inte vara null");
        }
        this.scanner = scanner;
    }

    /**
     * Läser in ett heltal från användaren.
     *
     * @param prompt Meddelande som visas innan inmatning
     * @return Ett giltigt heltal
     */
    public int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                if (scanner.hasNextInt()) {
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Rensa bufferten efter nextInt
                    return value;
                } else {
                    String invalid = scanner.next();
                    System.out.println("Ogiltig inmatning. Ange ett heltal.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Inmatningen avbröts: Ingen mer indata är tillgänglig.");
                throw new RuntimeException("Inmatningsflödet är stängt.", e);
            } catch (IllegalStateException e) {
                System.out.println("Scanner är stängd och kan inte användas.");
                throw new RuntimeException("Scanner-fel.", e);
            }
        }
    }

    /**
     * Läser in ett decimaltal (double) från användaren.
     * Accepterar både punkt och komma som decimaltecken.
     *
     * @param prompt Meddelande som visas innan inmatning
     * @return Ett giltigt decimaltal
     */
    public double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    System.out.println("Inmatningen får inte vara tom. Försök igen.");
                    continue;
                }

                // Ersätt komma med punkt för korrekt parsning
                input = input.replace(',', '.');

                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Ogiltig inmatning. Ange ett tal (t.ex. 10.50 eller 10,50).");
            } catch (NoSuchElementException e) {
                System.out.println("Inmatningen avbröts: Ingen mer indata är tillgänglig.");
                throw new RuntimeException("Inmatningsflödet är stängt.", e);
            } catch (IllegalStateException e) {
                System.out.println("Scanner är stängd och kan inte användas.");
                throw new RuntimeException("Scanner-fel.", e);
            }
        }
    }

    /**
     * Läser in en textsträng från användaren.
     *
     * @param prompt Meddelande som visas innan inmatning
     * @return En icke-tom sträng
     */
    public String getString(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();

                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.out.println("Inmatningen får inte vara tom. Försök igen.");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Inmatningen avbröts: Ingen mer indata är tillgänglig.");
                throw new RuntimeException("Inmatningsflödet är stängt.", e);
            } catch (IllegalStateException e) {
                System.out.println("Scanner är stängd och kan inte användas.");
                throw new RuntimeException("Scanner-fel.", e);
            }
        }
    }

    /**
     * Frågar användaren ja/nej och returnerar ett booleskt värde.
     *
     * @param prompt Fråga att ställa (utan ja/nej-angivelse)
     * @return true om användaren svarar ja (j, ja, y, yes), annars false
     */
    public boolean getYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (j/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("j") || input.equals("ja") || input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("nej") || input.equals("no")) {
                return false;
            } else {
                System.out.println("Ogiltigt svar. Ange 'j' för ja eller 'n' för nej.");
            }
        }
    }
}