package Duke.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Create an event task including its name and time
 * time is represented by a string
 * output a foramted sentence
 * modify its done status to true
 */
public class Event extends Task {
    private String time;

    /**
     * Creat an event task with its name and time
     * @param userInput the command that user input for an event
     */
    public Event(String userInput) {
        String[] sentences=userInput.split(" /at ");
        String pattern = "\\d+-\\d+-\\d+";
        String output="";
        boolean isMatch= Pattern.matches(pattern,sentences[1]);
        if (isMatch) {
            LocalDate d=LocalDate.parse(sentences[1]);
            output=d.format(DateTimeFormatter.ofPattern("MMM dd yyyy").localizedBy(Locale.ENGLISH));
            time=output;
        }
        else {
            time=sentences[1];
        }
        String[] name=sentences[0].split("event ");
        super.modifyName(name[1]);
        System.out.println("\n\tGot it. I've added this task:");
        System.out.println("\t  "+this);
    }

    /**
     * Create a formated string of an event including name, done status and time
     * @return the formated string of an event
     */
    public String toString() {
        if (super.getDone()) {
            return String.format("[E][✓] "+super.getName()+" (at: "+time+")");
        }
        else {
            return String.format("[E][✗] "+super.getName()+" (at: "+time+")");
        }
    }

    /**
     * Mark this event as done
     */
    public void markAsDone() {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }

    /**
     * output a formated sentence of event task for a file
     * @return a formated string of a event task
     */
    public String writeToFile() {
        String done="0";
        if (super.getDone()) {
            done="1";
        }
        String sentence="E | "+done+" | "+super.getName()+" | "+time;
        return sentence;
    }
}
