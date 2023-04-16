#include <stdio.h>

int find_goldminsu(int N)
{
    while (N > 0)
    {
        if (N % 10 != 4 && N % 10 != 7) return 0;
        N /= 10;
    }
    return 1;
}
int main()
{
    int N;
    scanf("%d", &N);
    while (!find_goldminsu(N)) N--;
    printf("%d", N);
}