#include <stdio.h>
#define SIZE 100000

int main()
{
    int N, K;
    int max;
    int arr[SIZE];
    scanf("%d %d", &N, &K);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
        if (i != 0)
            arr[i] += arr[i - 1];
    }
    if (N == K)
    {
        printf("%d", arr[N - 1]);
        return 0;
    }
    for (int i = 0; i <= N - K + 1; i++)
    {
        if (i == 0 && K == 1) max = arr[i];
        else if (i == 0)
        {
            if (K == 2) max = arr[1];
            else max = arr[i + K -2];
        }
        else
            if (arr[i + K - 2] - arr[i - 2] > max)
                max = arr[i + K -2] - arr[i - 2];
    }
    printf("%d", max);
    return 0;
}