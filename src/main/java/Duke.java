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

    public static void addlist(String content,String[] list,int sum)
    {
        System.out.print("\n\tadded: ");
        echo(content);
        list[sum]=content;
    }

    public static void showlist(String[] list, int sum)
    {
        for (int i=0;i<sum;i++)
        {
            System.out.println("\t"+(i+1)+". "+list[i]);
        }
        System.out.println("");
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
        String[] list=new String[100];
        int sum=0;
        while(true)
        {
            answer=in.nextLine();
            if (answer.equals("bye")) break;
            else if (answer.equals("list"))
            {
                showlist(list,sum);
            }
            else
            {
                addlist(answer,list,sum);
                sum++;
            }
        }
        goodbye();
    }
}
