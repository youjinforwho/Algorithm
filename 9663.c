#include <stdio.h>

int check_queen(int row, int *queens)
{
	int i;

	i = 0;
	while (i < row)
	{
		if (queens[i] == queens[row])
			return (0);
		if (row - i == queens[row] - queens[i] ||
				row - i == queens[i] - queens[row])
			return (0);
		i++;
	}
	return (1);
}

void	solve_queen(int row, int *cnt, int *queens, int num)
{
	int col;

	if (row == num)
	{
		*cnt += 1;
		return ;
	}
	col = 0;
	while (col < num)
	{
		queens[row] = col;
		if (check_queen(row, queens))
			solve_queen(row + 1, cnt, queens, num);
		col++;
	}
}

void queens_puzzle(int num)
{
	int		queens[num];
	int		cnt;

	cnt = 0;
	solve_queen(0, &cnt, queens, num);
	printf("%d", cnt);
}

int main()
{
    int num;
    scanf("%d", &num);
    queens_puzzle(num);
    return 0;
}