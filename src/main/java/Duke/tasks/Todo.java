package Duke.tasks;

import Duke.tasks.Task;

/**
 * Create a todo task including the task name
 * output a foramted sentence
 * modify its done status to true
 */
public class Todo extends Task {
    /**
     * Create a new todo task
     * @param userInput the user input command including the todo task's name
     */
    public Todo(String userInput) {
        String[] sentence=userInput.split("todo ");
        super.modifyName(sentence[1]);
        System.out.println("\n\tGot it. I've add this task:");
        System.out.println("\t  "+this);
    }

    /**
     * output a formated string of a todo task
     * @return a formated string of todo task
     */
    public String toString() {
        if (super.getDone()) {
            return String.format("[T][✓] "+super.getName());
        }
        else {
            return String.format("[T][✗] "+super.getName());
        }
    }

    /**
     * modify this todo task's done status to true
     */
    public void markAsDone() {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }

    /**
     * output a formated string of a todo task for a file
     * @return a formated string of a todo task
     */
    public String writeToFile() {
        String done="0";
        if (super.getDone()) {
            done="1";
        }
        String sentence="T | "+done+" | "+super.getName();
        return sentence;
    }
}
