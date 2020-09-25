import Duke.Parser.Parser;
import Duke.Storage.Storage;
import Duke.Ui.Ui;
import Duke.tasks.*;

import java.util.Scanner;

public class Duke {
    private static Storage storage;
    private static Ui ui;
    private static TaskList tasklist;
    private static Parser parser;

    public static void main(String[] args) {
        storage=new Storage();
        ui=new Ui();
        tasklist=new TaskList();
        parser=new Parser();
        ui.greeting();
        Scanner in= new Scanner(System.in);
        String input;
        tasklist.num=storage.readFile(tasklist.tasks);
        while(true)
        {
            input=in.nextLine();
            if (input.equals("bye")) {
                break;
            }
            else {
                parser.parse(input,tasklist);
            }
        }
        storage.writeFile(tasklist.tasks,tasklist.num);
        ui.goodbye();
    }
}
