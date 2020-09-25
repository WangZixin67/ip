package Duke.tasks;

public class Deadline extends Task {
    private String time;

    public Deadline(String userInput){
        String[] sentences=userInput.split("/by ");
        time=sentences[1];
        String[] name=sentences[0].split("deadline ");
        super.modifyName(name[1]);
        System.out.println("\n\tGot it. I've added this task:");
        System.out.println("\t  "+this);
    }

    public String toString() {
        if (super.getDone()) {
            return String.format("[D][✓] "+super.getName()+"(by: "+time+")");
        }
        else {
            return String.format("[D][✗] "+super.getName()+"(by: "+time+")");
        }
    }

    public void markAsDone() {
        super.setDone(true);
        System.out.println("\n\tNice! I've marked this task as done:");
        System.out.print("\t  ");
        System.out.println(this+"\n");
    }

    public String writeToFile() {
        String done="0";
        if (super.getDone()) {
            done="1";
        }
        String sentence="D | "+done+" | "+super.getName()+" | "+time;
        return sentence;
    }
}
