#include <stdio.h>
#define SIZE 10000
int main()
{
    int num;
    int res;
    int arr[SIZE];
    int sum = 0, cnt = 0;
    int i = 0, j = 0;

    scanf("%d %d", &num, &res);
    for (int i = 0; i < num; i++)
    {
        scanf("%d", &arr[i]);
    }
    i = 0;
    while (i < num)
    {
        sum += arr[j];
        if (sum < res && j < num) j++;
        else
        {
            if (sum == res) cnt++;
            i++;
            j = i;
            sum = 0;
        }
    }
    printf("%d", cnt);
    return 0;
}