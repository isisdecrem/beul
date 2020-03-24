import java.util.*;
class Main {

  static String[] wordList = {"abstraction",
    "ambiguous",
    "arithmetic",
    "backslash",
    "bitmap",
    "circumstance",
    "combination",
    "consequently",
    "consortium",
    "decrementing",
    "dependency",
    "disambiguate",
    "dynamic",
    "encapsulation",
    "equivalent",
    "expression",
    "facilitate",
    "fragment",
    "hexadecimal",
    "implementation",
    "indistinguishable",
    "inheritance",
    "internet",
    "java",
    "localization",
    "microprocessor",
    "navigation",
    "optimization",
    "parameter",
    "patrick",
    "pickle",
    "polymorphic",
    "rigorously",
    "simultaneously",
    "specification",
    "structure",
    "lexical",
    "likewise",
    "management",
    "manipulate",
    "mathematics",
    "hotjava",
    "vertex",
    "unsigned",
    "primitives",
    "traditional"}; 

  public static void main(String[] args) {
    String word = pickWord();
    int numGuesses = 6;
    ArrayList<String> wordBank = new ArrayList<String>();
    fillWordBank(wordBank); //fill with a-z
    ArrayList<String> usedLetters = new ArrayList<String>();
    String blankWord = createBlankWord(word);
    while (numGuesses > 0) {
      System.out.println(wordBank);
      printGraphics(numGuesses);
      printBlankWord(blankWord);
      String guess = getGuess();
      String updated = processGuess(word, guess, blankWord, wordBank, usedLetters);
      if (updated.equals(blankWord)){
        numGuesses--;
      }
      blankWord = updated;
      if (word.equals(blankWord)){
        break;
      }
    }
    printEnding(numGuesses, word);
  }
  public static String pickWord(){
    return wordList[(int) (Math.random()* wordList.length)];
    
  }

  public static void printBlankWord(String blankWord){
    System.out.println("Your guess: " + blankWord);
  }

  public static void fillWordBank(ArrayList<String> wordBank){
    char letter = 'a';
    for(int i = 0; i < 26; i++){
      wordBank.add("" + letter);
      letter++;
    }
  }

  public static  String createBlankWord(String word){
    String str = ""; 
   int n =  word.length();
   for (int i = 0; i < n; i++){
     str = str + "_"; 
   }
   return str; 
  }
  public static void printGraphics(int numGuesses){

    String [] hangmanPics =  {
      "  +---+\n" +
      "  |   |\n" + 
      "      |\n" + 
      "      |\n" + 
      "      |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      "      |\n" + 
      "      |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      "  |   |\n" +
      "      |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      " /|   |\n" +
      "      |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      "      |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      " /    |\n" +
      "      |\n" + 
      "=========\n",
      "  +---+\n" + 
      "  |   |\n" +
      "  O   |\n" +
      " /|\\  |\n" +
      " / \\  |\n" +
      "      |\n" + 
      "=========\n"};
    System.out.println(hangmanPics[6-numGuesses]);
  }
  
  
  

  public static String processGuess(String word, String guess, String blankWord, ArrayList<String> wordBank, ArrayList<String> usedLetters){
    updateWordBank(wordBank, guess);
    updateUsedLetters(usedLetters, guess);
    blankWord = updateBlanks(word, blankWord, guess);
    return blankWord; //return the updated guess
  }
  public static void updateWordBank(ArrayList <String>wordBank,String guess){
    for(int i =0; i<wordBank.size(); i++){
      if (wordBank.get(i).equals(guess)){
        wordBank.remove(i);
      }
    }
    
  }
  public static String updateBlanks(String word, String blankWord, String guess){
    String updated = "";
    for(int i = 0; i < word.length(); i++){
      if (word.substring(i,i+1).equals(guess)){
        updated += guess; 
      }
      else {
        updated += blankWord.substring(i,i+1); 
      }
    }
    //TODO: stub
    return updated;
  }
  public static void updateUsedLetters(ArrayList <String>usedLetters,String guess){
      usedLetters.add(guess);
      //TODO: check for duplicates
  }
  
  //this method will return a string of size 1. It is a letter between a-z
  public static String getGuess(){
    Scanner scan = new Scanner(System.in);
    System.out.println("What do you want to guess? Please enter one letter");
    return scan.next();

  }
  public static void printEnding(int numGuesses, String word){
    if (numGuesses == 0){
      printGraphics(6);
      System.out.println("You lost");
      System.out.println("The word was " + word);
    }
    else {
      System.out.println(word);
      System.out.println("You win!");
    }
  }
  }


/**
TODO:
Ascii art
display # guesses
pick word
draw spaces for letters
letter bank
used letter bank
fill in correct letters
add body parts with wrong letters guessed
ending/result
**/