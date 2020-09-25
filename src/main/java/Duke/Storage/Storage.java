package Duke.Storage;

import Duke.tasks.Deadline;
import Duke.tasks.Event;
import Duke.tasks.Task;
import Duke.tasks.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    public int readFile(Task[] tasks){
        try {
            int sum=0;
            File f = new File("/Users/tissue/Desktop/CS2113T/ip/data/duke.txt");
            Scanner s = new Scanner(f);
            while(s.hasNext()){
                String line=s.nextLine();
                boolean done=false;
                String[] sentences=line.split(" \\| ");
                if (sentences[0].equals("T")){
                    String answer="todo "+sentences[2];
                    tasks[sum]= new Todo(answer);
                    if (sentences[1].equals("1")){
                        done=true;
                    }
                    tasks[sum].setDone(done);
                    sum++;
                }
                else if (sentences[0].equals("D")){
                    String answer="deadline "+sentences[2]+" /by "+sentences[3];
                    tasks[sum]= new Deadline(answer);
                    if (sentences[1].equals("1")){
                        done=true;
                    }
                    tasks[sum].setDone(done);
                    sum++;
                }
                else if (sentences[0].equals("E")){
                    String answer="event "+sentences[2]+" /at "+sentences[3];
                    tasks[sum]=new Event(answer);
                    if (sentences[1].equals("1")){
                        done=true;
                    }
                    tasks[sum].setDone(done);
                    sum++;
                }
            }
            return sum;
        }
        catch (FileNotFoundException e){
            System.out.println("\n\tThe file does not exist.\n");
        }
        return 0;
    }

    public void writeFile(Task[] tasks, int sum){
        try {
            File f = new File("/Users/tissue/Desktop/CS2113T/ip/data/duke.txt");
            clearFile();
            FileWriter fw = new FileWriter(f);
            for (int i = 0; i < sum; i++) {
                fw.write(tasks[i].writeToFile()+"\n");
            }
            fw.close();
        }
        catch (IOException e){
            System.out.println("\n\tTrouble with IO stream.\n");
        }
    }

    public void clearFile(){
        try {
            File f = new File("/Users/tissue/Desktop/CS2113T/ip/data/duke.txt");
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.flush();
            fw.close();
        }
        catch (IOException e){
            System.out.println("\n\tTrouble with IO stream.\n");
        }
    }
}
