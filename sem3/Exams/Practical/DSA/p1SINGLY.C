#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
}*head;

void createList(int n);
void insertNodeAtBeginning(int data);
void insertNodeAtEnd(int data);
void deleteNodeAtBeginning();
void deleteNodeAtEnd();
void displayList();

int main()
{
    int n, data, choice;

    printf("Enter the total number of nodes: ");
    scanf("%d", &n);
    createList(n);

    while(1)
    {
        printf("\n1. Insert node at beginning.\n");
        printf("2. Insert node at end.\n");
        printf("3. Delete node from beginning.\n");
        printf("4. Delete node from end.\n");
        printf("5. Display list.\n");
        printf("6. Exit.\n");

        printf("Enter your choice: ");
        scanf("%d", &choice);

        if(choice==1)
        {
            printf("Enter data of first node: ");
            scanf("%d", &data);
            insertNodeAtBeginning(data);
        }
        else if(choice==2)
        {
            printf("Enter data of last node: ");
            scanf("%d", &data);
            insertNodeAtEnd(data);
        }
        else if(choice==3)
        {
            deleteNodeAtBeginning();
        }
        else if(choice==4)
        {
            deleteNodeAtEnd();
        }
        else if(choice==5)
        {
            displayList();
        }
        else
        {
            break;
        }
    }

    return 0;
}

void createList(int n)
{
    struct node *newNode, *temp;
    int data, i;

    head = (struct node *)malloc(sizeof(struct node));

    printf("Enter the data of node 1: ");
    scanf("%d", &data);

    head->data = data;
    head->next = NULL;

    temp = head;

    for(i=2; i<=n; i++)
    {
        newNode = (struct node *)malloc(sizeof(struct node));

        printf("Enter the data of node %d: ", i);
        scanf("%d", &data);

        newNode->data = data;
        newNode->next = NULL;

        temp->next = newNode;
        temp = temp->next;
    }
}

void insertNodeAtBeginning(int data)
{
    struct node *newNode;

    newNode = (struct node*)malloc(sizeof(struct node));

    newNode->data = data;
    newNode->next = head;

    head = newNode;

    printf("Data inserted successfully at the beginning\n");
}

void insertNodeAtEnd(int data)
{
    struct node *newNode, *temp;

    newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = data;
    newNode->next = NULL;

    temp = head;

    while(temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;

    printf("Data inserted successfully at the end\n");
}

void deleteNodeAtBeginning()
{
struct node *temp;
if(head == NULL)
{
    printf("List is already empty.\n");
    return;
}

temp = head;
head = head->next;

printf("Data deleted successfully from the beginning\n");

free(temp);
}

void deleteNodeAtEnd()
{
struct node *temp1, *temp2;
if(head == NULL)
{
    printf("List is already empty.\n");
    return;
}

temp1 = head;
temp2 = head;

while(temp1->next != NULL)
{
    temp2 = temp1;
    temp1 = temp1->next;
}

temp2->next = NULL;

printf("Data deleted successfully from the end\n");

free(temp1);
}

void displayList()
{
struct node *temp;
if(head == NULL)
{
    printf("List is empty.\n");
    return;
}

temp = head;
while(temp != NULL)
{
    printf("Data = %d\n", temp->data);
    temp = temp->next;
}
}

