#include <stdio.h>
#define MAX 500000

void check_unique(int (*arr)[2], int imsy, int M, int check[], int *arrow, int *max, int k)
{
    int temp = imsy;
    int init = 0;
    for (int j = k; j < M; j++)
    {
        if (arr[j][1] == imsy && check[j] == 0 && temp != arr[j][0])
        {
            temp = imsy;
            imsy = arr[j][0];
            check[j] = 1;
            if (*arrow == 0) check_unique(arr, temp, M, check, &init, max, j);
            j = -1;
            (*arrow)++;
        }
    }
    if (*max == 0) *max = *arrow;
    else if (*arrow > *max) *max = *arrow;
}
int main()
{
    int N, M;
    scanf("%d %d", &N, &M);
    int arr[M][2];
    for (int i = 0; i < M; i++)
        scanf("%d %d", &arr[i][0], &arr[i][1]);
    for (int i = 0; i < N; i++)
    {
        int j = 0;
        int check[MAX] ={0, };
        int arrow = 0;
        int max = 0;
        check_unique(arr, i + 1, M, check, &arrow, &max, 0);
        printf("%d ", max + 1);
    }
    return 0;
}