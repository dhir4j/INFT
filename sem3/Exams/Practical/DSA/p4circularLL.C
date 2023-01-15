#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node *next;
}*last = NULL;

void insertAtBegin(int data) {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = data;
    if(last == NULL) {
        last = newNode;
        newNode->next = last;
    } else {
        newNode->next = last->next;
        last->next = newNode;
    }
    printf("Data inserted at beginning\n");
}

void insertAtEnd(int data) {
    struct node *newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = data;
    if(last == NULL) {
        last = newNode;
        newNode->next = last;
    } else {
        newNode->next = last->next;
        last->next = newNode;
        last = newNode;
    }
    printf("Data inserted at end\n");
}

void deleteAtBegin() {
    struct node *temp = last->next;
    if(last->next == last) {
	last = NULL;
    if(last == NULL){
     printf("List is empty\n");
     return;
     }
    } else {
        last->next = temp->next;
    }
    free(temp);
    printf("Data deleted at beginning\n");
}

void deleteAtEnd() {
	struct node *temp = last->next;
    if(last == NULL) {
	printf("List is empty\n");
	return;
    }
    if(last->next == last) {
        last = NULL;
    } else {
        while(temp->next != last) {
            temp = temp->next;
        }
        temp->next = last->next;
        last = temp;
    }
    free(temp);
    printf("Data deleted at end\n");
}

void display() {

	struct node *temp = last->next;
    if(last == NULL) {
        printf("List is empty\n");
        return;
    }
    do {
        printf("%d ", temp->data);
        temp = temp->next;
    } while(temp != last->next);
    printf("\n");
}

int main() {
    int choice, data;
    while(1) {
        printf("1. Insert at beginning\n");
        printf("2. Insert at end\n");
        printf("3. Delete at beginning\n");
        printf("4. Delete at end\n");
        printf("5. Display\n");
        printf("6. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);
        switch(choice) {
            case 1:
                printf("Enter data to be inserted: ");
                scanf("%d", &data);
                insertAtBegin(data);
                break;
            case 2:
		printf("Enter data to be inserted: ");
		scanf("%d", &data);
		insertAtEnd(data);
		break;
	    case 3:
		deleteAtBegin();
		break;
            case 4:
		deleteAtEnd();
		break;
	    case 5:
		display();
		break;
	    case 6:
		exit(0);
		break;
            default:
		printf("Invalid choice\n");
		break;
	   }
    }
}
