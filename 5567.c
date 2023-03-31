#include <stdio.h>
int check(int a, int arr[], int size)
{
    for (int i = 0; i < size; i++)
        if (arr[i] == a) return 1;
    return 0;
}
int main()
{
    int n, m, j = 0, cnt = 0;
    scanf("%d", &n);
    scanf("%d", &m);
    int arr[m][2];
    int friend[n];
    for (int i = 0; i < m; i++)
    {
        scanf("%d %d", &arr[i][0], &arr[i][1]);
        if (arr[i][0] == 1) friend[j++] = arr[i][1];
        if (arr[i][1] == 1) friend[j++] = arr[i][0];
    }
    int size = j;
    for (int i = 0; i < m; i++)
    {
        if (check(arr[i][0], friend, size)) friend[j++] = arr[i][1];
        if (check(arr[i][1], friend, size)) friend[j++] = arr[i][0];
    }
    for (int i = 0; i < j; i++)
        if (!check(friend[i], friend, i) && friend[i] != 1) cnt++;
    printf("%d", cnt);
    return 0;
}