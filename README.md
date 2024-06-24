# Arkanoid game
This project is a basic implementation of the classic Arkanoid game in Java. It features four levels with increasing difficulty, allows pausing and resuming gameplay, and displays a final score screen.

## Features
Play through four challenging levels.
Pause the game with the "p" key and resume with the spacebar.
View a final score screen upon completing or losing the game.
![level 1]([.pics/תמונה של WhatsApp‏ 2024-06-25 בשעה 01.28.59_bdb300d9.jpg])
![level 2]([https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.26.37_f325acb8.jpg])
![level 3]([https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.28.15_07a5d35e.jpg])
![level 4]([https://github.com/YuvalDahari/arknoid-game/blob/master/pics/%D7%AA%D7%9E%D7%95%D7%A0%D7%94%20%D7%A9%D7%9C%20WhatsApp%E2%80%8F%202024-06-25%20%D7%91%D7%A9%D7%A2%D7%94%2001.28.59_bdb300d9.jpg])


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

