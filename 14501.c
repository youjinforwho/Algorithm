#include <stdio.h>

void greedy_baekjoon(int N, int k, int *T, int *P, int *max, int money)
{
    if (k == N)

    for (int i = 0; i < N; i++)
    {
        if (k + i > N)
            return ;
        money += P[k + i];
        k += T[i];
        greedy_baekjoon(N, k, T, P, max, money);
    }
}
int main()
{
    int N, max = 0;
    scanf("%d", &N);
    int T[N], P[N];
    for (int i = 0; i < N; i++)
    {
        scanf("%d %d", &T[i], &P[i]);
    }
    greedy_baekjoon(N, 0, T, P, &max, 0);
}