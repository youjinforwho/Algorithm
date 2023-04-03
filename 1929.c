#include <stdio.h>

int is_prime(int a)
{
    if (a == 1) return 0; 
    for (int i = 2; (i * i) <= a; i++)
        if (a % i == 0) return 0;
    return 1;
}

int main()
{
    int M, N;
    scanf("%d %d", &M, &N);

    for (int i = M; i <= N; i++)
        if (is_prime(i)) printf("%d\n", i);
}