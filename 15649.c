#include <stdio.h>
int check_unique(int *arr, int range_max, int size)
{
    int check_arr[range_max];
    for (int i = 0; i < range_max; i++)
    {
        check_arr[i] = 0;
    }
    for (int i = 0; i < size; i++)
    {
        check_arr[arr[i] - 1] += 1;
        if (check_arr[arr[i] - 1] == 2)
            return 0;
    }
    return 1;
}

void permutation (int *arr, int range_max, int size, int k)
{
    int lastIndex;

    if (k == 0)
    {
        if (check_unique(arr, range_max, size))
        {
            for (int i = 0; i < size - 1; i++)
                printf("%d ", arr[i]);
            printf("%d\n", arr[size - 1]);
        }
        return ;
    }
    lastIndex = size - k;
    for (int i = 1; i <= range_max; i++)
    {
        arr[lastIndex] = i;
        permutation(arr, range_max, size, k - 1);
    }
    
}
int main()
{
    int arr[10];
    int N, M;

    scanf("%d %d", &N, &M);
    permutation(arr, N, M, M);
}
