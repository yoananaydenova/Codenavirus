# Codenavirus


***Assignment***

Codenavirus is strange contagious disease. This is why:

 - One infected person will infect only one healthy person next to him each day
 - If a person is infected, he will infect the person on his right, unless the latter is already infected, then he will infect the person on his top instead, but if that person is also already infected, then he will infect the one on his left, lastly if this one is also already infected, the he will infect the one below if this one is still healthy. (The examples will clarify)
 - A newly infected person will start infecting other people one day after the infection.
 - An infected person will recover after exactly 3 days of illness, counting from the day he got infected, and he will become immune to the virus (he won't be infected anymore)

To help the WHO study this new virus, you must create a program that simulates the spread of the virus.

***Inputs***

 - world: a matrix of characters representing the proximity of people in a the world. A person is represented by "#" and empty spaces are represented by ".". One person is next to another one if they share the same row OR the same column and there is no empty space or another person between them.
 - firstInfected: an array of integer of size 2 ([row, col]) storing the coordinates of the first person to contract the virus on day 1.

***Output***

An array of 4 integers [a, b, c, d] where:

 - a : number of days until the virus stops spreading
 - b : number of infected people at the end of the spread
 - c : number of recovered people at the end
 - d : number of uninfected people

Prioritize lower indexes if there is a case where one person is about to be infected by two neighbors, in that case the neighbor with lower row/col will win (Eg. Day 3 of test 4).

***Example***

 - For
 ````
world = [["#","#","#"],   
["#","#","#"],     
["#","#","#"]]  
````

and *firstInfected* = [1, 1], the answer is [7, 3, 6, 0]

Explanation: H for healthy, I for infected, R for recovered.

````
DAY 0:
[
["H", "H", "H"],
["H", "H", "H"],
["H", "H", "H"],
]
DAY 1:
[
["H", "H", "H"],
["H", "I", "H"],
["H", "H", "H"],
]
DAY 2:
[
["H", "H", "H"],
["H", "I", "I"],
["H", "H", "H"],
]
DAY 3:
[
["H", "I", "I"],
["H", "I", "I"],
["H", "H", "H"],
]
DAY 4:
[
["I", "I", "I"],
["H", "R", "I"],
["H", "H", "I"],
]
DAY 5:
[
["I", "I", "I"],
["I", "R", "R"],
["H", "I", "I"],
]
DAY 6:
[
["I", "R", "R"],
["I", "R", "R"],
["I", "I", "I"],
]
DAY 7:
[
["R", "R", "R"],
["I", "R", "R"],
["I", "I", "R"],
]

````
 - [input] array.array.char world 
 - [input] array.integer firstInfected
 - [output] array.integer
 
