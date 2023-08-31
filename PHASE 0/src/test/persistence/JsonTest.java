package persistence;

import model.EmojiType;
import model.EmotionResponse;
import model.EmotionTracker;
import model.ResponseType;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    EmotionResponse er;
    EmotionTracker et;
    protected void checkEmotionResponse(String title, Date date, ResponseType type, String description, EmojiType emojiType) {
        assertEquals(title, er.getTitle());
        assertEquals(date, er.getDate());
        assertEquals(type, er.getType());
        assertEquals(description, er.getDescription());
        assertEquals(emojiType, er.getEmoji());
    }
}
