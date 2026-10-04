public class Investigation {
    private static final int MAX_ACCUSATION_ATTEMPTS = 3;
    private static final int CULPRIT_ID = 5;

    private final Suspect[] suspects;
    private int accusationAttempts;
    private boolean solved;

    public Investigation(Suspect[] suspects) {
        this.suspects = suspects;
        this.accusationAttempts = 0;
        this.solved = false;
    }

    public void investigateSuspect(int suspectId) {
        Suspect suspect = Suspect.findById(suspects, suspectId);
        if (suspect == null) {
            System.out.println("No suspect exists with ID " + suspectId + ".");
            return;
        }

        System.out.println("\n--- Selected Suspect ---");
        suspect.displayDetails();
    }

    public boolean accuseSuspect(int suspectId) {
        if (solved || accusationAttempts >= MAX_ACCUSATION_ATTEMPTS) {
            return solved;
        }

        accusationAttempts++;
        System.out.println(
            "\nAccusation attempt " + accusationAttempts + " of " + MAX_ACCUSATION_ATTEMPTS + "."
        );

        Suspect suspect = Suspect.findById(suspects, suspectId);
        if (suspect == null) {
            System.out.println("No suspect exists with ID " + suspectId + ".");
        } else if (suspectId == CULPRIT_ID) {
            solved = true;
            System.out.println("CASE SOLVED!");
            System.out.println("You identified the culprit: " + suspect.getName() + ".");
            System.out.println("The missing question paper has been recovered.");
            return true;
        } else {
            System.out.println("That accusation is incorrect.");
        }

        if (accusationAttempts == MAX_ACCUSATION_ATTEMPTS) {
            System.out.println("INVESTIGATION FAILED!");
            System.out.println("You have used all three attempts. The culprit escaped.");
        } else {
            System.out.println("Accusation attempts remaining: "
                + (MAX_ACCUSATION_ATTEMPTS - accusationAttempts) + ".");
        }
        return false;
    }

    public boolean isSolved() {
        return solved;
    }

    public boolean hasUsedAllAccusationAttempts() {
        return accusationAttempts >= MAX_ACCUSATION_ATTEMPTS;
    }
}
