import string
import random

TARGET = 'Me thinks it is like a weasel'
RESULT_STRING = ''
ALPHABET = ' ' + string.ascii_letters
CHANCE_OF_MUTATION = 10
GENERATIONS = 100

def generateRandomString():

    global TARGET
    global RESULT_STRING
    global CHANCE_OF_MUTATION

    for i in range(len(TARGET)):
        # Sets a random char from the alphabet to each position of the string
        RESULT_STRING = RESULT_STRING + (ALPHABET[random.randint(0, len(TARGET))])

def mutate():

    global RESULT_STRING
    global ALPHABET
    global CHANCE_OF_MUTATION
    global SCORE

    # Mutates according to its mutation ratio
    if random.random() < CHANCE_OF_MUTATION:
        listOfString = list(RESULT_STRING) # Slices the RESULT_STRING
        listOfAlphabet = list(ALPHABET) # Slices the ALPHABET

        # Selects a random int between the length of the result string
        randomIntFromString = random.randint(0, len(listOfString) - 1)

        # Chooses a char from the string according to the int it chose
        randomCharFromString = listOfString[randomIntFromString]

        # Verifies if the characters in the same position are equal, mutates it to a random character from the alphabet
        # then sets the RESULT_STRING
        if randomCharFromString != TARGET[randomIntFromString]:
            listOfString[randomIntFromString] = listOfAlphabet[random.randint(0, len(listOfAlphabet) - 1)]
            RESULT_STRING = "".join(listOfString)

def generations():

    generateRandomString() # Start a random string for it to mutate
    generation = 1 # Counts the generations

    # While the strings are diferent, mutate!
    while RESULT_STRING != TARGET:
        mutate()
        print(RESULT_STRING + f" - Generation {generation}") # Prints the mutation + generation
        generation += 1 # Increases the generation by one

if __name__ == "__main__":
    generations()
