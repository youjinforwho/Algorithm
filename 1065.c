#include <stdio.h>

int find_hansu(int N)
{
    int arr[3];
    int cnt = 0;

    for (int i = N; i > 99; i--)
    {
        arr[0] = i / 100;
        arr[1] = (i % 100) / 10;
        arr[2] = i % 10;
        if (arr[0] - arr[1] == arr[1] - arr[2]) cnt++;
    }
    return cnt;
}

int main()
{
    int N;
    int res;
    scanf("%d", &N);
    if (N >= 100) printf("%d", 99 + find_hansu(N));
    else printf("%d", N);
}