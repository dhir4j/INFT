#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
}*top = NULL;

void push(int data) {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    if(newNode == NULL) {
        printf("Stack overflow\n");
        return;
    }
    newNode->data = data;
    newNode->next = top;
    top = newNode;
    printf("Data pushed to stack\n");
}

void pop() {
    if(top == NULL) {
        printf("Stack underflow\n");
        return;
    }
    struct node *temp = top;
    top = top->next;
    free(temp);
    printf("Data popped from stack\n");
}

void display() {
    if(top == NULL) {
        printf("Stack is empty\n");
        return;
    }
    struct node *temp = top;
    while(temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int choice, data;
    while(1) {
        printf("1. Push\n");
        printf("2. Pop\n");
        printf("3. Display\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf("Enter data to be pushed: ");
                scanf("%d", &data);
                push(data);
                break;
            case 2:
                pop();
                break;
            case 3:
                display();
                break;
            case 4:
                exit(0);
            default:
                printf("Invalid choice\n");
        }
    }
    return 0;
}

