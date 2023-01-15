#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *prev;
    struct node *next;
}*start, *last;

void create(int n);
void display();
void insert_at_begin();
void insert_at_end();
void insert_at_pos();
void delete_at_begin();
void delete_at_end();
void delete_at_pos();

void main()
{
    int n, choice;

    clrscr();
    printf("Enter the number of nodes: ");
    scanf("%d", &n);
    create(n);

    while(1)
    {
        printf("\n1. Display\n2. Insert at begin\n3. Insert at end\n4. Insert at pos\n5. Delete at begin\n6. Delete at end\n7. Delete at pos\n8. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch(choice)
        {
            case 1:
                display();
                break;

            case 2:
                insert_at_begin();
                break;

            case 3:
                insert_at_end();
                break;

            case 4:
                insert_at_pos();
                break;

            case 5:
                delete_at_begin();
                break;

            case 6:
                delete_at_end();
                break;

            case 7:
                delete_at_pos();
                break;

            case 8:
                exit(0);

            default:
                printf("Invalid choice\n");
        }
    }
}

void create(int n)
{
    struct node *new, *temp;
    int i, data;

    start = (struct node *)malloc(sizeof(struct node));

    printf("Enter the data of node 1: ");
    scanf("%d", &data);

    start->data = data;
    start->prev = NULL;
    start->next = NULL;
    last = start;

    for(i=2; i<=n; i++)
    {
        new = (struct node *)malloc(sizeof(struct node));

        printf("Enter the data of node %d: ", i);
        scanf("%d", &data);

        new->data = data;
        new->prev = last;
        new->next = NULL;
        last->next = new;
        last = new;
    }
}

void display()
{
    struct node *temp;

    temp = start;

    printf("Data in the list:\n");

    while(temp != NULL)
    {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

void insert_at_begin()
{
    struct node *new;
    int data;

    new = (struct node *)malloc(sizeof(struct node));

        printf("Enter the data of the new node: ");
    scanf("%d", &data);

    new->data = data;
    new->prev = NULL;
    new->next = start;
    start->prev = new;
    start = new;
}

void insert_at_end()
{
    struct node *new;
    int data;

    new = (struct node *)malloc(sizeof(struct node));

    printf("Enter the data of the new node: ");
    scanf("%d", &data);

    new->data = data;
    new->prev = last;
    new->next = NULL;
    last->next = new;
    last = new;
}

void insert_at_pos()
{
    struct node *new, *temp;
    int pos, i, data;

    new = (struct node *)malloc(sizeof(struct node));

    printf("Enter the position where the new node is to be inserted: ");
    scanf("%d", &pos);
    printf("Enter the data of the new node: ");
    scanf("%d", &data);

    temp = start;
    for(i=1; i<pos-1; i++)
    {
        temp = temp->next;
        if(temp == NULL)
        {
            printf("There are less than %d elements\n", pos);
            return;
        }
    }

    new->data = data;
    new->prev = temp;
    new->next = temp->next;
    temp->next->prev = new;
    temp->next = new;
}

void delete_at_begin()
{
    struct node *temp;

    temp = start;
    start = start->next;
    start->prev = NULL;
    free(temp);
}

void delete_at_end()
{
    struct node *temp;

    temp = last;
    last = last->prev;
    last->next = NULL;
    free(temp);
}

void delete_at_pos()
{
    struct node *temp;
    int pos, i;

    printf("Enter the position where the node is to be deleted: ");
    scanf("%d", &pos);

    temp = start;
    for(i=1; i<pos; i++)
    {
        temp = temp->next;
        if(temp == NULL)
        {
            printf("There are less than %d elements\n", pos);
            return;
        }
    }

    temp->prev->next = temp->next;
    temp->next->prev = temp->prev;
    free(temp);
}


