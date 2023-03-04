#include <stdio.h>

int sort_array(int *arr, int size)
{
	int	temp;

	for (int i = 0; i < size - 1; i++)
	{
		for (int j = 0; j < size - 1 - i; j++)
		{
            if (arr[j] == arr[j + 1])
                return 1;
			if (arr[j] > arr[j + 1])
			{
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
    return 0;
}


void permutation(int *res_arr, int *arr, int N, int M, int k)
{
    int lastIndex;
    int min;

    if (k == 0)
    {
        int dup_arr[M];
        for (int i = 0; i < M; i++)
            dup_arr[i] = res_arr[i];
        if (!sort_array(dup_arr, M))
        {
            for (int i = 0; i < M - 1; i++)
            {
                printf("%d ", res_arr[i]);
            }
            printf("%d\n", res_arr[M - 1]);
        }
        return ;
    }
    lastIndex = M - k;
    for (int i = 0; i < N; i++)
    {
        res_arr[lastIndex] = arr[i];
        permutation(res_arr, arr, N, M, k - 1);
    }
}

int main()
{
    int N, M;
    scanf("%d %d", &N, &M);
    int arr[N];
    int res_arr[N];

    for (int i = 0; i < N; i++)
    {
        scanf("%d", &arr[i]);
    }
    if (!sort_array(arr, N))
        permutation(res_arr, arr, N, M, M);
}