package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import static model.EmojiType.*;
import static model.ResponseType.*;

//represents an emotion tracker
public class MyEmotionTracker {

    private static final String JSON_STORE = "./data/EmotionTracker.json";
    private Scanner input;
    private EmotionTracker et;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;



    //EFFECTS: constructs EmotionTracker and runs application
    public MyEmotionTracker() throws FileNotFoundException {
        et = new EmotionTracker();
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        runTracker();
    }

    public void runTracker() {
        boolean continueTracker = true;
        String command = null;

        while (continueTracker) {
            printOptions();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                endProgram();
                continueTracker = false;
            } else {
                processInput(command);
            }

        }

        System.out.println("\nHave a Good Day!");
    }


    //MODIFIES: this
    // EFFECTS: processes user input until quit
    private void processInput(String command) {
        if (command.equals("respond")) {
            processCommand();
        } else if (command.equals("history")) {
            getResponseHistory();
        } else if (command.equals("save")) {
            saveEmotionTracker();
        } else if (command.equals("load")) {
            loadEmotionTracker();
        } else {
            System.out.println("Response is invalid, try again");
        }
    }


    //EFFECTS: prints options for emotion tracker
    private void printOptions() {
        System.out.println("\nWelcome to your Emotion Tracker!");
        System.out.println("\nSelect from:");
        System.out.println("\trespond: to type a response");
        System.out.println("\thistory: view response history");
        System.out.println("\tsave:    to save responses to file");
        System.out.println("\tload     load responses from file");
        System.out.println("\tquit:    quit Emotion Tracker");

    }

    //EFFECTS: creates a new emotion response object and adds emotion response to the list
    public void processCommand() {

        String title = getTitleType();
        ResponseType type = getResponseType();
        EmojiType emoji = getEmojiType();
        String description = checkInDescription();
        Date date = new Date();

        EmotionResponse emotionResponse = new EmotionResponse(title, date, type, description, emoji);
        et.addEmotionResponse(emotionResponse);


    }

    //EFFECTS: prints out the emojis for response
    public EmojiType getEmojiType() {
        System.out.println("There are 5 different options to scale your emotion response \n");

        System.out.println("Please choose an emoji type:\n'a' for angry, \n" + "'h' for happy,\n"
                + "'e' for excited, \n" + "'s' for sick,\n'n' for neutral.");

        String emojiType = input.next();

        EmojiType em = new EmojiType();

        if (emojiType.equals("a")) {
            System.out.println(ANGRY);
            em.setEmoji(ANGRY);
        } else if (emojiType.equals("h")) {
            System.out.println(HAPPY);
            em.setEmoji(HAPPY);
        } else if (emojiType.equals("s")) {
            System.out.println(SICK);
            em.setEmoji(SICK);
        } else if (emojiType.equals("e")) {
            System.out.println(EXCITED);
            em.setEmoji(EXCITED);
        } else {
            System.out.println(NEUTRAL);
            em.setEmoji(NEUTRAL);
        }
        System.out.println("Emoji has been added.\n");
        return em;
    }

    //EFFECTS: user inputs response to emotion tracker
    public String getTitleType() {

        System.out.println("What is the title of your response?");

        String title = input.next();

        System.out.println("Title has been updated\n");
        return title;
    }

    //EFFECTS: user selects the type of response from 4 given categories
    public ResponseType getResponseType() {
        System.out.println("please select a category for your response:\n");

        System.out.println("'fam' for family,\n'fr' for friends, \n'sc' for school \n'per' for personal");
        String responseType = input.next();

        if (responseType.equals("fam")) {
            return FAMILY;
        } else if (responseType.equals("fr")) {
            return FRIENDS;
        } else if (responseType.equals("sc")) {
            return SCHOOL;
        } else {
            return PERSONAL;
        }
    }

    //EFFECTS: takes user input for how they are feeling
    public String checkInDescription() {
        System.out.println("How are you feeling today? Type in your response \n");

        String response = input.next();

        return response;
    }

    //EFFECTS: prints response history
    public void getResponseHistory() {
        for (EmotionResponse emotionResponse : et.getEmotionResponses()) {
            System.out.println("TITLE:" + emotionResponse.getTitle());
            System.out.println("TYPE:" + emotionResponse.getType());
            System.out.println("DATE:" + emotionResponse.getDate());
            System.out.println("EMOJI:" + emotionResponse.getEmoji().getChosenEmoji());
            System.out.println("RESPONSE:" + emotionResponse.getDescription());
            System.out.println(input.nextLine());
        }
    }

    // EFFECTS: saves the EmotionTracker to file
    public void saveEmotionTracker() {
        try {
            jsonWriter.open();
            jsonWriter.write(et);
            jsonWriter.close();
            System.out.println("Saved " + et.getEmotionResponses() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads EmotionTracker from file
    public void loadEmotionTracker() {
        try {
            et = jsonReader.read();
            System.out.println("Loaded " + et.getEmotionResponses() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: stops receiving user input
    public void endProgram() {
        System.out.println("Shutting down...");
        input.close();
    }

}


