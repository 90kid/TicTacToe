const buttons = document.getElementsByClassName("btn");

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
}

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
            turn = 2
            if(checkIfWin(player1)===true){
                init()
            }
        }
        else if(turn===2 && board[i]===' '){
            buttons[i].textContent = player2
            board[i] = player2
            turn = 1
            if(checkIfWin(player2)===true){
                init()
            }
        }
    })
}

let checkIfWin = (player) => {
    if(checkIfWinDiagonal(player)===true)
        return true
    if(checkIfWinStraight(player)===true)
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