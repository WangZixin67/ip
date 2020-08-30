public class Todo extends Task{
    public Todo(String answer)
    {
        System.out.println("\n\tGot it. I've add this task:");
        String[] sentence=answer.split("todo ");
        super.modifyName(sentence[1]);
        System.out.println("\t  "+this);
    }
    public String toString()
    {
        if (super.getDone()) return String.format("[T][✓] "+super.getName());
        else return String.format("[T][✗] "+super.getName());
    }
    public void markAsDone()
    {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }
}
