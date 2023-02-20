#include <stdio.h>

int main()
{
    int num;
    int a, b;
    int cnt = 0;
    int arr[100][100] = {{0, 0},};

    scanf("%d", &num);
    for (int i = 0; i < num; i++)
    {
        scanf("%d %d", &a, &b);
        for (int col = a; col < a + 10; col++)
        {
            for (int row = b; row < b + 10; row++)
            {
                arr[col][row] = 1;
            }
        }
    }
    for (int i = 0; i < 100; i++)
        for (int j = 0; j < 100; j++)
            if (arr[i][j] == 1) cnt++;
    printf("%d", cnt);
    return 0;
}