--[[
Guessing game, by Zheng
]]

function showIntro()
    print [[
    ****** Fun Guessing Game
    If it is higher/lower, the computer tells you that so you only have five times to guess;
    if you guess right within five times, you win otherwise you lose
    ]]
end

--[[
Initialize the global variable thenumber
]]
function initGame()
    theNumber = math.random(64)
    print(theNumber)
end

--[[
Prompt player to enter a number
]]
function promptEnterNumber()
    print("Please guess a number between 1 and 64");
    print()
end

--[[
Guess a number
]]

function guessANumber()
    guessOK = false
    local guessNumber = 0
    repeat
        local curnumber = io.read();
        guessNumber = tonumber(curnumber)
        if guessNumber == theNumber then
            print("Congratulations! You guessed right. ")
            print()
            guessOK = true
        else if guessNumber > theNumber then
                print("Please guess lower!!")
                print()
            else
                print("Please guess higher!!")
                print()
            end
        end
    until guessOK
end
    
showIntro()

done = false -- when true the game loop ends

initGame()

promptEnterNumber()

guessANumber()
