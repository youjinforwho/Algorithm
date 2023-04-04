#include <stdio.h>
#define SIZE 100000

int main()
{
    int N, M;
    int a, b;
    int arr[SIZE];
    scanf("%d %d", &N, &M);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
        if (i != 0)
            arr[i] += arr[i - 1];
    }
    for (int i = 0; i < M; i++)
    {
        scanf("%d %d", &a, &b);
        if (a == 1)
            printf("%d\n", arr[b - 1]);
        else
            printf("%d\n", arr[b - 1] - arr[a - 2]);
    }
    return 0;
}