#include <stdio.h>

void reverse_matrix(int M, char (*arr)[M + 1], int col, int row)
{
    for (int i = 0; i < 3; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            if (arr[col + i][row + j] == '1') arr[col + i][row + j] = '0';
            else if (arr[col + i][row + j] == '0') arr[col + i][row + j] = '1';
        }
    }
}

int main()
{
    int N, M;
    int count = 0;
    scanf("%d %d", &N, &M);
    char arr[N + 1][M + 1];
    char ans_arr[N + 1][M + 1];
    for (int i = 0; i < N; i++)
        scanf("%s", arr[i]);
    for (int i = 0; i < N; i++)
        scanf("%s", ans_arr[i]);
    for (int i = 0; i < N - 2; i++)
    {
        for (int j = 0; j < M - 2; j++)
        {
            if (arr[i][j] != ans_arr[i][j])
            {
                reverse_matrix(M, arr, i, j);
                count++;
            }
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (arr[i][j] != ans_arr[i][j])
            {
                printf("-1");
                return 0;
            }
        }
    }
    printf("%d", count);
    return 0;
}