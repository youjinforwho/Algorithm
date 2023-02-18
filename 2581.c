#include <stdio.h>
int	check_prime(int M)
{
	int	i;

	i = 2;
	if (M <= 1)
		return (0);
	while (i <= (M / 2))
	{
		if (!(M % i))
			return (0);
		else
			i += 1;
	}
	return (1);//소수면 1
}

int main()
{
    int M, N;
    int flag = 1, res = 0, min = 0;

    scanf("%d %d", &M, &N);
    while (M <= N)
    {
        if (check_prime(M))
        {
            res += M;
            if (flag == 1)
            {
                min = M;
                flag = 0;
            }
        }
        M++;
    }
    if (res == 0)
    {
        printf("%d", -1);
        return 0;
    }
    printf("%d\n%d", res, min);
}