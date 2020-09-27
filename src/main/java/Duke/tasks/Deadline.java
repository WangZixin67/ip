package Duke.tasks;

/**
 * Create a deadline task including the task name and time
 * the time is represented by a string
 * output a foramted sentence
 * modify its done status to true
 */
public class Deadline extends Task {
    private String time;

    /**
     * Set the deadline task name and time
     *
     * @param userInput the whole sentence user input for deadline command
     */
    public Deadline(String userInput){
        String[] sentences=userInput.split(" /by ");
        time=sentences[1];
        String[] name=sentences[0].split("deadline ");

        super.modifyName(name[1]);
        System.out.println("\n\tGot it. I've added this task:");
        System.out.println("\t  "+this);
    }

    /**
     * Create a formated string of deadline
     * @return the formated string of deadline name, done status and time
     */
    public String toString() {
        if (super.getDone()) {
            return String.format("[D][✓] "+super.getName()+" (by: "+time+")");
        }
        else {
            return String.format("[D][✗] "+super.getName()+" (by: "+time+")");
        }
    }

    /**
     * Mark this deadline as done
     */
    public void markAsDone() {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }

    /**
     * output a formated sentence of deadline task for a file
     * @return a formated string of a deadline task
     */
    public String writeToFile() {
        String done="0";
        if (super.getDone()) {
            done="1";
        }
        String sentence="D | "+done+" | "+super.getName()+" | "+time;
        return sentence;
    }
}
