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
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
        Scanner in=new Scanner(System.in);
        String answer;
        Task list=new Task();
        while(true)
        {
            answer=in.nextLine();
            if (answer.equals("bye")) break;
            else if (answer.equals("list"))
            {
                list.showlist();
            }
            else if (answer.contains("done"))
            {
                list.markAsDone(answer);
            }
            else
            {
                list.addlist(answer);
            }
        }
        goodbye();
    }
}
