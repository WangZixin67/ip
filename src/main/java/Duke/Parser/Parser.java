package Duke.Parser;

import Duke.tasks.TaskList;

public class Parser {
   public void parse(String input, TaskList tasklist) {
       String sentences[]=input.split(" ");
       if (input.equals("list")) {
           tasklist.printList();
       }
       else if (sentences[0].contains("todo")) {
           tasklist.processTodo(input);
       }
       else if (sentences[0].contains("deadline")) {
           tasklist.processDeadline(input);
       }
       else if (sentences[0].contains("event")) {
           tasklist.processEvent(input);
       }
       else if (sentences[0].contains("delete")){
           tasklist.processDelete(input);
       }
       else if (sentences[0].contains("done")) {
           tasklist.processDone(input);
       }
       else {
           System.out.println("\n\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
       }
   }
}
