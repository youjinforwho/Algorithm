#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char subject[51];
    float credit;
    char grade[3];
} Graduate;


int main()
{
    float score = 0.0;
    float total = 0.0;
    float cnt = 0.0;

    Graduate *chihun = (Graduate *)malloc(sizeof(Graduate)*20);
    for (int i = 0; i < 20; i++)
        scanf("%s %f %s", chihun[i].subject, &chihun[i].credit, chihun[i].grade);
    for (int i = 0; i < 20; i++)
    {
        switch (chihun[i].grade[0])
        {
            case 'A':
                score += 4.0;
                break;
            case 'B':
                score += 3.0;
                break;
            case 'C':
                score += 2.0;
                break;
            case 'D':
                score += 1.0;
                break;
            default:
                score += 0.0;
        }
        if (chihun[i].grade[1] == '+')
            score += 0.5;
        total += score * chihun[i].credit;
        score = 0.0;
        if (chihun[i].grade[0] != 'P')
            cnt += chihun[i].credit;
    }
    printf("%f", total/cnt);
    return 0;

}