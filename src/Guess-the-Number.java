import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        int answer = (int) (Math.random()*100 + 1);
        int userAnswer = 0,count = 1,guesses = 10, playAgain = 0, wins = 0;
        System.out.println("The correct guess is " + answer);
        while (userAnswer != answer && guesses > 0)
        { 
            String response = JOptionPane.showInputDialog(null,"Enter a guess between 1 and 100\nRemaining guesses: " + guesses, "Guessing Game", 3);
            userAnswer = onlyNumbers(response, guesses);
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, answer, count));
            guesses--;
            if(guesses == 1 && userAnswer != answer){
                JOptionPane.showMessageDialog(null, "This is your final guess!");
            }
            if(guesses == 0){
                playAgain = JOptionPane.showConfirmDialog(null, "10 more tries?", "Continue playing?", JOptionPane.YES_NO_OPTION);
                if(playAgain == JOptionPane.YES_OPTION){
                    guesses = 10;
                    playAgain = 0;
                }
                else{
                    JOptionPane.showMessageDialog(null,"You didn't guess the number. You guessed correctly " + wins + " times in " + count + " tries! Goodbye!");
                }
            }
            if(userAnswer == answer){
                wins++;
                playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?\nWins:" + wins, "Continue playing?", JOptionPane.YES_NO_OPTION);
                if(playAgain == JOptionPane.YES_OPTION){
                    guesses = 10;
                    playAgain = 0;
                    answer = (int) (Math.random()*100 + 1);
                    System.out.println("The correct guess is " + answer);
                }
                else{
                    JOptionPane.showMessageDialog(null,"You guessed correctly " + wins + " time(s) in " + count + " tries! Goodbye!");
                }
            }
            count++;
        }  
    }
    public static String determineGuess(int userAnswer, int answer, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == answer ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > answer) {
            return "Your guess is too high, try again.\nTry Number: " + count;
        }
        else if (userAnswer < answer) {
            return "Your guess is too low, try again.\nTry Number: " + count;
        }
        else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
    public static int onlyNumbers(String userAnswer, int guesses){
        if(userAnswer == null){
            System.exit(0);
        }
        int willItInt = 0;
        try{
            willItInt = Integer.parseInt(userAnswer);
        }
        catch(NumberFormatException nfe) {
            String response = JOptionPane.showInputDialog(null,"That was not a valid input! Please enter a guess between 1 and 100\nRemaining guesses: " + guesses, "Guessing Game", 3);
            return onlyNumbers(response, guesses);
        }
        return willItInt;
    }
}