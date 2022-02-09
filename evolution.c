#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

char ALPHABET[] =
        {
                ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o','p', 'q', 'r', 's', 't',
                'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
                'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z'
        };
int CHANCE_OF_MUTATION = 10;

void generatesRandomString(char* target, char* resultString){
    char ch;
    for (int i = 0; i < strlen(target); i++){
        ch = ALPHABET[rand() % sizeof ALPHABET];
        resultString[i] = ch;
    }
}

void mutate(char* target, char* resultString){
    int randomInt = rand() % 100;
    int randomIntFromString = rand() % (strlen(resultString) + 1);
    char randomCharFromString = resultString[randomIntFromString];

    if (randomInt < CHANCE_OF_MUTATION){
        if (resultString[randomIntFromString] != target[randomIntFromString]){
            resultString[randomIntFromString] = ALPHABET[rand() % strlen(ALPHABET)];
        }
    }
}
int main() {
    time_t t;
    char TARGET[] = "Me thinks it is like a weasel ";
    char RESULT_STRING[28];
    int generation = 1;

    srand((unsigned ) time(&t));
    generatesRandomString(TARGET, RESULT_STRING);

    clock_t start = clock();
    while(strcmp(RESULT_STRING, TARGET) != 0){
        mutate(TARGET, RESULT_STRING);
        printf("%s - Generation %d\n", RESULT_STRING, generation);
        generation++;
    }
    clock_t end = clock();
    printf("Time: %f - miliseconds", (double)(end - start) * 1000/CLOCKS_PER_SEC );

    return 0;
}
