#include <stdio.h>

int main()
{
    char docs[2501];
    char words[51];
    int docs_len = -1, words_len = -1;
    int i = 0, j = 0, temp;
    int res = 0;

    do {
        docs_len++;
        scanf("%c", &docs[docs_len]);
    } while (docs[docs_len] != '\n');
    do {
        words_len++;
        scanf("%c", &words[words_len]);
    } while (words[words_len] != '\n');
    while (docs[i] != '\n')
    {
        if (docs[i] == words[0])
        {
            temp = i;
            j = 0;
            while (docs[i] != '\n' && words[j] != '\n' && docs[i] == words[j])
            {
                i++;
                j++;
            }
            if (j == words_len) res++;
            else i = temp + 1;
        }
        else
            i++;
    }
    printf("%d", res);

}