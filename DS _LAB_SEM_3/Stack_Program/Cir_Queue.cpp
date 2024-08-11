#include<stdio.h>

void insert(void);
void display(void);
void del(void);

int a[5];
int front=-1;
int rear=-1;

main()
{
	int ch;
	
	do
	{
		printf("\n Enter 0 for Exist");
		printf("\n Enter 1 for insert");
		printf("\n Enter 2 for display");
		printf("\n Enter 3 for delete");
		
		printf("\n Enter choice: ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 0:
					exit(1);
	
			case 1:
					insert();
					break;
			case 2:
					display();
					break;
			case 3:
					del();
					break;
			default:
				printf("Enter Valid Number");
		}
	}while(ch!=0);
	
	getch();
}

void insert(void)
{
	if(front==0 && rear==4)
	{
		printf("\n Circular Queue is Full ");
	}
	else if(rear==front-1)
	{
		printf("\n Circular Queue is Full ");
	}
	else
	{
		if(front==-1 && rear==-1)
		{
			front++;
			rear++;
		}
		else if(front>0 && rear==4)
		{
			rear=0;
		}
		else
		{
			rear++;
		}
		printf("\n Enter Number: ");
		scanf("%d",&a[rear]);
	}
	getch();
}

void display(void)
{
	int i;
	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty");
	}
	else
	{
		if(rear<front)
		{
			for(i=front;i<=4;i++)
			{
				printf("%d",a[i]);
			}
			for(i=0;i<=rear;i++)
			{
				printf("%d",a[i]);
			}
		}
		else
		{
			for(i=front;i<=rear;i++)
			{
				printf("\n %d",a[i]);
			}
		}
	}
	getch();
}

void del(void)
{
	if(front==-1 && rear==-1)
	{
		printf("\n Circular Queue is Empty");
	}
	else
	{
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		else if(front==0 && rear>=0)
		{
			front=0;
		}
		else
		{
			front++;
		}
	}
	getch();
}
