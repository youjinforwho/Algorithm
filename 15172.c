# include <stdio.h>
# define MAX_SIZE 10
int sorted[MAX_SIZE]; // 추가적인 공간이 필요

// i: 정렬된 왼쪽 리스트에 대한 인덱스
// j: 정렬된 오른쪽 리스트에 대한 인덱스
// k: 정렬될 리스트에 대한 인덱스
/* 2개의 인접한 배열 list[left...mid]와 list[mid+1...right]의 합병 과정 */
/* (실제로 숫자들이 정렬되는 과정) */
void merge(int list[], int left, int mid, int right, int *p){
  int i, j, k, l;
  i = left;
  j = mid+1;
  k = left;

  /* 분할 정렬된 list의 합병 */
  while(i<=mid && j<=right){
    if(list[i]<=list[j])
    {   
        *p += 1;
        sorted[k++] = list[i++];
    }
    else
    {
        sorted[k++] = list[j++];
    }
  }

  // 남아 있는 값들을 일괄 복사
  if(i>mid){
    for(l=j; l<=right; l++)
      sorted[k++] = list[l];
  }
  // 남아 있는 값들을 일괄 복사
  else{
    for(l=i; l<=mid; l++)
      sorted[k++] = list[l];
  }

  // 배열 sorted[](임시 배열)의 리스트를 배열 list[]로 재복사
  for(l=left; l<=right; l++){
    list[l] = sorted[l];
  }
}

// 합병 정렬
void merge_sort(int list[], int left, int right, int *p){
  int mid;

  if(left<right){
    *p+=1;
    mid = (left+right)/2; // 중간 위치를 계산하여 리스트를 균등 분할 -분할(Divide)
    merge_sort(list, left, mid, p); // 앞쪽 부분 리스트 정렬 -정복(Conquer)
    merge_sort(list, mid+1, right, p); // 뒤쪽 부분 리스트 정렬 -정복(Conquer)
    merge(list, left, mid, right, p); // 정렬된 2개의 부분 배열을 합병하는 과정 -결합(Combine)
  }
}

void main(){
  int i;
  int n = MAX_SIZE;
  int list[MAX_SIZE] = {21, 10, 12, 20, 25, 13, 15, 22, 26, 1};
  int count = 0;

  // 합병 정렬 수행(left: 배열의 시작 = 0, right: 배열의 끝 = 7)
  merge_sort(list, 0, n-1, &count);

  // 정렬 결과 출력
  for(i=0; i<n; i++){
    printf("%d\n", list[i]);
  }

  printf("%d\n", count);
}