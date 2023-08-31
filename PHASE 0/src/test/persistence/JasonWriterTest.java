package persistence;

import model.EmojiType;
import model.EmotionResponse;
import model.EmotionTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;

import static model.EmojiType.ANGRY;
import static model.ResponseType.SCHOOL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JasonWriterTest extends JsonTest{

    private EmotionTracker et;
    private EmotionResponse er1;
    private EmojiType em1;

    @BeforeEach
    public void setUp() {
        et = new EmotionTracker();
        Date date1 = new Date(2022, 10, 14);
        EmojiType em1 = new EmojiType();
        em1.setEmoji(ANGRY);
        er1 = new EmotionResponse("study day", date1, SCHOOL, "I'm'doing my lab", em1);

    }

    @Test
    public void testEmptyEmotionTracker() {
        JsonWriter jsonWriter = new JsonWriter("./data/testEmptyEmotionTracker.json");

        try {
            jsonWriter.open();
            jsonWriter.write(et);
            jsonWriter.close();

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

        JsonReader reader = new JsonReader("./data/testEmptyEmotionTracker.json");

        EmotionTracker et2 = null;
        try {
            et2 = reader.read();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
        assertEquals(et2.length(), et.length());
    }

    @Test
    public void testOneEmotionTracker() {
        et.addEmotionResponse(er1);
        JsonWriter jsonWriter = new JsonWriter("./data/testOneEmotionTracker.json");

        try {
            jsonWriter.open();
            jsonWriter.write(et);
            jsonWriter.close();

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

        JsonReader reader = new JsonReader("./data/testOneEmotionTracker.json");

        EmotionTracker et2 = null;

        try {
            et2 = reader.read();
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
        assertEquals(et2.length(), et.length());

        EmotionResponse em2 = et2.getEmotionResponses().get(0);
        assertEquals(em2.getTitle(), er1.getTitle());
        assertEquals(em2.getType(), er1.getType());

    }
}
