package model;


import org.json.JSONObject;
import persistence.Writable;

import java.util.Date;

//represents a class, emotion response containing a title, date, response type, description and emoji
public class EmotionResponse implements Writable {

    private String title;
    private Date date;
    private ResponseType type;
    private String description;
    private EmojiType emoji;

    private static final int MAX_LENGTH = 50;

    public EmotionResponse(String title, Date date, ResponseType type,
                           String description, EmojiType emoji) {
        this.title = title;
        this.date = date;
        this.type = type;
        this.description = "";
        this.setDescription(description);
        this.emoji = emoji;
    }

    //getters

    //EFFECTS: returns the date response was written
    public Date getDate() {
        return date;
    }

    //EFFECTS: returns the response given
    public String getDescription() {
        return description;
    }

    //EFFECTS: returns the emoji rating of description
    public EmojiType getEmoji() {
        return emoji;
    }

    //EFFECTS: returns the title of description
    public String getTitle() {
        return title;
    }

    //EFFECTS: returns the type of response
    public ResponseType getType() {
        return type;
    }

    //setters

    //MODIFIES: this
    //EFFECTS: sets response type to type
    public void setResponseType(ResponseType type) {
        this.type = type;
    }

    //MODIFIES: this
    //EFFECTS: sets date to date
    public void setDate(Date date) {
        this.date = date;
    }

    //MODIFIES: this
    //EFFECTS: sets the response to response if less than MAX_LENGTH
    public void setDescription(String response) {
        if (response.length() <= MAX_LENGTH) {
            this.description = response;
        }
    }

    //MODIFIES: this
    //EFFECTS: sets emoji type to emoji
    public void setEmoji(EmojiType emoji) {
        this.emoji = emoji;
    }

    //MODIFIES: this
    //EFFECTS: sets response title to title
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("title", title);
        json.put("date", date.getTime());
        json.put("type", type);
        json.put("description", description);
        json.put("emoji", emoji.getChosenEmoji());
        return json;
    }
}
