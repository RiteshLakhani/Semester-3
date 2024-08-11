#include<stdio.h>

void insert(void);
void display(void);
void del(void);
void count(void);
void search(void);
void occ(void);
//void count(void);
//void peep(void);
//void update(void);


int a[5];
int front=-1,rear=-1;


main()
{
	int ch;
	
	do{
		
		
		printf("\n O for Exist: ");
		printf("\n 1 for Insert: ");
		printf("\n 2 for Dispaly: ");
		printf("\n 3 for del: ");
		printf("\n 4 for Count: ");
		printf("\n 5 for Search: ");
		printf("\n 6 for Occurence: ");
		//printf("\n 4 for Count:");
		//printf("\n 5 for Check Number is Present Or Not");
		//printf("\n 6 for update the Value: ");
		
		
		printf("\n Enter Choice: ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 0 : 
					exit(1);
						
			case 1 :
						insert();
						break;
						
			case 2 : 
						display();
						break;
						
			case 3 : 
						del();
						break;
			case 4 :
						count();
						break;
						
			case 5 :
						search();
						break;
						
			case 6 :
						occ();
						break;
						
			default: 	
						printf("Enter Valid Number");
		}
	}while(ch!=0);
	
	getch();
}

void insert(void)
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
		printf("\n Stack is Empty: ");	
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

void del(void)
{
	if(front==-1 && rear==-1)
	{
		printf("\n Stack is Empty");
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

void search(void)
{
	int i,n,flag=0;

	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty");
	}
	else
	{
		printf("\n Enter Number to Search:");
		scanf("%d",&n);
		
		for(i=front;i<=rear;i++)
		{
			if(a[i]==n)
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			printf("\n Number is Found: ");
		}
		else
		{
			printf("\n Number is not Found:"); 
		}
	}
	getch();
}

void occ(void)
{
	int cnt=0,i,n;
	if(front==-1 && rear==-1)
	{
		printf("\n Queue is Empty");
	}
	else
	{
		printf("\n Enter Number: ");
		scanf("%d",&n);
		for(i=front;i<=rear;i++)
		{
			if(a[i]==n)
			{
				cnt++;
			}
			
		}
		printf("total values:%d",cnt);
	}
	
	getch();
}
