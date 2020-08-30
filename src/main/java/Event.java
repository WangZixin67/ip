public class Event extends Task{
    private String time;

    public Event(String answer)
    {
        System.out.println("\n\tGot it. I've added this task:");
        String[] sentences=answer.split("/at ");
        time=sentences[1];
        String[] name=sentences[0].split("event ");
        super.modifyName(name[1]);
        System.out.println("\t  "+this);
    }

    public String toString()
    {
        if (super.getDone()) return String.format("[E][✓] "+super.getName()+"(at: "+time+")");
        else return String.format("[E][✗] "+super.getName()+"(at: "+time+")");
    }

    public void markAsDone()
    {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }
}
