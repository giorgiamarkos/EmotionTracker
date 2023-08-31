package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Date;
import java.util.List;

import static model.EmojiType.*;
import static model.ResponseType.*;
import static org.junit.jupiter.api.Assertions.*;

class EmotionResponseTest {

    private EmotionResponse er1;
    private EmotionResponse er2;
    private EmotionResponse er3;
    private EmotionResponse er4;
    private EmotionResponse er5;
    private EmotionResponse er6;
    private EmotionResponse er7;
    private EmotionResponse er8;
    private EmotionResponse er9;
    private EmotionResponse er10;
    private EmotionResponse er11;
    private EmotionResponse er12;
    private EmotionResponse er13;
    private EmotionResponse er14;
    private EmotionResponse er15;
    private EmotionResponse er16;
    private EmotionResponse er17;
    private EmotionResponse er18;
    private EmotionResponse er19;
    private EmotionResponse er20;
    private EmotionResponse er21;
    private EmotionResponse er22;
    private EmotionResponse er23;
    private EmotionResponse er24;
    private EmotionResponse er25;



    private EmotionTracker et;


    @BeforeEach
    public void setUp() {

        Date date1 = new Date(2022, 10, 14);
        Date date2 = new Date(2022, 10, 15);
        Date date3 = new Date(2022, 10, 16);
        Date date4 = new Date(2022, 10, 17);
        Date date5 = new Date(2022, 10, 18);


        EmojiType em1 = new EmojiType();
        EmojiType em2 = new EmojiType();
        EmojiType em3 = new EmojiType();
        EmojiType em4 = new EmojiType();
        EmojiType em5 = new EmojiType();

        em1.setEmoji(ANGRY);
        em2.setEmoji(SICK);
        em3.setEmoji(HAPPY);
        em4.setEmoji(NEUTRAL);
        em5.setEmoji(EXCITED);

        er1 = new EmotionResponse("study day", date1, SCHOOL, "I'm'doing my lab", em1);
        er2 = new EmotionResponse("family day", date2, FAMILY, "With my bros", em2);
        er3 = new EmotionResponse("birthday", date3, FRIENDS, "We ate cake", em3);
        er4 = new EmotionResponse("tired day", date4, PERSONAL, "I didn't eat", em4);
        er5 = new EmotionResponse("busy day", date5, SCHOOL, "I took my exam", em5);

        er6 = new EmotionResponse("chill day", date1, PERSONAL, "watched a movie", em4);
        er7 = new EmotionResponse("born day", date2, FAMILY, "sister was born", em5);
        er8 = new EmotionResponse("bffs birthday", date3, FRIENDS, "went downtown", em3);
        er9 = new EmotionResponse("sick day", date4, PERSONAL, "caught a cold", em2);
        er10 = new EmotionResponse("happy day", date5, FRIENDS, "seen my friends", em3);

        er11 = new EmotionResponse("rest day", date1, PERSONAL, "staying inside", em1);
        er12 = new EmotionResponse("family day", date2, FAMILY, "With my bros", em2);
        er13 = new EmotionResponse("birthday", date3, FRIENDS, "We ate cake", em3);
        er14 = new EmotionResponse("tired day", date4, PERSONAL, "I didn't eat", em4);
        er15 = new EmotionResponse("busy day", date5, SCHOOL, "I took my exam", em5);

        er16 = new EmotionResponse("shopping day", date1, PERSONAL, "bought new clothes", em5);
        er17 = new EmotionResponse("day trip", date2, FAMILY, "went to Seattle", em3);
        er18 = new EmotionResponse("winter break", date3, SCHOOL, "finally time off", em5);
        er19 = new EmotionResponse("ubc day", date4, SCHOOL, "all day on campus", em4);
        er20 = new EmotionResponse("bad day", date5, PERSONAL, "caught covid", em5);

        er21 = new EmotionResponse("lit day", date1, FRIENDS, "went to a party", em5);
        er22 = new EmotionResponse("school day", date2, FAMILY, "had a few classes", em4);
        er23 = new EmotionResponse("shoes", date3, PERSONAL, "bought new sneakers", em5);
        er24 = new EmotionResponse("great day", date4, SCHOOL, "saw all my friends", em3);
        er25 = new EmotionResponse("victoria trip", date5, FRIENDS, "went to victoria", em5);

        et = new EmotionTracker();

    }

    @Test
    public void testConstructor() {

        assertEquals(0, et.length());
        assertTrue(et.isEmpty());
        assertFalse(et.isFull());

    }
    @Test
    public void testGetters() {
        assertEquals(SCHOOL, er1.getType());
        assertEquals(FAMILY, er2.getType());
        assertEquals(FRIENDS, er3.getType());
        assertEquals(SCHOOL, er5.getType());
        assertEquals(PERSONAL, er4.getType());

        assertEquals("study day", er1.getTitle());
        assertEquals("family day", er2.getTitle());
        assertEquals("birthday", er3.getTitle());
        assertEquals("tired day", er4.getTitle());


        assertEquals("I'm'doing my lab", er1.getDescription());
        assertEquals("With my bros", er2.getDescription());
        assertEquals("We ate cake", er3.getDescription());
        assertEquals("I didn't eat", er4.getDescription());
        assertEquals("I took my exam", er5.getDescription());

    }

    @Test

    public void testAddEmotionResponses() {

        assertTrue(et.isEmpty());

        assertTrue(et.addEmotionResponse(er1));
        assertTrue(et.addEmotionResponse(er2));
        assertTrue(et.addEmotionResponse(er3));
        assertTrue(et.addEmotionResponse(er4));
        assertTrue(et.addEmotionResponse(er5));

        assertEquals(5,et.length());
        assertFalse(et.isEmpty());
        assertFalse(et.isFull());

        assertTrue(et.addEmotionResponse(er1));
        assertTrue(et.addEmotionResponse(er2));
        assertTrue(et.addEmotionResponse(er3));
        assertTrue(et.addEmotionResponse(er4));
        assertTrue(et.addEmotionResponse(er5));
        assertTrue(et.addEmotionResponse(er6));
        assertTrue(et.addEmotionResponse(er7));
        assertTrue(et.addEmotionResponse(er8));
        assertTrue(et.addEmotionResponse(er9));
        assertTrue(et.addEmotionResponse(er10));
        assertTrue(et.addEmotionResponse(er11));
        assertTrue(et.addEmotionResponse(er12));
        assertTrue(et.addEmotionResponse(er13));
        assertTrue(et.addEmotionResponse(er14));
        assertTrue(et.addEmotionResponse(er15));
        assertTrue(et.addEmotionResponse(er16));
        assertTrue(et.addEmotionResponse(er17));
        assertTrue(et.addEmotionResponse(er18));
        assertTrue(et.addEmotionResponse(er19));
        assertTrue(et.addEmotionResponse(er20));
        assertFalse(et.addEmotionResponse(er21));

        assertTrue(et.isFull());

    }

    @Test
    public void testGetEmotionResponses() {
        et.addEmotionResponse(er1);
        et.addEmotionResponse(er2);
        et.addEmotionResponse(er3);

        List<EmotionResponse> responseList = et.getEmotionResponses();

        assertEquals(3, responseList.size());
        assertEquals(er1, responseList.get(0));
        assertEquals(er2, responseList.get(1));
        assertEquals(er3, responseList.get(2));

    }

    @Test
    public void testGetEmotionResponse() {
        EmojiType emoji1 = new EmojiType();
        emoji1.setEmoji(HAPPY);

    er1.setResponseType(FRIENDS);
    assertEquals(er1.getType(), FRIENDS);

    er1.setEmoji(emoji1);
    assertEquals(emoji1, er1.getEmoji());
    assertEquals("😊", emoji1.getChosenEmoji());

    er2.setTitle("family is fun");
    assertEquals("family is fun", er2.getTitle());

    er3.setDescription("The cake was so good!");
    assertEquals("The cake was so good!", er3.getDescription());

        Date date = new Date(2022, 11, 18);
        er4.setDate(date);
        assertEquals(date, er4.getDate());
    }
}