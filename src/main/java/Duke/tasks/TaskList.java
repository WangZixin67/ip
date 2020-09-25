package Duke.tasks;

import Duke.exceptions.exceedNum;
import Duke.tasks.Deadline;
import Duke.tasks.Event;
import Duke.tasks.Task;
import Duke.tasks.Todo;

public class TaskList {
    public int num=0;
    public Task tasks[]=new Task[100];

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

    public void printList() {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i < num; i++) {
            System.out.println("\t" + (i + 1) + "." + tasks[i]);
        }
        System.out.println();
    }

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

    public void checkSum() throws exceedNum {
        if (num==100) {
            throw new exceedNum();
        }
    }

    public void numList() {
        if (num == 1) {
            System.out.println("\tNow you have " + num + " task in the list.\n");
        }
        else {
            System.out.println("\tNow you have " + num + " tasks in the list.\n");
        }
    }
}
