#include <stdio.h>
#include <math.h>

int square(int base, int index)
{
    if (index == 0) return 1;
    else return (base * square(base, index - 1));
}

int main()
{
    unsigned long long N, temp = 0, sum = 0;
    int cnt = 0, i = 0;
    scanf("%lld", &N);
    while (temp <= N)
        temp += square(2, cnt++);
    printf("%d %d %d\n", temp, temp - square(2, cnt - 1), cnt);
    temp -= square(2, --cnt); //temp는 1+2, cnt는 3->2
    printf("gugan 1\n");
    printf("%d", N - temp);
    while (N - temp > 1)
    {
        sum += square(3, i++);
        temp++;
    }
    printf("%d", sum + square(3, cnt));
    return 0;
}