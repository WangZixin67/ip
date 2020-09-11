import Duke.exceptions.exceedNum;
import Duke.tasks.Deadline;
import Duke.tasks.Event;
import Duke.tasks.Task;
import Duke.tasks.Todo;

import java.util.Scanner;

public class Duke {
    public static void goodbye() {
        System.out.println("\nBye.Hope to see you again soon!");
    }

    public static void greeting() {
    /*String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    System.out.println("Hello from\n" + logo);*/
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
    }

    public static void checkSum(int sum) throws exceedNum {
        if (sum==100){
            throw new exceedNum();
        }
    }

    public static void numList(int sum) {
        if (sum == 1) System.out.println("\tNow you have " + sum + " task in the list.\n");
        else System.out.println("\tNow you have " + sum + " tasks in the list.\n");
    }

    public static void processDone(String answer, Task[] tasks) {
        int index;
        try {
            String[] sentence = answer.split(" ");
            index = Integer.parseInt(sentence[1]);
            tasks[index - 1].markAsDone();
        }
        catch(NullPointerException e){
            System.out.println("\n\tThis index of task does not exist.\n");
        }
        catch(NumberFormatException e){
            System.out.println("\n\tPlease enter a number.\n");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\n\tPlease enter the index of the task.\n");
        }
    }

    public static int processEvent(String answer, Task[] tasks, int sum) {
        try{
            checkSum(sum);
            tasks[sum]=new Event(answer);
            sum++;
            numList(sum);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\n\t☹ OOPS!!! The description of an event cannot be empty.\n");
        }
        catch(exceedNum e){
            System.out.println("\n\tThe list of tasks is full.\n");
        }
        return sum;
    }

    public static int processDeadline(String answer, Task[] tasks, int sum) {
        try{
            checkSum(sum);
            tasks[sum]=new Deadline(answer);
            sum++;
            numList(sum);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\n\t☹ OOPS!!! The description of a deadline cannot be empty.\n");
        }
        catch(exceedNum e){
            System.out.println("\n\tThe list of tasks is full.\n");
        }
        return sum;
    }

    public static int processTodo(String answer, Task[] tasks, int sum) {
        try{
            checkSum(sum);
            tasks[sum]=new Todo(answer);
            sum++;
            numList(sum);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("\n\t☹ OOPS!!! The description of a todo cannot be empty.\n");
        }
        catch(exceedNum e){
            System.out.println("\n\tThe list of tasks is full.\n");
        }
        return sum;
    }

    public static void printList(Task[] tasks, int sum) {
        System.out.println("\tHere are the tasks in your list:");
        for (int i = 0; i< sum; i++) {
            System.out.println("\t" + (i + 1) + "." + tasks[i]);
        }
        System.out.println();
    }

    public static void processDelete(Task[] tasks, String answer, int sum){
        try {
            String[] sentences = answer.split("delete ");
            int index = Integer.parseInt(sentences[1]);
            if (index>sum){
                System.out.println("\n\tThe index exceed the range of tasks.\n");
                return;
            }
            System.out.println("\n\tNoted. I've removed this task.");
            System.out.println("\t  " + tasks[index - 1]);
            for (int i = index - 1; i < sum - 1; i++) {
                tasks[i] = tasks[i + 1];
            }
            tasks[sum - 1] = null;
            System.out.println("\tNow you have " + (sum - 1) + " tasks in the list.\n");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\n\tPlease enter an index.\n");
        }
        catch (NumberFormatException e){
            System.out.println("\n\tPlease enter a number as index.\n");
        }
    }

    public static void main(String[] args) {
        greeting();
        Scanner in=new Scanner(System.in);
        String answer;
        Task[] tasks=new Task[100];
        int sumList=0;
        while(true)
        {
            answer=in.nextLine();
            if (answer.equals("bye")) break;
            else if (answer.equals("list")) {
                printList(tasks, sumList);
            }
            else if (answer.contains("todo")) {
                sumList=processTodo(answer, tasks, sumList);
            }
            else if (answer.contains("deadline")) {
                sumList=processDeadline(answer, tasks, sumList);
            }
            else if (answer.contains("event")) {
                sumList=processEvent(answer, tasks, sumList);
            }
            else if (answer.contains("delete")){
                processDelete(tasks,answer,sumList);
                sumList--;
            }
            else if (answer.contains("done")) {
                processDone(answer, tasks);
            }
            else {
                System.out.println("\n\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
            }
        }
        goodbye();
    }
}
