public class Suspect {
    private final int id;
    private final String name;
    private final String location;
    private final String alibi;

    public Suspect(int id, String name, String location, String alibi) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.alibi = alibi;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Alibi: " + alibi);
    }

    public static Suspect[] createSuspects() {
        return new Suspect[] {
            new Suspect(1, "Alex", "Computer Lab", "Working on a project"),
            new Suspect(2, "Maya", "Library", "Studying"),
            new Suspect(3, "Rahul", "Staff Room", "Meeting a faculty member"),
            new Suspect(4, "Sara", "Canteen", "Having lunch"),
            new Suspect(5, "Arjun", "Department Office", "Collecting documents")
        };
    }

    public static void displayAll(Suspect[] suspects) {
        System.out.println("\n--- Suspects ---");
        for (Suspect suspect : suspects) {
            System.out.println();
            suspect.displayDetails();
        }
    }

    public static Suspect findById(Suspect[] suspects, int id) {
        for (Suspect suspect : suspects) {
            if (suspect.getId() == id) {
                return suspect;
            }
        }
        return null;
    }
}
