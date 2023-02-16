#include <stdio.h>
#define SIZE 10000
int main()
{
    int num; //수열 수
    int res; //수열 합
    int arr[SIZE];
    int sum, cnt = 0;

    scanf("%d %d", &num, &res);
    for (int i = 0; i < num; i++)
    {
        scanf("%d", &arr[i]);
    }

    for (int i = 0; i < num; i++)
    {
        sum = arr[i];
        if (arr[i] == res) cnt++;
        for (int j = i + 1; j < num; j++)
        {
            sum += arr[j];
            if (sum == res)
            {
                cnt++;
                break;
            }
        }
    }

    printf("%d", cnt);
    return 0;
}