#include <stdio.h>

void   recursive(int lastIndex, int size, int k, int n, int *cnt)
{
   char a;
   int i;
   int	min;

   if (k == 0)
   {   //모두 뽑은 경우 print하고 return
      *cnt += 1;
	   return ;
      if (*cnt == 1000000007)
         *cnt = 0;
   }
   if (size == k)
   {   //처음 뽑는 경우
      min = 0;
   }
   else
   {
      min = lastIndex + 1; //중복을 막기 위해 오름차순으로 뽑음
   }//바로 전에 뽑은 수+1 해라
   while (min < n)
   {
      printf("lastIndex : %d min: %d size: %d k: %d, cnt : %d\n", lastIndex, min, size, k, *cnt);
      lastIndex = min;
      recursive(lastIndex, size, k - 1, n, cnt);
      min++;
   }
}


int   main(void)
{
    int cnt = 0;
    int n, r;
    //long long res;

    scanf("%d %d", &n, &r);
    recursive(0, r, r, n, &cnt);
    printf("%d", cnt);

    return 0;
}
