# Arkanoid Clone in Java
This project is a basic implementation of the classic Arkanoid game in Java. It features four levels with increasing difficulty, allows pausing and resuming gameplay, and displays a final score screen.

## Features
Play through four challenging levels.
Pause the game with the "p" key and resume with the spacebar.
View a final score screen upon completing or losing the game.

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




# Further Development Ideas
- Implement sound effects and music for a more immersive experience.
- Add more levels with increased difficulty.
- Introduce power-ups that affect gameplay.

