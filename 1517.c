# include <stdio.h>
#define MAX_SIZE 10

// 버블 정렬
void bubble_sort(int list[], int n, int *p){
  int i, j, temp;

  for(i=n-1; i>0; i--){
    // 0 ~ (i-1)까지 반복
    for(j=0; j<i; j++){
      // j번째와 j+1번째의 요소가 크기 순이 아니면 교환
      if(list[j]<list[j+1]){
        *p += 1;
        temp = list[j];
        list[j] = list[j+1];
        list[j+1] = temp;
      }
    }
  }
}

void main() {
  int i;
  int list[MAX_SIZE] = {21, 10, 12, 20, 25, 13, 15, 22, 26, 1};
  int count = 0;

  // 버블 정렬 수행
  bubble_sort(list, MAX_SIZE, &count);

  // 정렬 결과 출력
  for(i=0; i<MAX_SIZE; i++){
    printf("%d\n", list[i]);
  }
  printf("%d", count);
}