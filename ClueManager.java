public class ClueManager {
    private final String[] clues = {
        "The office door was opened at 2:15 PM.",
        "CCTV shows someone entering the office.",
        "A torn piece of paper was found near the printer.",
        "A suspect's ID card was found inside the office.",
        "The printer was used shortly before the question paper disappeared."
    };
    private final boolean[] collected = new boolean[clues.length];

    public void displayAvailableClues() {
        System.out.println("\n--- Available Clues ---");
        for (int i = 0; i < clues.length; i++) {
            String status = collected[i] ? " (collected)" : "";
            System.out.println((i + 1) + ". " + clues[i] + status);
        }
    }

    public void collectClue(int clueNumber) {
        if (clueNumber < 1 || clueNumber > clues.length) {
            System.out.println("No clue exists with number " + clueNumber + ".");
            return;
        }

        int index = clueNumber - 1;
        if (collected[index]) {
            System.out.println("Clue " + clueNumber + " has already been collected.");
            return;
        }

        collected[index] = true;
        System.out.println("Clue collected: " + clues[index]);
    }

    public void displayCollectedClues() {
        System.out.println("\n--- Collected Clues ---");
        boolean foundClue = false;
        for (int i = 0; i < clues.length; i++) {
            if (collected[i]) {
                System.out.println((i + 1) + ". " + clues[i]);
                foundClue = true;
            }
        }

        if (!foundClue) {
            System.out.println("No clues have been collected yet.");
        }
    }
}
