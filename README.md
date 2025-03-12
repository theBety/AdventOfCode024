# Christmas 2 - Advent of code 2024

My code is divided into 4 packages, each one represents one day. Every package contains 2 classes -  
**first task (a) and second task (b)**. Classses are named by specific pattern:  
Day + number of day + a/b

Then, you may notice, that there's alot of text files. Every day has two inputs:  
1. **test input** - here I tested if the code works.
2. **input** - that is the actual input, you will put your input in these files. They're called "inputDay + number of day". 
**Please make sure you put your input in correct file.**

This code is functional on java 20.0.2.

**Where to put my input and how to test this program?**  
Put all of your inputs (Days 1-4) in correct files (inputDay + number.txt) 
and then start the program. **Be patient with the program please.**

### Start 

this class (specifically method) starts all of the other classes (days).

## Package day1

### Day1a

The goal in this class was:  
>"pair up the smallest number int the left list with the smallest number in the right list, then the second-smallest 
left number with the second-smallest right number, and so on. then, figure out how far apart the numbers are. 
At the end, add up all of those distances."

For better understanding visit [Advent of code 2024, day 1](https://adventofcode.com/2024/day/1).

#### getData()

This method takes input line by line and splits it into 2 integers. Then, the first integer saves to *list1* 
and the second one to *list2*.

When all numbers are divided into these two lists, program sorts them from smallest to highest by using *Colections.sort()* method.

#### getDis()

This method takes integers, one by one, and makes absolute value from integers on same position in list1 and list2.  
Then, it just adds up the differences.  
**return:** your result

#### start()

This method is called to start the other methods.  
**return:** method *getDis()*

### Day1b

The goal in this class was:  
>"Figure out exactly how often each number from the left list appears in the right list. Calculate a total similarity score by 
adding up each number in the left list after multiplying it by the number of times that number appears in the right list."

For better understanding visit [Advent of code 2024, day 1](https://adventofcode.com/2024/day/1). 
But firstly, **you need to type in your output of first task** to be able to read the second tasks instructions.

#### getData()

This is the same method as before, but if you want to, you can read about it  
[Right here](#getdata).

#### similarity()
while() cycle can be only repeated up to size of a list1 (length of .txt file). 

```java
  for (String j : numbers.keySet()) {
      if (list1.get(indexInList1).equals(j)) {
        simResult += numbers.get(j);
        stop = 1;
        break;
      }
  }
```
***numbers*** is a hashmap, where are stored values and their frequency in right list.
This cycle goes through keys (numbers from the left list that have already been found, and whose frequency in the right list is known), 
if it finds the right key, it adds up to the result.  

The main point of this cycle is to save time. By iterating through the keys instead of the list, we ensure that each value appears only once.

If the value we are looking for isn't in the hashset, we go through the entire list and count how many times the value appears 
in the right list. Then, we add the value and its frequency to a hashmap.

**return:**  result of this task.

## Package day2

### Day2a

The goal in this class was:  
>Find all lines that are 'safe'. Line counts as safe only if both of the following are true:  
>1. The numbers are either all increasing or all decreasing.
>2. Any two adjacent numbers differ by at least one and at most three.

For better understanding visit [Advent of code 2024, day 2](https://adventofcode.com/2024/day/2)

#### isRising()

This method returns information if the first two numbers are increasing or decreasing. There's also a case, 
where are the first two numbers same. 

--- 

**Values of "int isRising" and their meaning**
+ 0 -> the list is meant to be decreasing
+ 1 -> the list is meant to be increasing
+ 3 -> the two numbers are the same.

**return:** information about a state of the list.

#### findingResult()
 
First, this method sends two integers to the [*isRising()*](#isrising) method. After that, based on the result of *isRising()*, 
it checks if all other numbers follow the same pattern (increasing or decreasing). 
If even one number does not follow, the cycle ends, and the method moves on to check another line.

In ***case 3***, method automatically ends, bacause the result of method [*isRising()*](#isrising). was 3 
(= the first two numbers were same, so the line can't be correct).

**return:** result of this task.

### Day2b

*Personally, this task was the hardest for me to do.*

The goal in this class was:
> "Now, the same rules apply as before, except if removing a single level from an unsafe report 
would make it safe, the report instead counts as safe."
>> level = number, report= line

For better understanding visit [Advent of code 2024, day 2](https://adventofcode.com/2024/day/2). 
But firstly, **you need to type in your output of first task** to be able to read the second tasks instructions.

#### safeness()

This method checks if there is any mistake in a line. In the first cycle, 
the method selects *currentNum* and checks if this number is greater than the number that follows it. 
Based on this information, the state of that line is set to either *'RISING'* or *'FALLING'*.  
'RISING', 'FALLING' and 'START' are values of Enum **CasesOfSequence**

**return:** is this line correct or not.

#### mainLogic()

This method gets from file one line. Then, it checks it by using [*safeness()*](#safeness) if the line is correct. 
if not, method repeatedly deletes one number and then checks if the line is safe. If so, the cycle breaks 
and count of good lines increases by one.

**return:** result of this task.

## Package day3

### Day3a

The goal in this class was:  
> Find in a file functions, that are written correctly.  
A function has to look like this: **mul(X,Y)**  
> 1. X and Y are each 1-3 digit numbers.
> 2. Multiply X*Y and add up all of the results.

For better understanding visit [Advent of code 2024, day 3](https://adventofcode.com/2024/day/3). 

#### regexAndResult()

This method receives mul(X,Y) as input. After that, it extracts the two integers, 
assigning the first to 'firstNumber' and the second to 'secondNumber.' It then calls [*mul()*](#mul)
and adds the result of mul() to the final result.

#### mul()

Multiplies two numbers. 

**return:** the result.

#### getMulFromLine()

This method takes line by line file and checks if there are any correctly written functions. 
If so, method [*regexAndResult()*](#regexandresult) takes care of everything. 

**return:** result of this task.

### Day3b

the goal in this class was:  
> There are two new instructions you'll need to handle:
> + The do() instruction enables future mul instructions.
> + The don't() instruction disables future mul instructions.  
> Only the most recent do() or don't() instruction applies. 
At the beginning of the program, mul instructions are enabled.

For better understanding visit [Advent of code 2024, day 3](https://adventofcode.com/2024/day/3). 
But firstly, **you need to type in your output of first task** to be able to read the second tasks instructions.

#### regexAndResult()

This is the same method as before, but if you want to, you can read about it  
[Right here](#regexandresult).

#### mul()

This is the same method as before, but if you want to, you can read about it  
[Right here](#mul).

#### doAndDont()

This class takes one line and with usage of regex, where:  
+ *group(1)* represents function *don't()*
+ *group(2)* represents function *do()*
+ *group(3)* represents function *mul(X,Y)*

changes value of variable *isActive*. When *isActive* is false, function *mul(X,Y)* is
disabled. Only when matcher finds function *mul(X,Y)*, and *isActive* is true, result
of the task is increased by result of *mul()*.

**return:** result of this task.

## Package day4

### Day4a

The goal in this class was:  

> This word search allows words to be horizontal, vertical, diagonal, written backwards, or even overlapping other words. It's a little unusual, though, as you don't merely need to find one instance of XMAS - you need to find all of them.

For better understanding visit [Advent of code 2024, day 4](https://adventofcode.com/2024/day/4).

#### isItAWord()

This method goes through every direction after finding 'X' in a 2d array (more in method mainLogic()) and checks if in that direction is word "XMAS". If so, count increases by one.
 One 'X' can be part of more words.

**return:** how many ways is there to create a word with one 'X'.

#### mainLogic()

This method reads a file and first counts all the lines to determine the 'height' and the 'width' of one line.  
It then creates a 2D array and adds all the lines to this array.  
Why? Because I need to access letters at specific coordinates.  
Finally, the method iterates through the entire 2D array, searching for 'X'. If it finds 'X', the method [isitAWord()](#isitaword) returns a number, which is added to the result.  

**return:** result of this task.

### Day4b

The goal in this class was:  
> "this isn't actually an XMAS puzzle; it's an X-MAS puzzle in which you're supposed to find two MAS in the shape of an X."

For better understanding visit [Advent of code 2024, day 4](https://adventofcode.com/2024/day/4). 
But firstly, **you need to type in your output of first task** to be able to read the second tasks instructions.

#### mainLogic()

This is the same method as before, but if you want to, you can read about it
[Right here](#mainlogic-1). There's only one difference - instead of finding 'X', this method finds 'A'.  
Why? Well, every cross has an 'A' in a middle - an 'A' can't be a middle for more than one cross.

**return:** result of this task.

#### isItACross()

This method is similar to [isItAWord()](#isitaword). It goes through coordinates
and finds out, how are the letters arranged.  
Here are examples of two out of four cases how they can be arranged:  

| M | . | S |   
| . . | A | . .|  
| M | . | S |

| M | . | M |   
| . . | A | . .|  
| S | . | S |

If the letters are arranged in some possible way, the boolean sets to true.

**return:** boolean, if the letters can form a cross. 

## Last few words

One of the hardest and most challenging days was day 2. This day had many edge cases and generally has very complex. 
To be honest, the second task took me 3 days to figure out. Originally, second task had over 200 lines, because there
was just so many edge cases and exceptions. I'm happy, that I made it work, if i had to, 
i would probably choose to do this project again.

Alžběta Olmerová
