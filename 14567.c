#include <stdio.h>
#define MAX 500000
void check_unique(int (*arr)[2], int imsy, int M, int check[], int *arrow, int *a)
{
    int temp = imsy;
    int flag = 0;
    for (int j = 0; j < M; j++)
    {
        if (arr[j][1] == imsy && check[j] == 0 && temp != arr[j][0])
        {
            if (!flag) (*a) = j;
            flag = 1;
            temp = imsy;
            imsy = arr[j][0];
            check[j] = 1;
            j = -1;
            (*arrow)++;
        }
    }
    if (!flag) (*a) = M;
}
int main()
{
    int N, M;
    scanf("%d %d", &N, &M);
    int arr[M][2];
    for (int i = 0; i < M; i++)
        scanf("%d %d", &arr[i][0], &arr[i][1]);
    for (int i = 0; i < N; i++)
    {
        int j = 0;
        int check[MAX] ={0, };
        int arrow = 0;
        int max;
        check_unique(arr, i + 1, M, check, &arrow, &j);
        max = arrow;
        for (int k = j; k < M; k++)
        {
            if ( arr[k][1] == (i + 1) && check[k] == 0)
            {
                arrow = 0;
                check_unique(arr, i + 1, M, check, &arrow, &j);
                if (max < arrow) max = arrow;
            }
        }
        if (i != N - 1)printf("%d ", max + 1);
        else printf("%d", max + 1);
    }
    return 0;
}