package model;

//represents an EmojiType class containing 5 different emoji options
public class EmojiType {

    public static final String ANGRY = "😤";
    public static final String SICK = "😷";
    public static final String NEUTRAL = "😐";
    public static final String HAPPY = "😋";
    public static final String EXCITED = "😁";

    private String chosenEmoji;


    public void setEmoji(String s) {
        chosenEmoji = s;
    }

    public String getChosenEmoji() {
        return chosenEmoji;
    }
}
