#include <stdio.h>

int main()
{
    char name[11];
    int age, weight;
    while (scanf("%s %d %d", name, &age, &weight) == 3)
    {
        if (name[0] == '#' && age == 0 && weight == 0) break;
        printf("%s ", name);
        if (age > 17 || weight >= 80) printf("Senior\n");
        else printf("Junior\n");
    }
    return 0;
}