#include <stdio.h>
#include <math.h>

void check_point(int d, int r, int* num) 
{
	if (d < r) (*num)++;
}

int main(void)
{
	int T, n, x1, y1, x2, y2, cx, cy, r;
	int count, d1, d2, i, j;

	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
		scanf("%d", &n);
		count = 0;
		for (j = 0; j < n; j++)
		{
			scanf("%d %d %d", &cx, &cy, &r);
			d1 = sqrt(pow(x1 - cx, 2) + pow(y1 - cy, 2)); 
			check_point(d1, r, &count);
			d2 = sqrt(pow(x2 - cx, 2) + pow(y2 - cy, 2));
			check_point(d2, r, &count);
			if ((d1 < r) && (d2 < r))
				count-=2;
		}
		printf("%d \n", count);
	}
	return 0;
}