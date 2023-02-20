#include <stdio.h>

int sub_abs(int X, int Y)
{
    if (X > Y)
        return (X - Y);
    else
        return (Y - X);
}

int main()
{
    long long X, Y, W, S;

    scanf("%llu %llu %llu %llu", &X, &Y, &W, &S);
    if (2*W <= S)
        printf("%llu", W*(X+Y));
    else if (W >= S && sub_abs(X, Y) % 2)
        printf("%llu", (X > Y) ? S*(X - 1) + W : S*(Y - 1) + W);
    else if (W >= S && !(sub_abs(X, Y) % 2))
        printf("%llu", (X > Y) ? S*X : S*Y);
    else
        printf("%llu", (X > Y) ? S*Y + (W*(X-Y)) : S*X + (W*(Y-X)));
    return 0;
}