#include <stdio.h>

int can_div(int a, int b)
{
    int i = 1;
    while ( i <= a/2)
    {
        if (a % b == 0)
            return b;
    }
    return (1);
}

int main()
{
    int N, res;
    int arr[100];
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", arr[i]);
    }
    for (int i = 0; i < N; i++)
    {
        res = can_div(arr[0], arr[i + 1])
        printf("%d/%d\n", arr[0]/res, )
    }
}