#include <stdio.h>

int check_unique(int *arr, int N)
{
    int check_arr[N];
    for (int i = 0; i < N; i++)
    {
        check_arr[i] = 0;
    }
    for (int i = 0; i < N; i++)
    {
        check_arr[arr[i] - 1] += 1;
        if (check_arr[arr[i] - 1] == 2)
            return 0;
    }
    return 1;
}
void permutation(int *arr, int N, int k)
{
    int lastIndex;

    if (k == 0)
    {
        if (check_unique(arr, N))
        {
            for (int i = 0; i < N - 1; i++)
            {
                printf("%d ", arr[i]);
            }
            printf("%d\n", arr[N - 1]);
        }
        return ;
    }
    lastIndex = N - k;
    for (int i = 0; i < N; i++)
    {
        arr[lastIndex] = i + 1;
        permutation(arr, N, k - 1);
    }
}

int main()
{
    int N;
    scanf("%d", &N);
    int arr[N];
    permutation(arr, N, N);
}