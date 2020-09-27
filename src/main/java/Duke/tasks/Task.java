package Duke.tasks;

/**
 * the basics of a task variable including name, done
 * Include some methods to return or modify some elements
 * task name is represented by string
 * task done status is represented by boolean
 */
public class Task {
    private String name;
    private boolean done;

    /**
     * Create a task without task name
     */
    public Task() {
        done=false;
    }

    /**
     * Create a task with task name
     * @param userInput the task name
     */
    public Task(String userInput) {
        name=userInput;
        done=false;
    }

    /**
     * modify the name of a task
     * @param input new name of a task
     */
    public void modifyName(String input) {
        name=input;
    }

    /**
     * change a task's done status to true
     */
    public void markAsDone() {
        done=true;
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.println("\t  [✓] "+name+"\n");
    }

    /**
     * change the done status value
     * @param value the new done status value
     */
    public void setDone(boolean value) {
        done=value;
    }

    /**
     * get the done status value of a task
     * @return the done status value
     */
    public boolean getDone() {
        return done;
    }

    /**
     * get the name of a task
     * @return the name of a task
     */
    public String getName() {
        return name;
    }

    /**
     * output the name of the task
     * @return the name of the task
     */
    public String writeToFile(){
        return name;
    }
}
