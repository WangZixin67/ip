package Duke.Parser;

import Duke.tasks.TaskList;

/**
 * Judge whether the command is valid and go to each method accordingly
 */
public class Parser {
   public void parse(String input, TaskList tasklist) {
       String sentences[]=input.split(" ");
       if (input.equals("list")) {
           tasklist.printList();
       }
       else if (sentences[0].equals("find")){
           tasklist.find(sentences[1]);
       }
       else if (sentences[0].equals("todo")) {
           tasklist.processTodo(input);
       }
       else if (sentences[0].equals("deadline")) {
           tasklist.processDeadline(input);
       }
       else if (sentences[0].equals("event")) {
           tasklist.processEvent(input);
       }
       else if (sentences[0].equals("delete")){
           tasklist.processDelete(input);
       }
       else if (sentences[0].equals("done")) {
           tasklist.processDone(input);
       }
       else {
           System.out.println("\n\t☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
       }
   }
}
