import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * 
 */
public class TextField extends Actor
{
    private boolean cursorActive = false;
    private boolean enabled = false;
    public static boolean isNameEntered = false;
    
    private int textFontSize;
    private int cursorPosition = 0;
    
    private String input = "";
    private String text = "";
    private String temp = "";
    
    private Color bgColor = Color.white;
    private Color textColor = Color.black;
    
    public TextField(int width, int height, Color bgColor, Color textColor, String text, int fontSize) throws IllegalArgumentException {
        
        this.bgColor = bgColor;
        this.textColor = textColor;
        this.text = text;
        this.enabled = true;
        cursorPosition = text.length();
        this.getImage().clear();
        this.getImage().scale(width, height);
        textFontSize = fontSize;
        resetImage();
        displayText();
    }
    
    /**
     * Control the TextFields action.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            enabled = true;
        }
        if (enabled) {
            input = Greenfoot.getKey();
            if (input == "backspace" && text.length() != 0 && cursorPosition != 0) {
                if (cursorPosition == text.length()) {
                    text = text.substring(0, text.length()-1);
                }
                else {
                    temp = text.substring(0, cursorPosition - 1);
                    temp += text.substring(cursorPosition, text.length()-1);
                    text = temp;
                    temp = "";
                }
                cursorPosition--;
            }
            else if (input == "space") {
                if (cursorPosition == text.length()) {
                    text += " ";
                }
                else {
                    temp = text.substring(0, cursorPosition);
                    temp += " ";
                    temp += text.substring(cursorPosition, text.length() - 1);
                    text = temp;
                    temp = "";
                }
                cursorPosition++;
            }
            else if (input == "left") {
                if (cursorPosition > 0) {
                    cursorPosition--;
                    cursorActive = true;
                }
            }
            else if (input == "right") {
                if (cursorPosition < text.length()) {
                    cursorPosition++;
                    cursorActive = true;
                }
            }
            else if (input != null && input.length() == 1) {
                if (cursorPosition == text.length()) {
                    text += input;
                }
                else {
                    temp = text.substring(0, cursorPosition);
                    temp += input;
                    temp += text.substring(cursorPosition, text.length() - 1);
                    text = temp;
                    temp = "";
                }
                cursorPosition++;
            }
            // notify server of change of name
            updateNameOnServer();
            displayText();
            
        // Setting name in the Ship's class variable
             
        }
    }
    
    private void updateNameOnServer(){
        
    }
    
    /**
     * Display the text onto the TextField.
     */
    private void displayText() {
        GreenfootImage textImage = new GreenfootImage(text, textFontSize, textColor, new Color(0, 0, 0, 0));
        GreenfootImage textBeforeCursor = new GreenfootImage(text.substring(0, cursorPosition), textFontSize, textColor, new Color(0, 0, 0, 0));
        resetImage();
        getImage().drawImage(textImage, (textImage.getWidth() > getImage().getWidth() - 10 ? -(textImage.getWidth() - getImage().getWidth()) - 10 : 5), (getImage().getHeight() / 2 - textImage.getHeight() / 2));
        getImage().setColor(textColor);
        if (cursorActive) {
            getImage().fillRect((textBeforeCursor.getWidth() > getImage().getWidth() - 10 ? getImage().getWidth() - 8 : textBeforeCursor.getWidth() + 7), getImage().getHeight() / 2 - textFontSize / 2, 2, textFontSize);
        }
        getImage().setColor(bgColor);
        getImage().fillRect(0, 0, 3, getImage().getHeight()-2);
    }
    
    /**
     * Clears the image of the TextField so that it is empty again.
     */
    private void resetImage() {
        getImage().setColor(bgColor);
        getImage().fill();
        getImage().setColor(Color.black);
        getImage().fillRect(0, getImage().getHeight()-2, getImage().getWidth(), 3);
        getImage().fillRect(getImage().getWidth()-2, 0, 3, getImage().getHeight());
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public String getText() {
       
        return this.text;
    }
    
  
}