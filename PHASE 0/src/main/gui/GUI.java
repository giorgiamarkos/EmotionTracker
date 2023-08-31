package gui;

import model.*;
import model.Event;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static java.awt.Font.*;
import static java.awt.Label.*;

//represents applications main window frame with menu options
public class GUI implements ActionListener {

    private static final String JSON_STORE = "./data/GUI.json";
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private EmotionTracker et;
    private EmojiType emojiType;
    private ResponseType responseType;
    private JFrame frame;
    private JFrame frame2;
    private JFrame frame3;
    private JTextField titleText;
    private JTextField responseText;
    private JLabel label2;
    private JPanel emojiPanel;
    private JButton endButton;
    private JLabel titleLabel;
    private JLabel emojiLabel;
    private JButton nextButton;
    private JButton familyButton;
    private JButton friendsButton;
    private JButton schoolButton;
    private JButton personalButton;
    private JButton respondButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton historyButton;
    private JButton angerButton;
    private JButton sickButton;
    private JButton happyButton;
    private JButton excitedButton;
    private JButton neutralButton;
    private JLabel background;
    private String title;
    private String description;
    private Date date;

    //constructs fields
    public GUI() {
        et = new EmotionTracker();
        emojiType = new EmojiType();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        initialize();
        buttonProperties();
    }

    //EFFECTS: sets up the new JFrame for the main application
    public void initialize() {
        background = new JLabel((new ImageIcon("resources/updatedEmoji.png")));
        background.setBounds(0, 0, 600, 400);

        background.setLayout(new FlowLayout());
        frame = new JFrame("Emotion Tracker");
        frame.setPreferredSize(new Dimension(558, 350));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.add(background);
        JLabel label = new JLabel("My Emotion Response:");
        Font font = new Font("SERIF", BOLD, 18);
        label.setFont(font);
        frame.getContentPane().add(background);

        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosed(e);
                printLog(EventLog.getInstance());
                System.exit(0);
            }
        });
    }

    //EFFECTS: prints logged data to console
    public void printLog(EventLog el) {
        for (Event event : el) {
            System.out.println(event.toString());
        }

    }

    //EFFECTS: prints options menu for emotion tracker on main application window
    public void buttonProperties() {
        respondButton = new JButton("respond");
        saveButton = new JButton("save");
        loadButton = new JButton("load");
        historyButton = new JButton("history");

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.WEST);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 30));
        panel.setLayout(new GridLayout(2, 2));
        panel.add(respondButton);
        panel.add(historyButton);
        panel.add(saveButton);
        panel.add(loadButton);

        panel.setBackground(new Color(255, 201, 38));
        frame.pack();
        frame.setVisible(true);

        respondButton.addActionListener(this);
        historyButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
    }

    //EFFECTS: generates title input field with text field
    public String setRespondButton() {
        frame2 = new JFrame(" Emotion Response");
        frame2.setSize(400, 300);
        frame2.getContentPane().setBackground(new Color(255, 201, 38));
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleText = new JTextField();
        nextButton = new JButton("Next");
        Font font2 = new Font("SERIF", BOLD, 14);
        titleLabel = new JLabel("Enter Title:");
        titleLabel.setFont(font2);

        titleText.setBounds(50, 100, 200, 30);
        titleLabel.setBounds(50, 50, 200, 30);
        nextButton.setBounds(50, 150, 100, 30);
        frame2.add(titleLabel);
        frame2.add(titleText);
        frame2.add(nextButton);
        frame2.setLayout(null);
        frame2.setVisible(true);

        nextButton.addActionListener(this);

        titleText.setText(title);
        return titleText.getText();
    }

    //EFFECTS: generates category types for user to select
    public void setCategoryButton() {
        titleLabel.setText("Select a Category:");
        titleText.setVisible(false);
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new GridLayout(2, 2));
        categoryPanel.setBackground(new Color(255, 201, 38));
        familyButton = new JButton("Family");
        friendsButton = new JButton("Friends");
        schoolButton = new JButton("School");
        personalButton = new JButton("Personal");

        nextButton.setVisible(false);
        frame2.setLayout(new FlowLayout(CENTER, 30, 50));

        categoryPanel.add(familyButton);
        categoryPanel.add(friendsButton);
        categoryPanel.add(schoolButton);
        categoryPanel.add(personalButton);
        frame2.add(categoryPanel, BorderLayout.EAST);
        frame2.setVisible(true);

        familyButton.addActionListener(this);
        friendsButton.addActionListener(this);
        schoolButton.addActionListener(this);
        personalButton.addActionListener(this);

    }

    //EFFECTS: generates different emoji button options
    public void createEmojiButton() {
        emojiPanel = new JPanel();
        emojiPanel.setLayout(new GridLayout(3, 2));
        Font font3 = new Font("SERIF", BOLD, 14);
        emojiLabel = new JLabel("Select an emoji");
        emojiLabel.setFont(font3);
        frame2.setLayout(new FlowLayout(CENTER, 30, 50));
        frame2.add(emojiPanel, BorderLayout.CENTER);

        angerButton = new JButton("angry");
        happyButton = new JButton("happy");
        excitedButton = new JButton("excited");
        sickButton = new JButton("sick");
        neutralButton = new JButton("neutral");
        setEmojiButton();
    }

    //EFFECTS: adds the emoji buttons to the frame and adjusts sizing
    public void setEmojiButton() {
        frame2.add(emojiLabel);
        angerButton.setPreferredSize(angerButton.getPreferredSize());
        frame2.add(emojiPanel.add(angerButton));
        angerButton.setVisible(true);

        happyButton.setPreferredSize(happyButton.getPreferredSize());
        frame2.add(emojiPanel.add(happyButton));
        happyButton.setVisible(true);

        excitedButton.setPreferredSize(excitedButton.getPreferredSize());
        frame2.add(emojiPanel.add(excitedButton));
        excitedButton.setVisible(true);

        sickButton.setPreferredSize(sickButton.getPreferredSize());
        frame2.add(emojiPanel.add(sickButton));
        sickButton.setVisible(true);

        neutralButton.setPreferredSize(neutralButton.getPreferredSize());
        frame2.add(emojiPanel.add(neutralButton));
        neutralButton.setVisible(true);

        loadEmojiIcon();
    }

    //EFFECTS: adds corresponding emojiIcon to emojiButton
    public void loadEmojiIcon() {
        ImageIcon angerIcon = new ImageIcon(((new ImageIcon("resources/angryEmoji2.png")).getImage()
        ).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        ImageIcon happyIcon = new ImageIcon(((new ImageIcon("resources/happyEmoji.png")).getImage()
        ).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        ImageIcon excitedIcon = new ImageIcon(((new ImageIcon("resources/excitedEmoji.png")).getImage()
        ).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        ImageIcon sickIcon = new ImageIcon(((new ImageIcon("resources/sickEmoji.png")).getImage()
        ).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
        ImageIcon neutralIcon = new ImageIcon(((new ImageIcon("resources/neutralEmoji.png")).getImage()
        ).getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

        angerButton.setIcon(angerIcon);
        happyButton.setIcon(happyIcon);
        excitedButton.setIcon(excitedIcon);
        sickButton.setIcon(sickIcon);
        neutralButton.setIcon(neutralIcon);
        frame2.validate();

        angerButton.addActionListener(this);
        happyButton.addActionListener(this);
        excitedButton.addActionListener(this);
        sickButton.addActionListener(this);
        neutralButton.addActionListener(this);
    }

    //EFFECTS: sets up jframe for emotion responses
    public void setUpLastWindow() {
        frame2.getContentPane().removeAll();
        frame2.repaint();

        frame2.setSize(400, 300);
        endButton = new JButton("main menu");
        titleLabel.setText("Enter a Response:");
        responseText = new JTextField();

        responseText.setBounds(50, 100, 200, 30);
        titleLabel.setBounds(50, 50, 200, 30);
        endButton.setBounds(50, 150, 100, 30);

        frame2.add(responseText);
        frame2.add(titleLabel);
        frame2.add(endButton);
        frame2.setLayout(null);
        frame2.setVisible(true);

        endButton.addActionListener(this);

    }

    //EFFECTS: creates new emotion response object and adds all params
    public void createResponses() {
        title = titleText.getText();
        description = responseText.getText();
        date = Calendar.getInstance().getTime();

        EmotionResponse emotionResponse = new EmotionResponse(title, date, responseType, description, emojiType);
        et.addEmotionResponse(emotionResponse);
    }

    //EFFECTS: displays all emotion responses
    //@SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void showHistoryTable() {
        frame3 = new JFrame("My Response History");
        frame3.setPreferredSize(new Dimension(600, 400));
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame3.getContentPane().setBackground(new Color(255, 201, 38));
        Box box = Box.createVerticalBox();
        label2 = new JLabel("");
        frame3.getContentPane().add(label2, BorderLayout.NORTH);
        frame3.pack();
        frame3.setVisible(true);

        for (EmotionResponse emotionResponse : et.getEmotionResponses()) {
            Font font = new Font("SERIF", PLAIN, 12);
            JLabel titleLabel = new JLabel("TITLE: " + emotionResponse.getTitle());
            JLabel descriptionLabel = new JLabel("DESCRIPTION: " + emotionResponse.getDescription());
            JLabel dateLabel = new JLabel("DATE: " + (emotionResponse.getDate()));
            JLabel responseLabel = new JLabel("CATEGORY: " + (emotionResponse.getType()));
            JLabel emojiLabel = new JLabel(("EMOJI: " + emotionResponse.getEmoji().getChosenEmoji() + "\n"));
            frame3.add(box);
            box.add(titleLabel).setFont(font);
            box.add(dateLabel).setFont(font);
            box.add(responseLabel).setFont(font);
            box.add(emojiLabel).setFont(font);
            box.add(descriptionLabel).setFont(font);
        }
    }

    //EFFECTS: saves the emotion tracker to file
    public void saveData() {
        try {
            jsonWriter.open();
            jsonWriter.write(et);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "saved" + et.getEmotionResponses() + "to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file" + JSON_STORE);
        }
    }

    //EFFECTS: loads the emotion tracker to file
    public void loadData() {
        try {
            et = jsonReader.read();
            JOptionPane.showMessageDialog(null, "loaded" + et.getEmotionResponses() + "from" + JSON_STORE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read from file" + JSON_STORE);
        }
    }

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == respondButton) {
            setRespondButton();
        } else if (e.getSource() == nextButton) {
            setCategoryButton();
        } else if (e.getSource() == familyButton) {
            ResponseType family = ResponseType.FAMILY;
            responseType = family;
            createEmojiButton();
        } else if (e.getSource() == friendsButton) {
            ResponseType friend = ResponseType.FRIENDS;
            responseType = friend;
            createEmojiButton();
        } else if (e.getSource() == schoolButton) {
            ResponseType school = ResponseType.SCHOOL;
            responseType = school;
            createEmojiButton();
        } else if (e.getSource() == personalButton) {
            ResponseType personal = ResponseType.PERSONAL;
            responseType = personal;
            createEmojiButton();
        } else if (e.getSource() == historyButton) {
            showHistoryTable();
        } else if (e.getSource() == angerButton) {
            emojiType.setEmoji("ANGRY" + EmojiType.ANGRY);
            setUpLastWindow();
        } else if (e.getSource() == neutralButton) {
            emojiType.setEmoji("NEUTRAL" + EmojiType.NEUTRAL);
            setUpLastWindow();
        } else if (e.getSource() == sickButton) {
            emojiType.setEmoji("SICK" + EmojiType.SICK);
            setUpLastWindow();
        } else if (e.getSource() == happyButton) {
            emojiType.setEmoji("HAPPY" + EmojiType.HAPPY);
            setUpLastWindow();
        } else if (e.getSource() == excitedButton) {
            emojiType.setEmoji("EXCITED" + EmojiType.EXCITED);
            setUpLastWindow();
        } else if (e.getSource() == endButton) {
            description = responseText.getText();
            createResponses();
            frame2.dispose();
        } else if (e.getSource() == loadButton) {
            loadData();
        } else if (e.getSource() == saveButton) {
            saveData();
        }
    }
}
