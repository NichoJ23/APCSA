public class Elby {
    /**
     * Get a default greeting
     *
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     *
     * @param statement the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement) {
        statement = statement.toLowerCase();
        statement = statement.trim();

        String response = "";

        if (statement.length() == 0) {
            response = "Say something, I'm giving up on you";
        } else if (findKeyword(statement, "I want to", 0) >= 0) {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "I want", 0) >= 0) {
            response = transformIWantStatement(statement);
        } else if (findKeyword(statement, "you", 0)
        > findKeyword(statement, "I", 0)) {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "me", 0)
        > findKeyword(statement, "you", 0)
        && findKeyword(statement, "you", 0)
        > findKeyword(statement, "do", 0)) {
            response = transformYouMeStatement(statement);
        } else if (findKeyword(statement, "nicholas", 0) >= 0) {
            response = "Nicholas! He sounds like a really smart person";
        } else if (findKeyword(statement, "no", 0) >= 0) {
            response = "Why so negative?";
        } else if (findKeyword(statement, "mother", 0) >= 0
        || findKeyword(statement, "father", 0) >= 0
        || findKeyword(statement, "sister", 0) >= 0
        || findKeyword(statement, "brother", 0) >= 0) {
            response = "Tell me more about your family.";
        } else if (findKeyword(statement, "dog", 0) >= 0 
        || findKeyword(statement, "cat", 0) >= 0) {
            response = "Tell me more about your pets";
        } else if (findKeyword(statement, "grass", 0) >= 0) {
            response = "Careful. You shouldn't touch that";
        } else if (findKeyword(statement, "eyeballs", 0) >= 0) {
            response = "Eyeballs! Those are so tasty";
        } else if (findKeyword(statement, "ki", 0) >= 0) {
            response = "Ki ohpe wakay!";
        } else {
            response = getRandomResponse();
        }

        return response;
    }

    /**
     * Pick a default response to use if nothing else fits.
     *
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 7;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);

        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        } else if (whichResponse == 1) {
            response = "Hmmm.";
        } else if (whichResponse == 2) {
            response = "Do you really think so?";
        } else if (whichResponse == 3) {
            response = "You don't say.";
        } else if (whichResponse == 4) {
            response = "That's very ki.";
        } else if (whichResponse == 5) {
            response = "Would it help if I apologized?";
        } else if (whichResponse == 6) {
            response = "I think you need to see a therapist";
        }

        return response;
    }

    public int findKeyword(String statement, String goal, int startPos) {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();

        // The only change to incorporate the startPos is in the line below
        int goalPos = phrase.indexOf(goal, startPos);

        // Refinement--make sure the goal isn't part of a word
        while (goalPos >= 0) {
            // Find the string of length 1 before and after the word
            String before = " ", after = " ";

            if (goalPos > 0) {
                before = phrase.substring(goalPos - 1, goalPos);
            }

            if (goalPos + goal.length() < phrase.length()) {
                after = phrase.substring(goalPos + goal.length(), 
                    goalPos + goal.length() + 1);
            }

            /* determine the values of goalPos, before, and after at this point */

            // If before and after aren't letters, we've found the word
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) &&                
            ((after.compareTo("a")  < 0) || (after.compareTo("z")  > 0))) {
                return goalPos;
            }

            // The last position didn't work, so let's find the next, if there is one.
            goalPos = phrase.indexOf(goal,goalPos + 1);
        }
        return -1;
    }

    /**
     * Take a statement with "you <something> me" and transform it into "What makes
     * you think that I <something> you?"
     *
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */

    public String transformYouMeStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }

        int posOfYou = findKeyword(statement, "you", 0);
        int posOfMe  = findKeyword(statement, "me",  posOfYou + 3);

        String restOfStatement = statement.substring(posOfYou + 3, posOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into "What
     * would it mean to <something>?"
     *
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */

    public String transformIWantToStatement(String statement) {
        //Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int pos = findKeyword(statement, "I want to", 0);
        String restOfStatement = statement.substring(pos + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }

    /**
     * Take a statement with "I want <something>." and transform it
     * into Would you really be happy if you had <something>?
     *
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement){
        statement = statement.trim();
        if (statement.charAt(statement.length()-1) == '.') {
            statement = statement.substring(0, statement.length()-1);
        }
        
        int pos = findKeyword(statement, "I want", 0);
        String restOfStatement = statement.substring(pos + 6).trim();
        
        return "Would you really be happy if you had " + restOfStatement + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into
     * "Why do you <something> me?"
     *
     * @param statement the user statement, assumed to contain "I" followed by
     * 	something "you"
     * @return the transformed statement
     */
    public String transformIMeStatement(String statement) {
        statement = statement.trim();
        if (statement.charAt(statement.length()-1) == '.') {
            statement = statement.substring(0, statement.length()-1);
        }
        
        int posOfI = findKeyword(statement, "I", 0);
        int posOfYou = findKeyword(statement, "You", posOfI+1);
        
        String restOfStatement = statement.substring(posOfI + 3, posOfYou).trim();
        
        return "Why do you " + restOfStatement + " me?";
    }

}