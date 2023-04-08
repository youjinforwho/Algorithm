#include <stdio.h>
#include <stdlib.h>

typedef struct{
    char name[11];
    int age;
    int weight;
} Rugby;

int main()
{
    Rugby *arr = (Rugby *)malloc(sizeof(Rugby)*10);
    for (int i = 0; i < 10; i++)
    {
        scanf("%s %d %d", arr[i].name, &arr[i].age, &arr[i].weight);
        if (arr[i].name[0] == '#' && arr[i].age == 0 && arr[i].weight == 0) return 0;
        printf("%s ", arr[i].name);
        if (arr[i].age > 17 || arr[i].weight >= 80) printf("Senior");
        else printf("Junior\n");
    }
    return 0;
}