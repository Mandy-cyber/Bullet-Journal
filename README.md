# Java Journal
> CS3500 (Object Oriented Design) Programming assignment

![Java](https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/c48bb8c0-02ba-4d97-9603-f6b38dce04de)


N.B. - the default password for a new file is **password123**

### **Table of Contents**

[1. Why **Our** Java Journal](#why-our-java-journal)  <br>
[2. Features](#features)  <br>
[3. SOLIDly Epic Design](#solid-design)  <br>
[4. Extending Our Program](#extending-our-program)   <br>
[5. Deploy the Jar](#deploy-the-jar) <br>
[6. Image Attributes](#image-attributes) <br>

<hr>

# Why *Our* Java Journal
> _📝Your digital bullet journal of choice... every time_

Java Journal, brought to you by _the exception handlers_ is the finest in digital bullet journaling. Pinterest, meets Tumblr, meets that one cute notebook you bought at a store and have yet to open, in this novel new application. With a key eye for maximizing **`aesthetic`**, whilst simultaneously ensuring peek **`productivity`**, this Java Journal is the **only** acceptable option for your day-to-day journaling needs ✨.

So what are you waiting for? Get journalling now, and see how Java Journal was built exactly with **you** in mind!

<br>

# Features
> Feel free to check out the full feature list [here](FEATURES.md)

It is easy to say we're the best, and even easier to prove it! Java Journal boasts a wide variety of bold, unique, features that gets the job done (_fasionably of course_). These include:


| Feature                                                          | How it Looks                                                                                                                                                                                                                                |
|------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| A multitude of different highly customizable themes              | <img src="https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/c0b1c189-2c9d-4d6b-b024-04689f3243e1" height="300px" /> |
| Simply effective menu bar and shortcut navigation                | <img src="https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/d403085b-154d-4ab0-ac4e-747e0d5e8f39" />                                                                                                                       |
| Quotes and notes to keep you motivated                           | <img src="https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/032f777e-d220-4fe6-887c-d50a30f91529" height="300px" />                                                                                                                      |
| Templates for every occasion... or shall we say **every season** | <img src="https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/e4a2bd31-6609-4ee3-b1f8-d5516e226c55" height="300px" />                                                                                                                      |
| Password protection for _every_ week                             | <img src="https://github.com/CS-3500-OOD/pa05-exception-handlers/assets/67931161/1affd309-df33-420e-b986-3265eb9110ff" height="300px" />                                                                                                                       |



<br><br>

# SOLID Design
The `exception-handlers` are good students of OOD and hence take the principals of **SOLID** design very seriously. Here is how they did it:

- **`Single-Responsibility`** - In planning this project we immediately knew we were going to need several different classes if we wanted to obey this principle. Hence we have different controllers and views for different features/pages, and highly deconstructed model and json classes to make sure we don't overcontaminate any classes. Then, within these classes, we ensured that their methods actually related to themselves and nothing else.
  
- **`Open-closed`** - Simple! We made abstract classes and interfaces to ensure that we could easily add new features without having to modify existing ones. A key examples of this would be our Controller abstract class with its **seven** different implementations. There is also our FileReader and FileWriter classes that are purposefully general, so that new implementations can be made outside of the current BujoFileReader and BujoFileWriter.

- **`Liskov Substitution`** - Here we can again look at our FileReader and FileWriter classes where we are able to substitute them in place of our BujoFileReader and BujoFileWriter with no complaint. We can also take the Controller abstract class as an example, because we can technically use it in place of its more concrete implementations--the only side note is that the themes of the pages will not be as cute!
  
- **`Interface Segregation`** - This project is actually kind of weird for us as it is one of the few times we had little to no use of interfaces! The main interface we utilized was View that, similiar to Controller, had seven implementations. In each of these implementations they all utilized the method from View and hence were not forced to implement any methods they didn't actually need! This is also the same for the FileReader and FileWriter as their implementations also utilized all the methods!
  
- **`Dependency Inversion Principle`** - Again we can look at our FileReader and FileWriters. Throughout our code we were very careful in ensuring that no one class is too tightly coupled to a specific implementation of something else. So from our very first UML diagram we knew that we needed to keep FileReader and FileWriter as the 'general' interfaces that could be called upon instead. This looser coupling allowed us to easily read and write to files throughout our program without worrying about whether or not in future cases the code would still work with a different type of FileReader/Writer.


<br>

# Extending Our Program
Taking into consideration how we managed to follow the SOLID design principles, extending our program, bringing it to greater heights, is as simple as it is to use our bullet journal🤭. Not convinced? Well, here are a couple of different features we could easily implement:

1. **Mind Changes** could be implemented in our MiniViewer as easily as us adding an 'Edit' button and text fields for editing. We could easily copy the logic behind us being able to edit quotes/notes, and apply it to add this feature.
2. **Taksie Backsies** could be implemented similarly to Mind Changes by adding a 'Delete' button to the MiniViewer that, when clicked, will remove the entry from the given day's entry. Nothing else would have to be done e.g. to our json, as when saved it auto-rereads the model and regenerates its json format.
3. **Week Start** could be implemented by creating a copy of our makeDays method and instead turn it into a `makeSortedDays(String startDay)` method where the given startDay represents what day of the week should be the starting day. Our FileWriter and FileReader would not complain as _(due to the S in SOLID)_ they are unconcerned about the logic behind the things they read/write.

_And we could go on and on!_


# Deploy The Jar
> build > fat.Jar > pa05-template-1.0-SNAPSHOT.jar > RUN

Hey, and guess what we also have... a `.jar` file making our Java Journa a fully deployable application. To use it:
1. Build the repository using gradle
2. Go to `build/fat.Jar` and you should see **`pa05-template-1.0-SNAPSHOT.jar`**
3. Right click and **Run** it!


# Image Attributes
> **N.B. Java.png and Privacy.png were made by yours truly <3**

<br>

[🔥Fire Emoji](https://www.vecteezy.com/png/20522257-fire-emoji-icon) <br>
[🔒Lock Emoji](https://emojipedia.org/apple/ios-14.2/locked/) <br>
[💮Flower Emoji](https://www.iconfinder.com/icons/7740228/flower_floral_nature_spring_flower_emoji_icon) <br>
[🏠House Image](https://emojiterra.com/house/) <br>
[🍂Leaf Emoji](https://emojiterra.com/fallen-leaf/) <br>
[📝Memo Emoji](https://creazilla.com/nodes/54301-memo-emoji-clipart) <br>
[❄️Snowflake Emoji](https://emojiterra.com/snowflake/) <br>
[〰️Water Wave Emoji](https://emojiterra.com/water-wave/) <br>
[☀️Sun Emoji](https://emojis.wiki/sun/) <br>







