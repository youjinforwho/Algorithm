#include <stdio.h>
#define SIZE 30000

int main()
{
    int N, j, num, temp, max = 0, cnt = 0;
    int arr[SIZE];
    scanf("%d", &N);
    arr[0] = N;
    for (int i = N/2; i <= N; i++)
    {
        j = 2;
        arr[1] = i;
        arr[2] = N - i;
        while (arr[j++] >= 0)
        {
            arr[j] = arr[j - 2] - arr[j - 1];
            cnt++;
        }
        if (max < cnt)
        {
            max = cnt;
            num = i;
        }
        cnt = 0;
    }
    printf("%d\n%d %d ", max+2, N, num);
    while (N - num >= 0)
    {
        printf("%d ", N - num);
        temp = N - num;
        N = num;
        num = temp;
    }
    return 0;
}
