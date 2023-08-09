const readline = require ("readline");

let playerName = [];

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let server = {
    numberToGuess: Math.floor(Math.random()*100)+1,
    checkGuess: function (guess){
        if (guess<this.numberToGuess) {
            return "Your guess is too low!";
        } else if (guess>this.numberToGuess) {
            return "Your guess is too high!";
        }else{
            return "You Guessed right!";
        }
    }
}

function getGuessFromPlayer(players, round, playerIndex, callback){
    rl.question(`Player ${players[playerIndex]} Round ${4-round}, guess between 1 and 100: `, (num)=>{
        const number = Number(num);
        if(isNaN(number) || number <1 || number > 100 ){
            console.log("Invalid number!");
            getGuessFromPlayer(players, round, playerIndex, callback)
        }else{
            console.log(`Player ${players[playerIndex]} guessed ${number}`);
            console.log(server.checkGuess(number));
            getGuessFromPlayer(players, round, playerIndex + 1, callback)
        }
    })
}

function startGame(players) {
    let tries = 3;
    let round = 1;
    let currentPlayerIndex = 0;
    const nextRound = ()=>{
        if (round<=tries) {
            getGuessFromPlayer(players, round, currentPlayerIndex,()=>{
                round++;
                nextRound();
            })
        }else{
            rl.close();
            console.log("Game over! " + server.numberToGuess);
        }
    }
    console.log("Game Start! ");
    nextRound();
}

rl.question("Enter number of players: ", (num)=>{
    const numPlayer = Number(num);
    if ( !isNaN(numPlayer) || numPlayer > 1 ) {
        let count = numPlayer;
        const addPlayer = ()=>{
            rl.question("Enter player name: ",(name)=>{
                playerName.push(name);
                console.log(`Player ${name} added`);
                count--;
                if(count>0){
                    addPlayer()
                }else{
                    startGame(playerName)
                }
            })
        }
        addPlayer();
    }else{
        console.log("Please enter a valid number! ");
        rl.close();
    }
})


//My Code
// const numberToGuess = Math.floor(Math.random()*100)+1;

// class Player {
//     constructor(name) {
//         this.name = name;
//         this.nbrOfGuess = 3;
//     }

//     checkGuess(){
//         this.nbrOfGuess--;
//         if (guess<this.numberToGuess) {
//             return "Your guess is too low!";
//         } else if (guess>this.numberToGuess) {
//             return "Your guess is too high!";
//         }else{
//             return "You Guessed right!";
//         }
//     }
// }