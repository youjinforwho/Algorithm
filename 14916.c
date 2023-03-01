#include <stdio.h>

int main()
{
    int n;
    int x, y = 1;

    scanf("%d", &n);
    x = n / 5;
    while (x > -1 && y > 0)
    {
        y = n - 5 * x;
        if (y % 2 == 0)
        {
            printf("%d", x + y / 2);
            return 0;
        }
        x--;
    }
    printf("-1");
    return 0;
}