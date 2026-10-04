# Detective Investigation System

A console-based Java application for investigating the disappearance of an examination question paper. It uses five predefined suspects, five clues, and a menu-driven investigation, as described in `tut1.pdf`.

## Requirements

- Java Development Kit (JDK)
- No external libraries
- No interactive input: the activity uses predefined choices instead of `Scanner`

## Compile and run

From this directory, run:

```text
javac Suspect.java ClueManager.java Investigation.java DetectiveGame.java
java DetectiveGame
```

The demonstration lists the suspects, shows valid and invalid suspect lookups, collects clues (including a duplicate collection attempt), displays collected clues, and makes up to three accusations. The culprit is not shown at the start of the investigation.

## Project files

- `Suspect.java` — suspect data, construction, lookup, and display methods
- `ClueManager.java` — clue storage, collection tracking, and clue display
- `Investigation.java` — suspect investigation and accusation logic
- `DetectiveGame.java` — predefined menu flow and application entry point
