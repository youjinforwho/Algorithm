#include <stdio.h>
#include <stdlib.h>

void greedy_sangeun(char *arr[], int N)
{
    for (int i = 0; i < N; i++)
        printf("%s", arr[i]);
}

int main()
{
    int N;
    char **arr;
    scanf("%d", &N);
    arr = (char **)malloc(sizeof(char *)*N);
    for (int i = 0; i < N; i++)
        scanf("%s", arr[i]);
    greedy_sangeun(arr, N);
}