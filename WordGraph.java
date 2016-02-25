/**
 * WordGraph.java
 * Lucy Lu and Allie Warren, 3/15/14
 * Contains the main for our program
 * Depending on user input, the program either
 * takes a starting word and ending word and 
 * finds the shortest word ladder between the words (if it exists)
 * or takes a word and finds all of its anagrams
 */
    
import java.util.*;
import java.io.*;
public class WordGraph{
    
public static void main(String[] args) {
    File inputFile = null;
    Scanner scanner = null;       	
    ArrayList<String> dictionary = new ArrayList<String>();
	
    //opens the dictionary file
    inputFile = new File("dictionaryWords.txt");
    try {
        scanner = new Scanner(inputFile);
    } catch (FileNotFoundException e) {
        System.err.println("Can't open " + inputFile);
        System.exit(1);
    }
   
    // if user inputs "anagram" a dictionary of words 
    // of the length of the word that the user inputs
    // is created and all of the anagrams for the
    // word that the user inputs are found
    if( args[0].equals("anagram")){
        LinkedList words = new LinkedList();
        words.add(args[1].toUpperCase());
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (isSameLetters(args[1].toUpperCase(), word)){
                words.add(word);
            }
        }
        if (words.size()==1) {
            System.out.println ("no anagrams");
        }
        else {
            words.print();
        }

    }
    

    // if the user inputs "ladder" a dictionary of words
    // of the length of the word that the user inputs
    // is created and, if the user has input two real words, 
    // then the method wordLadder is called
    else if (args[0].equals("ladder")) {
    	while (scanner.hasNextLine()) {
        	String word = scanner.nextLine();
            if (word.length()==args[1].toUpperCase().length()) {
            dictionary.add(word);
            }
    	}
        if (dictionary.contains(args[1].toUpperCase()) && dictionary.contains(args[2].toUpperCase())) {
            wordLadder(dictionary,args[1].toUpperCase(), args[2].toUpperCase());
        }
        else {
            System.out.println ("user input incorrect");
        }

    }

    // if the user does not follow the format 
    // java ladder startWord endWord   or
    // java anagram string   then the program ends and 
    // and error message is printed.
    else {
        System.out.println ("incorrect user input");
    }
}
    
    // Takes a starting word and ending word, and using our dictionary,
    // finds, and prints out, the shortest word ladder between the two words (if one exists)
    // by using breadth first search
    public static void wordLadder (ArrayList<String> dictionary, String start, String end) {
        String word = start;
        Queue queue = new Queue();
        Map <String, String> path = new HashMap <String, String>();
        int index = dictionary.indexOf(word);
        boolean[] visited= new boolean[dictionary.size()];
        visited[index]= true;
        String parent = word;
        queue.enqueue(word);
        boolean done=false;
        while (!queue.isEmpty()) { //breadth first search
        	String pointer = queue.dequeue();
            parent=pointer;
            index = dictionary.indexOf(pointer);
        	for (int j=0; j<dictionary.size(); j++) {
        		if (isAlmostSameLetters(dictionary.get(index), dictionary.get(j)) && !visited[j]) {
        			visited[j]= true;
        			path.put(dictionary.get(j), parent);
        			queue.enqueue(dictionary.get(j));
                    if (end.equals(dictionary.get(j))) {
                        j=dictionary.size();
                        done=true;
                    }
                }
            }

            if (done) { //once the word is found, we backtrack through the path and print it out
                Stack doneList = new Stack();
                doneList.push(end);
                String guardian;
                guardian=path.get(end);
                doneList.push(guardian);
                while (!(guardian.equals(word))) {
                    guardian =path.get(guardian);
                    doneList.push(guardian);
                }
                while (!doneList.empty()) {
                    System.out.println(doneList.pop());
                }
                break;
            }  
        }
        if (!done) { 
            System.out.println ("no word ladder");
        }
    } 

    // Returns true if two words are the same lenght and contain the same letters
    public static boolean isSameLetters (String a, String b) {
        List<String> stringA = new ArrayList<String>(a.length());
        for (int i = 0; i < a.length(); i++) {
            stringA.add(String.valueOf(a.charAt(i)));
        }

        List<String> stringB = new ArrayList<String>(b.length());
        for (int i = 0; i < b.length(); i++) {
            stringB.add(String.valueOf(b.charAt(i)));
        }

        if (a.length()!=b.length() || a.equals(b)) {
            return false;
        }
        else {
            for (int i=0; i<stringA.size(); i++) {
                if (stringB.contains(stringA.get(i))) {
                    stringB.remove(stringA.get(i));
                    stringA.remove(i);
                    i--;
                }
                else {
                return false;
                }
            }
        }
        return true;
    }

    // Returns true is two words are one letter different 
    public static boolean isAlmostSameLetters (String a, String b) {
        int counter=0;
        if (a.length()!=b.length()) {
            return false;
        }
        else {
            for (int i=0; i<a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)){
                    counter++;
                }
            }
        }
        return counter<2; 
    }
       
}