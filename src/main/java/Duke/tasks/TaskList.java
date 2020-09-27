package Duke.tasks;

import Duke.exceptions.exceedNum;
import Duke.tasks.Deadline;
import Duke.tasks.Event;
import Duke.tasks.Task;
import Duke.tasks.Todo;

/**
 * Stores the task array and the methods related to different kinds of tasks
 */
public class TaskList {
    public int num=0;
    public Task tasks[]=new Task[100];

    /**
     * Create an event task
     * @param answer the user input command including event name and time
     */
    public void processEvent(String answer) {
        try {
            checkSum();
            tasks[num]= new Event(answer);
            num++;
            numList();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n\t☹ OOPS!!! The description of an event cannot be empty.\n");
        }
        catch (exceedNum e) {
            System.out.println("\n\tThe list of tasks is full.\n");
        }
    }

    /**
     * Create a deadline task
     * @param answer the user input command including deadline time and name
     */
    public void processDeadline(String answer) {
        try {
            checkSum();
            tasks[num]= new Deadline(answer);
            num++;
            numList();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n\t☹ OOPS!!! The description of a deadline cannot be empty.\n");
        }
        catch (exceedNum e) {
            System.out.println("\n\tThe list of tasks is full.\n");
        }
    }

    /**
     * Create a todo task
     * @param answer the user input command including todo name
     */
    public void processTodo(String answer) {
        try {
            checkSum();
            tasks[num]= new Todo(answer);
            num++;
            numList();
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n\t☹ OOPS!!! The description of a todo cannot be empty.\n");
        }
        catch (exceedNum e) {
            System.out.println("\n\tThe list of tasks is full.\n");
        }
    }

    /**
     * Delete a particular index of task
     * @param answer the user input command including index
     */
    public void processDelete(String answer){
        try {
            String[] sentences = answer.split("delete ");
            int index = Integer.parseInt(sentences[1]);
            if (index > num){
                System.out.println("\n\tThe index exceed the range of tasks.\n");
                return;
            }
            System.out.println("\n\tNoted. I've removed this task.");
            System.out.println("\t  " + tasks[index - 1]);
            for (int i = index - 1; i < num - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[num - 1] = null;
            System.out.println("\tNow you have " + (num - 1) + " tasks in the list.\n");
            num--;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\n\tPlease enter an index.\n");
        }
        catch (NumberFormatException e){
            System.out.println("\n\tPlease enter a number as index.\n");
        }
    }

    /**
     * print out every tasks in the task array
     */
    public void printList() {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < num; i++) {
            System.out.println("\t" + (i + 1) + "." + tasks[i]);
        }
        System.out.println();
    }

    /**
     * Modify a particular index task's done status to true
     * @param answer the user input command including task's index
     */
    public void processDone(String answer) {
        int index;
        try {
            String[] sentence = answer.split(" ");
            index = Integer.parseInt(sentence[1]);
            tasks[index - 1].markAsDone();
        }
        catch (NullPointerException e) {
            System.out.println("\n\tThis index of task does not exist.\n");
        }
        catch (NumberFormatException e) {
            System.out.println("\n\tPlease enter a number.\n");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\n\tPlease enter the index of the task.\n");
        }
    }

    /**
     * check whether the task list is full
     * @throws exceedNum the task list is full
     */
    public void checkSum() throws exceedNum {
        if (num==100) {
            throw new exceedNum();
        }
    }

    /**
     * print how much tasks are in the list
     */
    public void numList() {
        if (num == 1) {
            System.out.println("\tNow you have " + num + " task in the list.\n");
        }
        else {
            System.out.println("\tNow you have " + num + " tasks in the list.\n");
        }
    }

    /**
     * find the tasks including the key word
     * @param input the key word
     */
    public void find(String input) {
        for (int i=0;i<num;i++) {
            if (tasks[i].getName().contains(input)) {
                System.out.println("\t"+ (i + 1)+"."+tasks[i]);
            }
        }
    }
}
