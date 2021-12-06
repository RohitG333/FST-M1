print("Press R for rock, P for paper & S for scissor!!!")
pl1 = input("Player 1:")
pl2 = input("Player 2:")
if pl1!=pl2:
    if pl1=="R":
        if pl2=="P":
            print("Player 2 wins!!!")
        else:
            print("Player 1 wins!!!")
    elif pl1=="P":
        if pl2=="R":
            print("Player 1 wins!!!")
        else:
            print("Player 2 wins!!!")
    elif pl1=="S":
        if pl2=="P":
            print("Player 1 wins!!!")
        else:
            print("Player 2 wins!!!")
else:
    print("Match Tie!!!")