# User Guide

## Features 

### Todo
Records what the user is going to do.

### Deadline
Records the user's deadline task content and time.

### Event
Records the user's event task content and time.

### List
List out all the tasks the user has recorded in the program.

### Done
Mark one of the tasks' "done" status as true.

### Find
List all the tasks whose names contain the keyword user wants to search.

### Delete
Delete one of the tasks in the task list.

### Read from file
At the beginning of the program, it will read from a particular file which records  
tasks' information in a special format.

In default, the file is duke.txt in the data folder.

Foramt:

Type | doneStatus | content | time

For example:
T | 1 | read book  
D | 0 | return book | June 6th  
E | 0 | project meeting | Aug 6th 2-4pm

First character represents the type of task. The integer "1" represents true for   
"done" status, "0" represents false. Then the first string records the content of  
the task, the second string will record the time.

### Write to file
Before the end of program, it will clear the file then write all the tasks in the list  
in the same form as above to the original file.

In default, the file is duke.txt in the data folder.


## Usage

### `todo` - Records what the user is going to do

The program will record what the user is going todo, set its "done" status as   
false defaultly and show how many tasks are in the task list.

Input format:

`todo content`

Example of usage: 

`todo read book`

Expected outcome:

`Got it. I've add this task:  
[T][✗] read book  
Now you have 1 tasks in the list.`

### `deadline` - Records user's deadline task content and time

The program will record user's deadline task content and its time, set its "done"  
status as false defaultly and show how many tasks are in the task list. It also can  
detect the time in form of "yyyy-mm-dd" and turn it to "MMM-dd-yyyy" format  
automaticly.

Input format:

`deadline content /by time`

Example of usage:

`deadline return book /by 2020-10-01`

Expected outcome:

`Got it. I've added this task:  
[D][✗] return book (by: Oct 01 2020)  
Now you have 2 tasks in the list.`

### `event`- Records user's event task content and time

The program will record user's event task content and its time, set its "done"  
status as false defaultly and show how many tasks are in the task list. It also can  
detect the time in form of "yyyy-mm-dd" and turn it to "MMM-dd-yyyy" format  
automaticly.

Input format:

`event content /at time`

Example of usage:

`event go party /at 2020-10-02`

Expected outcome:

`Got it. I've added this task:  
[E][✗] go party (at: Oct 02 2020)  
Now you have 3 tasks in the list.`

### `list` - List all the tasks in the task list

The program will output all the tasks that are in the task list with its type, done status,  
index, content and time if have.

Input format:

`list`

Example of usage:

`list`

Expected outcome:

`Here are the tasks in your list:  
1.[T][✗] read book  
2.[D][✗] return book (by: Oct 01 2020)  
3.[E][✗] go party (at: Oct 02 2020)`

### `done` - Modify the task's "done" status as true

The program will modify the task's "done" status as true and output all the information  
of it.

Input format:

`done index`

Example of usage:

`done 2`

Expected outcome:

`Nice! I've marked this task as done:  
[D][✓] return book (by: Oct 01 2020)`

### `find` - List all the tasks whose contents include the keyword

The program will list all the tasks whose contents include the keyword user inputs, with  
their other information.

Input foramt:

`find keyword`

Example of usage:

`find book`

Expected outcome:

`1.[T][✗] read book  
2.[D][✓] return book (by: Oct 01 2020)`

### `delete` - Delete one of the tasks in the task list

The program will delete the task with index the user input and output its information and  
how many tasks are left in the task list.

Input format:

`delete index`

Example of usage:

`delete 2`

Expected outcome:

`Noted. I've removed this task.  
[D][✓] return book (by: Oct 01 2020)  
Now you have 2 tasks in the list.`
