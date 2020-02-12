const init = () => {
    player1 = "X"
    player2 = "O"
    turn = 1
    board = [
        ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' '
    ]

    for(let i = 0; i<9 ; i++){
        buttons[i].textContent = " "
    }
    retry.style.visibility = "hidden"
}

/* init start */ 
const buttons = document.getElementsByClassName("btn");
const retry = document.getElementById("retry");
let player1
let player2
let turn
let board
init()


for(let i = 0; i<9 ; i++){
    buttons[i].addEventListener("click", () => {
        if(turn===1 && board[i]===' '){
            buttons[i].textContent = player1
            board[i] = player1
            if(checkIfDraw())
                retry.style.visibility = "visible"
            if(checkIfWin(player1)){
                retry.style.visibility = "visible"
                congratulations(player1)
            }  
            else 
                turn = 2
        }
        else if(turn===2 && board[i]===' '){
            buttons[i].textContent = player2
            board[i] = player2
            if(checkIfDraw())
                retry.style.visibility = "visible"
            if(checkIfWin(player2)){
                retry.style.visibility = "visible"
                congratulations(player2)
            }
            else
                turn = 1
        }
    })
}


retry.addEventListener("click", () => {
    init()
})
/* init end */


let checkIfWin = (player) => {
    if(checkIfWinDiagonal(player))
        return true
    if(checkIfWinStraight(player))
        return true
    return false
}

let checkIfWinDiagonal = (player) => {
    if(board[0]===player && board[4]===player && board[8]===player)
        return true
    if(board[2]===player && board[4]===player && board[6]===player)
        return true
    return false
}

let checkIfWinStraight = (player) => {
    for(let i = 0; i<3; i++){
        if(board[0+i*3]===player&&board[1+i*3]===player&&board[2+i*3]===player)
            return true
    }
    for(let i = 0; i<3; i++){
        if(board[i]===player&&board[i+3]===player&&board[i+6]===player)
            return true
    }
    return false
}

let checkIfDraw = () => {
    for(let i = 0; i<9 ; i++){
        if(board[i] === ' ')
            return false
    }
    return true
}

let congratulations = (player) => {
    for(let i = 0; i<9 ; i++){
        buttons[i].textContent = player
    }

}