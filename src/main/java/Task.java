public class Task {
    private String[] name;
    private boolean[] done;
    private int sum;
    public Task()
    {
        name=new String[100];
        done=new boolean[100];
        for (int i=0;i<100;i++) done[i]=false;
        sum=0;
    }
    public void addlist(String content)
    {
        System.out.print("\n\tadded: ");
        Duke.echo(content);
        name[sum]=content;
        sum++;
    }
    public void showlist()
    {
        System.out.println("\n\tHere are the tasks in your list:");
        for (int i=0;i<sum;i++)
        {
            System.out.print("\t"+(i+1)+".");
            if (done[i]) System.out.print("[✓] ");
            else System.out.print("[✗] ");
            System.out.println(name[i]);
        }
        System.out.println("");
    }
    public void markAsDone(String answer)
    {
        int index;
        String[] sentence=answer.split(" ");
        index=Integer.parseInt(sentence[1]);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.println("\t  [✓] "+name[index-1]+"\n");
        done[index-1]=true;
    }
}
