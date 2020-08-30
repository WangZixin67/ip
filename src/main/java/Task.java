public class Task {
    private String name;
    private boolean done;
    public Task()
    {
        done=false;
    }
    public Task(String answer)
    {
        name=answer;
        done=false;
    }
    public void modifyName(String answer)
    {
        name=answer;
    }
    public void markAsDone()
    {
        done=true;
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.println("\t  [✓] "+name+"\n");
    }
    public void setDone(boolean value)
    {
        done=value;
    }
    public boolean getDone()
    {
        return done;
    }
    public String getName()
    {
        return name;
    }
}
