#include <stdio.h>

int youngsik(int a)
{
    int b = a / 30 + 1;
    return (b * 10);
}

int minsik(int a)
{
    int b = a / 60 + 1;
    return (b * 15);
}

int main()
{
    int N, calltime;
    int exp_y = 0;
    int exp_m = 0;
    scanf("%d", &N);
    for (int i = 0; i < N; i++)
    {
        scanf("%d", &calltime);
        exp_y += youngsik(calltime);
        exp_m += minsik(calltime);
    }
    if (exp_y > exp_m) printf("M %d", exp_m);
    else if (exp_y == exp_m) printf("Y M %d", exp_m);
    else printf("Y %d", exp_y);

    return 0;
}