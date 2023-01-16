#include <stdio.h>
#include <stdlib.h>

struct node{
    int data;
    struct node *next;
}*head;

void createList(int n);
void displayList();
void insertNodeAtBegining(int data);
void insertNodeAtEnd(int data);
void deleteNodeAtBegining();
void deleteNodeAtEnd();

int main(){
    int n, data, choice;
    printf("\nEnter total number of nodes: ");
    scanf("%d",&n);
    createList(n);

    while(1){
        printf("\n1. Insert Node At Begining");
        printf("\n2. Insert Node At End");
        printf("\n3. Delete Node At Begining");
        printf("\n4. Delete Node At End");
        printf("\n5. Display List");
        printf("\n6. Exit");
        
        printf("\n\nEnter Option: ");
        scanf("%d",&choice);
        
        switch(choice){
            case 1:
                printf("\nEnter Data to be Inserted At Begining: ");
                scanf("%d",&data);
                insertNodeAtBegining(data);
                break;
            case 2:
                printf("\nEnter Data to be Inserted At End: ");
                scanf("%d",&data);
                insertNodeAtEnd(data);
                break;
            case 3:
                deleteNodeAtBegining();
                break;
            case 4: 
                deleteNodeAtEnd();
                break;
            case 5:
		displayList();
                break;
	    default:
		clrscr();
		return 0;
        }
    }
    
}

void deleteNodeAtEnd(){
    struct node *temp1, *temp2;
    if(head == NULL){
        printf("List is Already Empty!");
    }
    else if(head->next == NULL){
        free(head);
        head = NULL;
    }
    else{
        temp1 = head;
        while(temp1->next->next != NULL){
            temp1 = temp1->next;    
        }
        temp2 = temp1->next;
        temp1->next = NULL;
        free(temp2);
    }
    printf("\nLast Node Deleted Successfully!");
}



void deleteNodeAtBegining(){
    struct node *temp;
    if(head == NULL){
        printf("\nList is Already Empty!");
        return;    
    }
    temp = head;
    head = head->next;

    free(temp);
    printf("\nSuccessfully Deleted First Node!");
}


void insertNodeAtEnd(int data){
    struct node *temp, *newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    
    newNode->data = data;
    newNode->next = NULL;
    
    if(head == NULL){
        head = newNode;
    }else{
        temp = head;
        while(temp->next != NULL){
            temp=temp->next;    
        }
        temp->next = newNode;
    }
    printf("\nData inserted at End Successfully!");    
}


void insertNodeAtBegining(int data){
    struct node *newNode;
    newNode = (struct node *)malloc(sizeof(struct node));
    
    newNode->data = data;
    newNode->next = head;
    
    head = newNode;
    printf("\nData Succesfully Inserted at the Begining!");
}

void createList(int n){
    struct node *temp, *newNode;
    int i, data;
    head = (struct node *)malloc(sizeof(struct node));
    
    printf("Enter data for node 1: ");
    scanf("%d",&data);

    head->data = data;
    head->next = NULL;
    
    temp = head;
    
    for(i=2; i<=n; i++){
        newNode = (struct node *)malloc(sizeof(struct node));
        
        printf("\nEnter data for node %d: ",i);
        scanf("%d",&data);
        
        newNode->data = data;
        newNode->next = NULL;

        temp->next = newNode;
        temp = temp->next;

    }
}

void displayList(){
    struct node *temp;
    if(head == NULL){
        printf("\nList is Empty!");
        return;    
    }
    temp = head;
    
    while(temp!=NULL){
        printf("\nData = %d",temp->data);
        temp = temp->next;
    }
}


