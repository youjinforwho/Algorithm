#include <stdio.h>

int main()
{
    char chess[9][9];
    int count = 0;

    for (int i = 0; i < 8; i++)
        scanf("%s", chess[i]);
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {
            if ((i % 2) && (j % 2) && (chess[i][j] == 'F')) count++;
            else if (!(i % 2) && !(j % 2) && (chess[i][j] == 'F')) count++;
        }
    }
    printf("%d", count);
    return 0;

}