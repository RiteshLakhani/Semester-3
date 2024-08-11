#include<stdio.h>

void addRare(void);
void display(void);
void delFront(void);
void count(void);
void addFront(void);
void delRear(void);


int a[5];
int front=-1,rear=-1;


main()
{
	int ch;
	
	do{
		
		
		printf("\n O for Exist: ");
		printf("\n 1 for addRare: ");
		printf("\n 2 for Dispaly: ");
		printf("\n 3 for delFront: ");
		printf("\n 4 for Count: ");
		printf("\n 5 for addFront: ");
		printf("\n 6 for delRear: ");
			
		printf("\n Enter Choice: ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 0 : 
					exit(1);
						
			case 1 :
						addRare();
						break;
						
			case 2 : 
						display();
						break;
						
			case 3 : 
						delFront();
						break;
			case 4 :
						count();
						break;
			case 5 :
						addFront();
						break;
			case 6 :
						delRear();
						break;
						
			default: 	
						printf("Enter Valid Number");
		}
	}while(ch!=0);
	
	getch();
}

void addRare(void)
{
	if(rear==4)
	{
		printf("\n Queue is Full");
	}
	else
	{
		if(front==-1 && rear==-1)
		{
			front++;
			rear++;
		}
		else
		{
			rear++;
		}
		printf("Enter Value: ");
		scanf("%d",&a[rear]);
	}
	getch();
}

void display(void)
{
	int i;
	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty: ");	
	}	
	else
	{
		for(i=front;i<=rear;i++)
		{
			printf("\n %d",a[i]);
		}
	}
	getch();
}

void delFront(void)
{
	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty");
	}
	else
	{
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		else
		{
			front++;
		}
	}
	getch();
}

void count(void)
{
	int cnt=0,i;
	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty");
	}
	else
	{
		for(i=front;i<=rear;i++)
		{
			cnt++;
		}
		printf("total values:%d",cnt);
	}
	
	getch();
}

void addFront(void)
{
	if(front==0)
	{
		printf("\n Dequeue is Full");
	}
	else
	{
		if(front==-1 && rear==-1)
		{
			front++;
			rear++;
		}
		else
		{
			front=front-1;
		}
		printf("Enter Value: ");
		scanf("%d",&a[front]);
	}
}

void delRear(void)
{
	if(front==-1 && rear==-1)
	{
		printf("\n Dequeue is Empty...");
	}
	else
	{
		if(front==rear)
		{
			front=-1;
			rear=-1;
		}
		else
		{
			rear=rear-1;
		}
	}
}
