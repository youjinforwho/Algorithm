#include <stdio.h>
#include <stdlib.h>
#define swap(type, x, y) do {type t = x; x = y; y = t;} while (0) //전역함수 swap 정의

void quick(int a[], int left, int right)
{
    int pl = left; //왼쪽 커서
    int pr = right; //오른쪽 커서
    int x = a[(pl + pr) / 2]; //그룹의 가운데 요소를 피벗으로 설정
    do {
        while (a[pl] < x) pl++;
        while (a[pr] > x) pr--;
        if (pl <= pr) //배열 a를 피벗 x를 기준으로 나눔
        {
            swap(int, a[pl], a[pr]);
            pl++;
            pr--;
        }
    } while (pl <= pr);
    if (left < pr) quick (a, left, pr);
    if (pl < right) quick (a, pl, right);
}

int main(void)
{
    int nx;
    int *x;
    scanf("%d", &nx);
    x = calloc(nx, sizeof(int));
    for (int i = 0; i < nx; i++)
        scanf("%d", &x[i]);
    quick(x, 0, nx - 1); //left: 0번 인덱스, right: 마지막 인덱스로 두고 시작
    for (int i = 0; i < nx; i++)
        printf("%d ", x[i]); //정렬 결과 출력
    free(x); //메모리 할당 해제

    return 0;
}