#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct ListNode {   // 노드 타입
    element data; //데이터
    struct ListNode *link; //뒤쪽 포인터(다음 노드에 대한 포인터)
} ListNode;

// 리스트가 비어있으면 1, 아니면 0을 반환
int is_empty(ListNode *head) 
{
    if (!head) return 1;
    return 0;
}

// 오름차순으로 정렬된 위치에 값을 삽입
ListNode* add(ListNode *head, element item)
{
    ListNode *ptr = head;
    ListNode* new_node = calloc(1, sizeof(ListNode));
    if (!new_node) return 0; //null가드
    new_node->data = item;
    new_node->link = NULL;

    if (is_empty(head)) return new_node;//리스트가 비어있는지 확인
    if (head->data >= item) //노드 정렬
    {  
        new_node->link = head;
        return new_node;
    }
    else 
    {
        while (ptr->link && ptr->link->data < item) ptr = ptr->link;
        new_node->link = ptr->link;
        ptr->link = new_node;
        return head;
    }        
}

// item이 있는지 여부를 판단. 없으면 0, 있으면 1을 반환
int is_in_list(ListNode *head, element item) {
    ListNode *ptr = head;

    while (ptr)
    {
        if (ptr->data == item) return 1;
        ptr = ptr->link;
    }
    return 0;
}

// list에 item이 있으면 삭제. 없으면 삭제되지 않았다는 메세지를 출력
ListNode* delete(ListNode *head, element item)
{
    ListNode *ptr = head;
    ListNode *temp = NULL;

    if (!is_in_list(head, item))
    {  // 삭제할 노드가 없는 경우
        printf("There are no items to delete.\n");
        return head;
    }
    while (ptr->data != item)
    {
        temp = ptr;
        ptr = ptr->link;
    }

    if (temp == NULL)
    {  // 첫 번째 노드를 삭제하는 경우
        head = ptr->link;
    }
    else temp->link = ptr->link;
    free(ptr);
    return head;   
}

// 리스트의 길이를 반환
int get_length(ListNode *head) 
{
    ListNode *ptr = head;
    int length = 0;
    while (ptr) {
        length++;
        ptr = ptr->link;
    }
    return length;
}

// 리스트 전체 아이템을 출력
void display(ListNode *head)
{
    ListNode *ptr = head;
    while (ptr)
    {
        printf("%d->", ptr->data);
        ptr = ptr->link;
    }
    printf("NULL\n");
}

// 테스트 프로그램
int main(void)
{
    int i;
    ListNode *head = NULL;

    for (i = 0; i < 5; i++) {
        head = add(head, i);
    }
    display(head);

    for (i = 3; i < 8; i++) {
        head = add(head, i);
    }
    display(head);
    printf("length of list: %d\n", get_length(head));

    head = delete(head, 7);
    display(head);
    head = delete(head, 6);
    display(head);
    head = delete(head, 0);
    display(head);
    head = delete(head, 0);
    display(head);
    
    return 0;
}
