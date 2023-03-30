#include <stdio.h>

void swap(char *a, char *b)
{
    char temp = *a;
    *a = *b;
    *b = temp;
}

int main()
{
    int N, R, C;
    char a = 'v', b = '.';
    scanf("%d %d %d", &N, &R, &C);
    if ((R + C) % 2 != 0) swap(&a, &b);
    for (int i = 0; i < N * N; i++)
    {
        if (i != 0 && i % N == 0)
        {
            printf("\n");
            if (N % 2 == 0) swap(&a, &b);
        }
        printf("%c", a);
        swap(&a, &b);
    }
}