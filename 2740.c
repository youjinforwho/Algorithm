#include <stdio.h>

int main()
{
    int N, M, K;
    scanf("%d %d", &N, &M);
    int matrix_A[N][M];
    for (int i = 0; i < N; i++)
        for (int j = 0; j < M; j++)
            scanf("%d", &matrix_A[i][j]);
    scanf("%d %d", &M, &K);
    int matrix_B[M][K];
    for (int i = 0; i < M; i++)
        for (int j = 0; j < K; j++)
            scanf("%d", &matrix_B[i][j]);
    int matrix_C[N][K];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < K; j++)
        {
            matrix_C[i][j] = 0;
            for (int k = 0; k < M; k++)
                matrix_C[i][j] += matrix_A[i][k] * matrix_B[k][j];
            printf("%d ", matrix_C[i][j]);
        }
        printf("\n");
    }
}