package Duke.tasks;

import Duke.tasks.Task;

public class Todo extends Task {
    public Todo(String userInput) {
        String[] sentence=userInput.split("todo ");
        super.modifyName(sentence[1]);
        System.out.println("\n\tGot it. I've add this task:");
        System.out.println("\t  "+this);
    }

    public String toString() {
        if (super.getDone()) {
            return String.format("[T][✓] "+super.getName());
        }
        else {
            return String.format("[T][✗] "+super.getName());
        }
    }

    public void markAsDone() {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }

    public String writeToFile() {
        String done="0";
        if (super.getDone()) {
            done="1";
        }
        String sentence="T | "+done+" | "+super.getName();
        return sentence;
    }
}
