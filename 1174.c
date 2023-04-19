#include <stdio.h>

void   recursive(int* arr, int size, int k, int n, int *cnt, int res)
{
   char a;
   int i;
   int   lastIndex;
   int   min;
   int   item;

    if (k == 0)
    {   //모두 뽑은 경우 print하고 return
        *cnt += 1;
        if (*cnt == res)
        {
            for (int i = 0; i < size; i++)
                printf("%d", arr[i]);
        }
    return ;
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
   item = min;
   while (item < n)
   {
      arr[lastIndex] = item;
      recursive(arr, size, k - 1, n, cnt, res);
      item++;
   }
}


int   main(void)
{
    int cnt = 0;
    int n, r;
    int arr[6];

    scanf("%d", &n);
    if (n < 10)
        return (n - 1);
    else if (n < 55)
    {
        recursive(arr, 2, 2, 10, &cnt, n - 10);
    }
    //scanf("%d %d", &n, &r);

    //recursive(arr, r, r, n, &cnt);


    return 0;
}