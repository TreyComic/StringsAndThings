package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        input = input.toLowerCase(); //makes all input as string easier to handle
        int wordCounter = 0;
        for(String wordToCompare : input.split(" ")){ //checks until a space is found then splits them into sub strings
            char lastCharacter = wordToCompare.charAt(wordToCompare.length() - 1);
            //charAt refers the character in which the index (parameters) is in reference to
            //wordToCompare.length gives length of the words but subtract 1
            //this counter removes 1 because the index starts at 0

            if(lastCharacter == 'y' || lastCharacter == 'z'){
                wordCounter ++; //add if the word ends with y or z
            }
        }
        return wordCounter;
    }



    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        if(remove == null){
            return base;
        }
        return base.replace(remove, "");
        // replaces anythind from remove in the base and replaces it with nothing!
    }



    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int counterIs = input.split("is", -1).length -1;
        //inputsplit stops at is and creates its substrings
        //-1 for empty strings
        //length - 1 is because index starts at 0
        int counterNot = input.split("not", -1).length -1;
        return counterIs == counterNot;
    }



    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        for(int iterate = 0; iterate < input.length(); iterate++){
            if(input.charAt(iterate) == 'g') {
                //check if there is not or is another 'g'
                if((iterate == 0 || input.charAt(iterate- 1) != 'g') && (iterate == input.length()-1 || input.charAt(iterate +1) != 'g')){
                    //checking g for left and then for right
                    return false;
                }
            }
        }
        return true;
    }



    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int counter = 0;
        for(int i = 0; i < input.length() - 2; i++){ //third to last char in the string!
            char currentCharacter = input.charAt(i);
            if(currentCharacter == input.charAt(i + 1) && currentCharacter == input.charAt(i + 2)){
                counter++;
            }
            return counter;
        }
        return null;
    }
}
