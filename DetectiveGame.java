public class DetectiveGame {
    private static final int[] DEMO_MENU_CHOICES = {1, 2, 2, 3, 3, 3, 4, 5, 5, 5};
    private static final int[] DEMO_SUSPECT_IDS = {99, 4};
    private static final int[] DEMO_CLUE_NUMBERS = {1, 1, 2};
    private static final int[] DEMO_ACCUSATION_IDS = {2, 3, 5};

    private DetectiveGame() {
    }

    public static void main(String[] args) {
        Suspect[] suspects = Suspect.createSuspects();
        ClueManager clueManager = new ClueManager();
        Investigation investigation = new Investigation(suspects);
        int suspectIndex = 0;
        int clueIndex = 0;
        int accusationIndex = 0;

        System.out.println("DETECTIVE INVESTIGATION");
        System.out.println("An examination question paper has disappeared.");
        System.out.println("The culprit will not be revealed unless an accusation is correct.");

        int choiceIndex = 0;
        while (!investigation.isSolved()
                && !investigation.hasUsedAllAccusationAttempts()
                && choiceIndex < DEMO_MENU_CHOICES.length) {
            displayMenu();
            int choice = DEMO_MENU_CHOICES[choiceIndex++];
            System.out.println("Predefined menu choice: " + choice);

            switch (choice) {
                case 1:
                    Suspect.displayAll(suspects);
                    break;
                case 2:
                    investigation.investigateSuspect(DEMO_SUSPECT_IDS[suspectIndex++]);
                    break;
                case 3:
                    clueManager.displayAvailableClues();
                    clueManager.collectClue(DEMO_CLUE_NUMBERS[clueIndex++]);
                    break;
                case 4:
                    clueManager.displayCollectedClues();
                    break;
                case 5:
                    investigation.accuseSuspect(DEMO_ACCUSATION_IDS[accusationIndex++]);
                    break;
                case 6:
                    System.out.println("The investigation has ended.");
                    return;
                default:
                    System.out.println("Invalid menu option: " + choice + ".");
                    break;
            }
        }

        if (!investigation.isSolved() && !investigation.hasUsedAllAccusationAttempts()) {
            System.out.println("\nThe predefined investigation choices are complete.");
        }
    }

    private static void displayMenu() {
        System.out.println("\n==============================");
        System.out.println("      DETECTIVE INVESTIGATION");
        System.out.println("==============================");
        System.out.println("1. View Suspects");
        System.out.println("2. Investigate Suspect");
        System.out.println("3. Collect Clue");
        System.out.println("4. View Collected Clues");
        System.out.println("5. Accuse Suspect");
        System.out.println("6. Exit");
    }
}
