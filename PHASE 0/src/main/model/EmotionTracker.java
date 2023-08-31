package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// represents an emotion tracker that stores descriptions, emojis, date, description type and titles
public class EmotionTracker implements Writable {

    private List<EmotionResponse> emotionResponses;
    private static final int MAX_SIZE = 25;

    public EmotionTracker() {
        emotionResponses = new ArrayList<>();

    }

    //MODIFIES: this
    //EFFECTS: adds a new response to the emotion tracker
    public boolean addEmotionResponse(EmotionResponse er) {
        if (emotionResponses.size() < MAX_SIZE) {
            EventLog.getInstance().logEvent(new Event("Added Title: " + er.getTitle() + "\n"
                    + "Added Emoji: " + er.getEmoji().getChosenEmoji()));
            emotionResponses.add(er);
            return true;
        }
        return false;
    }

    //EFFECTS: returns emotion responses
    public List<EmotionResponse> getEmotionResponses() {
        return emotionResponses;
    }

    //getters

    //EFFECTS: gets the number if elements within emotionResonses
    public int length() {
        return emotionResponses.size();
    }

    //EFFECTS: if emotionResponses is full it returns false otherwise true
    public boolean isFull() {
        if (emotionResponses.size() == MAX_SIZE) {
            return true;
        }
        return false;
    }

    //EFFECTS: returns true if emotionResponses is empty otherwise false
    public boolean isEmpty() {
        return emotionResponses.isEmpty();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("emotion responses", emotionResponsesToJson());
        return json;
    }

    private JSONArray emotionResponsesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (EmotionResponse er : emotionResponses) {
            jsonArray.put(er.toJson());
        }

        return jsonArray;
    }

}
