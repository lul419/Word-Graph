# Word-Graph
This program finds shortest word ladder between words and returns all of the anagrams for one word. This is a test for the use of graph. Final project for CS 201 Data Structure. Dare created: March, 2014.

----------------------------------------------------------------------

The program 'WordGraph' is a word game helper that finds the word ladder or all anagrams for input words.

The command line syntax for our program is: java ladder startWord endWord, which returns a 
word ladder between the two words, if one exists, or java anagram string, which finds all of the 
anagrams for the given word. For example the user input: java Graph ladder love safe, will output:
LOVE
LAVE
SAVE
SAFE
and the user input: java Graph anagram team, will output:
TEAM
MATE
MEAT
META
TAME

Graph contains an ArrayList<String> dictionary, which contains all words of the same length
as the word inputed by the user at args[1] from our dictionary txt file. For anagram we create a 
LinkedList of all of the words that are anagrams of the user's word. For ladder we create a queue (implemented as 
a linked list), map, boolean array and stack. The queue and the boolean array are used for doing breadth first search. 
We store nodes in the queue as we iterate through them, and we add them to the boolean array to mark them as visited.
The implemented the graph as a map. The map contains the path between the two user input words, by storing 
the children (any word one letter different than the parent word) as the key and by storing the parent
as the value in the map. Our map forms a spanning tree. 
We then use a stack to print out the path, by back tracking from the final word to the start word.

Our program is running well at this time. It is able to find the shortest word ladder between two words
and all anagrams for a word fairly quickly and is able to handle a dictionary of over 200,000 words.
It is fairly memory efficient, but probably could be even better.
