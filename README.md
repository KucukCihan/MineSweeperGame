# ***MineSweeperGame***

## How Does It Work:
![first](https://user-images.githubusercontent.com/108719715/187310394-98866921-68df-4417-9153-9181a4252036.png)

## Firstly, you need to be in directory Main.java.

### You simply change ***row - column - showMines*** values in red rectangle shown above, and if you want to play as a ***'Creator Mode'*** insert ***"true"*** for showMines section or if you want to play as a ***'Player'*** simply insert ***"false"*** then you are good to go.

#### Row: Determines how tall the game board should be.
#### Column: Determines how long the game board should be.
#### Mines: There are (Yield/4) mines that hidden randomly on the playground.

### After the changes are made you can 'Run' the file.
#### If you set showMines as ***"true"***, row-column as ***"4"***; It will show you something similar to screenshot below


![ss](https://user-images.githubusercontent.com/108719715/187311874-eccbd640-071f-4c98-8ca5-1e7b37a39d34.png)
## If you see this window that is a sign that program is working correctly.
### 


### Green Square shows the locations of the mines with "*" and safe locations with "-" or "integer value".
### Purple Square shows the total number of adjacent mines that 1 block away from that location
![3333](https://user-images.githubusercontent.com/108719715/187312199-9401e148-c9e2-4bd5-ad3d-c737eca9e41d.png)

### Okay, if we enter integer inputs we may get this error,
![tyyy](https://user-images.githubusercontent.com/108719715/187312746-2ac7fe74-65e9-4acb-bda4-964e662e3b80.png)

## After the warning we can enter integers in interval, and by adding them we check the safety of that location;
![4343](https://user-images.githubusercontent.com/108719715/187315679-406ce48a-9643-49b0-9d7a-c3397aae9d74.png)


## By doing this until there are no more safe locations, you win the game.
## If you step on a mine you lose simple as that.


## Here is a screenshot of stepping on a mine and losing the game.
![loe](https://user-images.githubusercontent.com/108719715/187313832-d52ef87d-871d-4b7e-a7f6-c5bfe3e02c5f.png)
### No matter how many steps you take, if you step on a mine and lose the game, it will automatically shows the mine locations and progress you made so you can see how close you are to victory.

## Here is a screenshot of completing all steps without failure and winning the game.

![wonn](https://user-images.githubusercontent.com/108719715/187314122-67ed6280-8446-4c36-bd9e-0eb6b85b9342.png)

## If you want to play fairly you can change showMines to false anytime you want so you dont see the mine locations in the beginning.
## And to make things more challenging feel free to increase the rows and columns of the game area.
# Thank you for visiting&playing...

