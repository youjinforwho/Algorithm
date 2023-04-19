#include <stdio.h>
#define SIZE 5000000
int main()
{
    long long N;
    long long arr[SIZE];
    long long sum = 0, cnt = 1;
    long long i = 0, j = 0;

    scanf("%lld", &N);
    for (i; i < N; i++)
    {
        arr[i] = i + 1;
    }
    i = 0;
    while (i <= N/2)
    {
        sum += arr[j];
        if (sum >= N)
        {
            if (sum == N)
                cnt++;
            sum = 0;
            i++;
            j = i -1;
        }
        j++;
    }
    printf("%lld", cnt);
    return 0;
}