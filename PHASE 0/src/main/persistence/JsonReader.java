package persistence;

//Code from JsonSerializationDemo

import model.EmojiType;
import model.EmotionResponse;
import model.EmotionTracker;
import model.ResponseType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.stream.Stream;

//Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;


    //EFFECTS: constructs a reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    //EFFECTS: reads EmotionTracker from file and returns it;
    //throws IOException if an error occurs reading data from file
    public EmotionTracker read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseEmotionTracker(jsonObject);

    }

    //EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //EFFECTS: parses EmotionTracker from JSON object and returns it
    private EmotionTracker parseEmotionTracker(JSONObject jsonObject) {
        EmotionTracker et = new EmotionTracker();
        addEmotionResponses(et, jsonObject);
        return et;
    }

    //MODIFIES: et
    //EFFECTS: parses EmotionResponses from JSON object and adds them to EmotionTracker
    private void addEmotionResponses(EmotionTracker et, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("emotion responses");
        for (Object json : jsonArray) {
            JSONObject nextEmotionResponse = (JSONObject) json;
            addEmotionResponse(et, nextEmotionResponse);
        }
    }

    //MODIFIES: et
    //EFFECTS: parses EmotionResponses from JSON object and adds it to EmotionTracker
    private void addEmotionResponse(EmotionTracker et, JSONObject jsonObject) throws DateTimeParseException {
        String title = jsonObject.getString("title");
        Date date = new Date(jsonObject.getLong("date"));
        ResponseType type = ResponseType.valueOf(jsonObject.getString("type"));
        String description = jsonObject.getString("description");
        EmojiType emoji = new EmojiType();
        emoji.setEmoji(jsonObject.getString("emoji"));
        EmotionResponse er = new EmotionResponse(title, date, type, description, emoji);
        et.addEmotionResponse(er);
    }


}
