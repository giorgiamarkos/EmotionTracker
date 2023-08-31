# DAILY EMOTION TRACKER

_______________________ 

## 🎯Objective:

Have you ever wished you could place all your **thoughts** and **emotions**
in one place?

### 👋🏼Welcome to your _Daily Emotion Tracker!_

The Daily Emotion Tracker is a platform where you will have a daily prompt to express your feelings and anything else
you would like to share. You will have the opportunity to give a detailed response within 150 characters. In addition, you
are able to give a rating from a 5-scale emoji rating.To keep different aspects of your life organized there will be 
categories (school, family,friends, and personal) to place your rating under!

### 👥Who Will This Impact?

This platform is open to anyone: students, parents, teachers, employees, children and anyone who has the ability to
type. The daily emotion tracker will not only allow you to express how you feel but improve your typing abilities.

### ✨My Inspiration

Often, I would write down my thoughts on a piece of paper but end up disregarding it due to a lack of organization.
This platform will allow me to have one place to access everything. I love the idea of being able to track how my
emotions have changed over the course of a few days, weeks, or even months. This gives me the ability to see my own
development and where I can improve.

### ⌨️User Stories:

- Adding a personalized rating through an emoji scale
- Type up to 150 characters of how you feel
- Access to all typed activity and emoji rating
- Adds Emotion Responses to Emotion Tracker 

- Save responses from history to file 
- Load responses from file

### Instructions for Grader
- You can generate the first required event related to adding Xs to a Y by selecting the option to "respond" and follow
  through with the given prompts.
- You can generate the second required event related to adding Xs to a Y by selecting "history" to display previous inputs
- You can locate my visual component on the main menu, background image and on the emojis by selecting "respond"
- You can save the state of my application by selecting the save button on the main screen
- You can reload the state of my application by selecting the load button on the main screen

### Phase 4: Task 2:
Thu Dec 01 17:30:15 PST 2022\
Added Title: FINALS\
Added Emoji: NEUTRAL😐\
Thu Dec 01 17:30:31 PST 2022\
Added Title: heyyyyy\
Added Emoji: EXCITED😁

### Phase 4: Task 3
In my GUI package I would add multiple different classes based on the methods. Having everything in one class made it hard
to debug, stay organized and overall very low cohesion and high coupling.
* I would create different classes to adhere to the Single Responsibility Pattern.
* I would create an interface `framePrinter` that has a `setUpFrame()` method that classes that create a new JFrame window can inherit from. 
* having classes for different components of my `emotionResponse` for example, my `createEmojiButton` and `setEmojiButton`
would be a class that implements `framePrinter` and has its `ActionLister` for each emojiButton within that class.
* As seen in my gui, there was a large `ActionPreformed` method so this would resolve the length and cohesion. Having the ActionListeners in one big implementation was
very hard to debug, and it exceeded the method length, but I didn't have enough time, so I would fix that.
* I would repeat the same process for `createCategoryButton` have a separate class that inherits  `framePrinter` and has
its own `ActionPreformed` implementation have the different `ResponseType`. 
* Overall I would think about the design more thoroughly before starting my UI and GUI I would make use of abstract classes, include exceptions.

note:`SuppressWarningCheckStyle` in gui was approved by TA.