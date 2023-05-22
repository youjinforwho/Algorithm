#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int key;
    int from;
} element;

typedef struct {
    int heap_size;
} HeapType;   // 히프 타입
   

//생성함수
    HeapType* create()
    {
        return(HeapType*)malloc(sizeof(HeapType));
    }

// 초기화함수
void init(HeapType* h) {
    h->heap_size = 0;
}


// 최대 힙을 구성하는 함수 arr[]은 힙을 구성하기 위한 입력 배열이다
void max_heap(int arr[], int n, int i) {
    int largest = i;  // 현재 노드를 가장 큰 값으로 설정
    int l_child = 2 * i + 1;  // 왼쪽 자식 노드
    int r_child = 2 * i + 2;  // 오른쪽 자식 노드

    // 왼쪽 자식이 루트보다 크다면 largest를 왼쪽 자식으로 변경
    if (l_child < n && arr[l_child] > arr[largest])
        largest = l_child;

    // 오른쪽 자식이 루트보다 크다면 largest를 오른쪽 자식으로 변경
    if (r_child < n && arr[r_child] > arr[largest])
        largest =  r_child;

    // largest가 루트가 아니라면 힙을 재구성
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;

        // 재구성된 서브 힙에 대해 재귀적으로 힙을 구성
        max_heap(arr, n, largest);
    }
}

// 최대 힙 정렬 함수
void heapSort(int arr[], int n) {
    // 배열을 최대 힙으로 변환
    for (int i = n / 2 - 1; i >= 0; i--)
        max_heap(arr, n, i);

    // 최대 힙에서 요소를 하나씩 추출하여 배열을 정렬
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;

        // 힙의 크기를 줄여서 정렬된 부분을 제외하고 다시 힙을 구성
        max_heap(arr, i, 0);
    }
}

// 정렬된 배열을 내림차순으로 출력하는 함수
void printArray(int arr[], int n) {
    for (int i = n - 1; i >= 0; --i)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    // 3개의 내림차순으로 정렬된 2차원 배열
    int array[3][10] = {
        {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
        {20, 19, 18, 17, 16, 15, 14, 13, 12, 11},
        {30, 29, 28, 27, 26, 25, 24, 23, 22, 21}
    };
    

    // 2차원 배열을 1차원 배열 merged_array로 변환
    int merged_array[30];
    int index = 0;
    for (int i = 0; i < 3; ++i) {
        for (int j = 0; j < 10; ++j) {
            merged_array[index] = array[i][j];
            index++;
        }
    }

    int mergedSize = 3 * 10;

    // 변환된 배열을 최대 힙으로 정렬
    heapSort(merged_array, mergedSize);

    // 결과 출력
    for (int i = mergedSize - 1; i >= 0; i--) {
    printf("%d ", merged_array[i]);
    }
    printf("\n");

    return 0;
}