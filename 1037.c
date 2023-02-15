#include <stdio.h>

int main()
{
    int num;
    int min, max = 0;
    int arr[50];
    if (scanf("%d", &num))
    {
        for (int i = 0;i < num; i++)
        {
            scanf("%d", &arr[i]);
            {
                if (i == 0)
                    min = arr[0];
                if (arr[i] < min)
                    min = arr[i];
                if (arr[i] > max)
                    max = arr[i];
            }
        }
    }
    printf("%d", min*max);
}