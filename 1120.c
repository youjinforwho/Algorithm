#include <stdio.h>
#include <string.h>

int bf_match(const char txt[], const char pat[])
{
    int pt = 0, pp = 0, cnt = 0;
    int flag = 1, min = 0;
    
    while (txt[pt] != '\0' && pat[pp] != '\0')
    {
        if (txt[pt] != pat[pp])
            cnt++;
        pt++;
        pp++;
        if (pat[pp] == '\0')
        {
            if (flag || min > cnt)
            {
                min = cnt;
                flag = 0;
            }
            if (txt[pt] != '\0')
            {
                pt = pt - pp + 1;
                pp = 0;
                cnt = 0;
            }
        }
    }
    return (min);
}

int main()
{
    char A[500];
    char B[500];

    scanf("%s %s", A, B);
    printf("%d", bf_match(B, A));
    
}