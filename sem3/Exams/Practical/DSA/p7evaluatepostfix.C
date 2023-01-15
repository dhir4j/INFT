#include<stdio.h>
#include<string.h>
#include<conio.h>
#define MAX 30
#define TRUE 1
#define FALSE 0
int top=-1;
int stack[MAX];
void push(char);
char pop();
void main()
{
char expr[MAX],t;
int i,valid=TRUE;
clrscr();
printf("\n\t Enter an algebraic expression:");
gets(expr);
for(i=0;i<strlen(expr);i++)
{
 if(expr[i]=='('||expr[i]=='{'||expr[i]=='[')
 push(expr[i]);
 if(expr[i]==')'||expr[i]=='}'||expr[i]==']')
 if(top==-1)/*Stack Empty*/
 valid=FALSE;
 else
 {t=pop();
 if(expr[i]==')'&&(t=='{'||t=='['))
 valid=FALSE;
 if(expr[i]=='}'&&(t=='('||t=='['))
 valid=FALSE;
 if(expr[i]==']'&&(t=='('||t=='{'))
 valid=FALSE;
}
}
if(top>=0)
valid=FALSE;
if(valid==TRUE)
printf("\n\t Valid Expression.");
else
printf("\n\t Invalid Expression");
getch();
}
void push(char item)
{
if(top==(MAX-1))
printf("\n\t Stack Overflow.");
else
{
 top=top+1;
 stack[top]=item;
}
}
char pop()
{
if(top==-1)
printf("\n\t Stack Underflow.");
else
return((stack[top--]));

}