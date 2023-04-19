#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void find_song(int *arr, int *melody)
{
    int i = 0;
    while (arr[i])
    {
        printf("hi");
        i++;
    }
    if (melody[i])
        printf("hi");
}

int main()
{
    int N, M, num;
    int cnt = 0;
    int **arr;
    int *melody;
    int *s;
    scanf("%d", &N);

    arr = (int **)malloc(sizeof(int)*N);
    if (!arr)
        return 0;
    for (int i = 0; i < N; i++)
    {
        gets_s(arr[i]);
        for (s = strtok(arr[i], " "); s; s = strtok(NULL, " "), cnt++)
            if (sscanf(s, "%d", arr[i][cnt]) < 1)
            break;
        //for (int j = 0; j < M; j++)
            //scanf("%d", arr[i][j]);
    }
    scanf("%d", &num);
    melody = (int *)malloc(sizeof(int)*num);
    for (int i = 0; i < num; i++)
        scanf("%d", melody[i]);
    for (int i = 0; i < N; i++)
        find_song(arr[i], melody);
}