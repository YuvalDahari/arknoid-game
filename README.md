# Arkanoid game
This project was developed as a 7-part ongoing assignment during the second semester of my first year at Bar-Ilan University (BIU). The project showcases a single-threaded implementation of the Arkanoid game, which is uncommon for games of this nature. Additionally, it does not utilize Java's built-in GUI objects; instead, a custom GUI implementation included in this repository is used.
The game features multiple levels with increasing difficulty and is built on a user-friendly graphical interface. The development was carried out using Java language in the IntelliJ IDEA Ultimate IDE, adhering to several key Object-Oriented Programming (OOP) principles:

## Features
Play through four challenging levels.
Pause the game with the "p" key and resume with the spacebar.
View a final score screen upon completing or losing the game.

## Design Patterns

### Builder Design Pattern
The Builder design pattern was used in this project to create various game objects in a step-by-step manner. This allows for greater flexibility and ease of use, as each builder class is responsible for constructing a specific object. Builders were used to create balls, blocks, limits, and paddles in a clear and organized manner. This approach allows for more readable and maintainable code and makes it easy to modify the properties of each object during the construction process.

### Strategy Design Pattern
The strategy design pattern was used in the project to allow different behaviors for block placement and coloring in the first level of the Arkanoid game. The implementation of these strategies allows for more flexibility in creating different levels with different characteristics without having to change the core game code.

### Decorator Design Pattern
The decorator design pattern was used to add new functionalities to existing Animation objects. The `WaitingForKeyPressDecorator` class is the decorator, while the `PauseScreen` and `KeyPressStoppableAnimation` classes are the concrete components that are decorated. The decorator pattern allows for dynamically adding new functionalities to existing objects without changing their structure, while keeping the code clean and maintainable.

### Observer Design Pattern
The Observer design pattern was used to handle events triggered by different game objects. The game objects are implemented as Observables, and the listener classes are implemented as Observers. The listener classes subscribe to events triggered by the game objects and act accordingly, such as removing blocks or balls from the game or updating the player's score. The use of the Observer pattern allows for a flexible and modular code structure, where new listeners can easily be added without modifying the game objects themselves.

## Screenshots
<div style="display: flex; flex-wrap: wrap; justify-content: space-between;">
    <div style="flex: 1; padding: 5px; max-width: 50%;">
        <img src="https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.28.59_bdb300d9.jpg?
            raw=true" alt="level 1" width="100%"/>
    </div>
    <div style="flex: 1; padding: 5px; max-width: 50%;">
        <img src="https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.26.37_f325acb8.jpg?raw=true" alt="level 2" width="100%"/>
    </div>
    <div style="flex: 1; padding: 5px; max-width: 50%;">
        <img src="https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.28.15_07a5d35e.jpg?raw=true" alt="level 3" width="100%"/>
    </div>
    <div style="flex: 1; padding: 5px; max-width: 50%;">
        <img src="https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.25.59_7fb47738.jpg?
raw=true" alt="level 4" width="100%"/>
    </div>
</div>

## Levels
- **Level 1**: Introduction to the basic mechanics.
- **Level 2**: Increased speed and more blocks.
- **Level 3**: Introduction of moving blocks.
- **Level 4**: Complex patterns and faster speeds.


## Running the Game
1.Download the Code:
Make sure you have the source code for the project (ass6.zip) containing all the classes and the build.xml file.

2.Extract the Files:
Unzip the downloaded file (ass6.zip) to extract the project files.

3.Compile the Code: 
Open a terminal or command prompt and navigate to the extracted folder. Run the following command to compile the code:
```shel
ant compile
```
4.Run the Game:  
After successful compilation, run the game with the following command:
```shel
ant run
```
Playing Specific Levels (Optional)
You can choose which levels to play by specifying them as arguments when running the program. For example, to play levels 3 and then 1:
```shel
ant -Dargs="3 1" run
```
Any argument that's not a number between 1 and the total number of levels will be ignored.




# implemention of OOP principals
- Polymorphism and inheritance.
- Usage of basic design patterns in OOP, such as Observer, Builder, etc.
- Usage of several generic collections and data structures such as linked lists and arraylists.

# Dependencies
- Windows / Linux / macOS
- Keyboard that contains: Spacebar (for stoppage), "P" button, and all arrows.
- Apache Ant

