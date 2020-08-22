import java.util.Scanner;


public class Duke {
    public static void goodbye()
    {
        System.out.println("\nBye.Hope to see you again soon!");
    }

    public static void echo(String content)
    {
        System.out.println("\n\t"+content+"\n");
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
        while(true)
        {
            answer=in.nextLine();
            if (answer.equals("bye")) break;
            echo(answer);
        }
        goodbye();
    }
}
