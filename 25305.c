#include <stdio.h>
#include <stdlib.h>
#define swap(type, x, y) do {type t = x; x = y; y = t;} while (0)

void quick(int left, int right, int arr[])
{
    int pl = left;
    int pr = right;
    int pivot = arr[(pl + pr) / 2];

    do {
        while (arr[pl] > pivot) pl++;
        while (arr[pr] < pivot) pr--;
        if (pl <= pr)
        {
            swap(int, arr[pl], arr[pr]);
            pl++;
            pr--;
        }
    } while (pl <= pr);
    if (left < pr) quick(left, pr, arr);
    if (pl < right) quick(pl, right, arr);
}

int main()
{
    int N, k;
    int *arr;
    scanf("%d %d", &N, &k);
    arr = calloc(N, sizeof(int));
    for (int i = 0; i < N; i++)
        scanf("%d", &arr[i]);
    quick(0, N - 1, arr);
    printf("%d", arr[k - 1]);
    return 0;
}