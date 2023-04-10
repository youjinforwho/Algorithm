#include <stdio.h>

void find_doomday(int N)
{
    int cnt = 1;
    int i = 1000, temp;
    int arr[4];
    while (cnt != N && N != 1)
    {
        temp = i;
        while (temp >= 100)
        {
            if (temp % 1000 == 666)
            {
                cnt++;
                break;
            }
            temp /= 10;
        }
        i++;
    }
    printf("%d", i - 1);
}

int main()
{
    int N;
    scanf("%d", &N);
    if (N == 1) printf("%d", 666);
    else find_doomday(N);
    return 0;
}