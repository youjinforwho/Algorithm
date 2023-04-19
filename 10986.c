#include <stdio.h>
#define SIZE 1001
int main()
{
    long long N, M;
    long long arr[SIZE];
    long long sum = 0, cnt = 0;
    long long i = 0, j = 0;

    scanf("%lld %lld", &N, &M);
    for (i; i < N; i++)
    {
        scanf("%lld", &arr[i]);
    }
    i = 0;
    while (i < N)
    {
        if (j == N)
        {
            sum = 0;
            i++;
            j = i;
        }
        sum += arr[j];
        sum %= M;
        if (sum == 0 && i != N & j != N)
        {
            cnt++;
        }
        j++;
        /*if (sum < M && j < N) j++;
        else
        {
            if (sum == M) cnt++;
            i++;
            j = i;
            sum = 0;
        }*/
    }
    printf("%lld", cnt);
    return 0;
}