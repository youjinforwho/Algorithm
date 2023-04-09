#include <stdio.h>

int main()
{
    float total = 0;
    int N, max;
    scanf("%d", &N);
    int arr[N];
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
        if (i == 0) max = arr[i];
        else if (arr[i] > max) max = arr[i];
        total += arr[i];
    }
    printf("%f", (total / (max * N)) * 100);
}