#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char name[20];
    int date;
    int month;
    int year;
} Birthday;

int main()
{
    int num;
    scanf("%d", &num);
    Birthday *arr = (Birthday *)malloc(sizeof(Birthday)*num);
    for (int i = 0; i < num; i++)
        scanf("%s %d %d %d", arr[i].name, &arr[i].date, &arr[i].month, &arr[i].year);
    Birthday temp;

    for (int i = 0; i < num - 1; i++)
    {
        for (int j = 0; j < num - 1 - i; j++)
        {
            if (arr[j].year > arr[j + 1].year)
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            if (arr[j].year == arr[j + 1].year)
            {
                if (arr[j].month > arr[j + 1].month)
                {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                if (arr[j].month == arr[j + 1].month)
                {
                    if (arr[j].date > arr[j + 1].date)
                    {
                        temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }
    printf("%s\n", arr[num - 1].name);
	printf("%s\n", arr[0].name);
	return 0;
}