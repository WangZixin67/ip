import java.util.Scanner;


public class Duke {
    public static void goodbye()
    {
        System.out.println("\nBye.Hope to see you again soon!");
    }

    public static void echo(String content)
    {
        System.out.println(content+"\n");
    }

    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        Scanner in=new Scanner(System.in);
        String answer;
        Task[] tasks=new Task[100];
        int sum=0;
        Task list=new Task();
        while(true)
        {
            answer=in.nextLine();
            if (answer.equals("bye")) break;
            else if (answer.equals("list"))
            {
                System.out.println("\tHere are the tasks in your list:");
                for (int i=0;i<sum;i++) System.out.println("\t"+(i+1)+"."+tasks[i]);
                System.out.println();
            }
            else if (answer.contains("done"))
            {
                int index;
                String[] sentence=answer.split(" ");
                index=Integer.parseInt(sentence[1]);
                tasks[index-1].markAsDone();
            }
            else if (answer.contains("todo"))
            {
                tasks[sum]=new Todo(answer);
                sum++;
                if (sum==1) System.out.println("\tNow you have "+sum+" task in the list.\n");
                else System.out.println("\tNow you have "+sum+" tasks in the list.\n");
            }
            else if (answer.contains("deadline"))
            {
                tasks[sum]=new Deadline(answer);
                sum++;
                if (sum==1) System.out.println("\tNow you have "+sum+" task in the list.\n");
                else System.out.println("\tNow you have "+sum+" tasks in the list.\n");
            }
            else if (answer.contains("event"))
            {
                tasks[sum]=new Event(answer);
                sum++;
                if (sum==1) System.out.println("\tNow you have "+sum+" task in the list.\n");
                else System.out.println("\tNow you have "+sum+" tasks in the list.\n");
            }
            else
            {
                tasks[sum]=new Task(answer);
                sum++;
            }
        }
        goodbye();
    }
}
