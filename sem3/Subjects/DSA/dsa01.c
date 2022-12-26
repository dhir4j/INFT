#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int data;
    struct Node *next;
};
void Traverse(struct Node *ptr)
{
    while (ptr != NULL)
    {
        printf("%d\n", ptr->data);
        ptr = ptr->next;
    }
}
struct Node *deleteFirst(struct Node *head)
{
    struct Node *ptr = head;
    head = head->next;
    free(ptr);
    return head;
}

int main()
{
    struct Node *head;
    struct Node *second;
    struct Node *third;

    int inp1, inp2, inp3;
    printf("Enter data 1: \n");
    scanf("%d", &inp1);
    printf("Enter data 2: \n");
    scanf("%d", &inp2);
    printf("Enter data 3: \n");
    scanf("%d", &inp3);

    head = (struct Node *)malloc(sizeof(struct Node));
    second = (struct Node *)malloc(sizeof(struct Node));
    third = (struct Node *)malloc(sizeof(struct Node));
    head->data = inp1;
    head->next = second;

    second->data = inp2;
    second->next = third;

    third->data = inp3;
    third->next = NULL;

    head = deleteFirst(head);
    printf("\nLinked list after deletion of data 1: \n");
    Traverse(head);

    return 0;
}