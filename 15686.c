#include <stdio.h>

void   recursive(int* arr, int n, int size, int k)
{
    char a;
    int i;
    int   lastIndex = 0;
    int   min = 0, item = 0;

    while (item < n)
    {
        arr[lastIndex] = item;
        while (k >= 0)
        {
            if (k == 0)
            {   //모두 뽑은 경우 print하고 return
                for (int i = 0;i< size; i++)
                    printf("%d", arr[i]);
                printf("\n");
            }
            lastIndex = size - k; // 가장 최근에 뽑힌 수가 저장된 위치 index
            if (size == k)
            {   //처음 뽑는 경우
                min = 0;
            }
            else
            {
                min = arr[lastIndex - 1] + 1; //중복을 막기 위해 오름차순으로 뽑음
            }//바로 전에 뽑은 수+1 해라
            k--;
        }
        k = size;
        item = min;
        item++;
    }
}

int   main(void)
{
    int n, r;
    long long res;
    int arr[10];

    //scanf("%d %d", &n, &r);
    recursive(arr, 5, 3, 3);

    return 0;
}