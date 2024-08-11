#include<stdio.h>

struct node{
	int no;
	struct node *next;
}*f=NULL,*r=NULL;

void insert(void);
void display(void);
void del(void);

main()
{
	int ch;
	
	do
	{
		printf("\n 0 for Exist:");
		printf("\n 1 for Insert:");
		printf("\n 2 for Display:");
		printf("\n 3 for Delete: ");
		
		printf("\n Enter choice: ");
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
					
			default: 	
					printf("Enter Valid Number");
		}
	}while(ch!=0);
	
	getch();
}

void insert (void)
{
	struct node *n;
	
	n = (struct node *)malloc(sizeof(struct node));
	
	printf("\n Enter Value-> ");
	scanf("%d",&n->no);
	
	if(f==NULL && r==NULL)
	{
		f=n;
		r=n;
		r->next=f;
	}
	else
	{
		r->next=n;
		r=n;
		r->next=f;
	}
	getch();
}

void display(void)
{
	struct node *i;
	
	if(f==NULL && r==NULL)
	{
		printf("\n List Is Empty");
	}
	else
	{
		i=f;
		do
		{
			printf("\n %d",i->no);
			i=i->next;
		}while(i!=f);
	}
	getch();
}

void del(void)
{
	struct node *i;
	struct node *j;
	int num;
	int flag=0;
	
	printf("\n Enter Number to Delete: ");
	scanf("%d",&num);
	
	//1 NODE EXIST AND THEN IT DELETE
	if(f->no==num && f->next==NULL)
	{
		f=NULL;
		r=NULL;
		flag=1;
	}//1st NODE WILL BE DELETED from list
	else if(f->no==num && f->next!=NULL)
	{
		f=f->next;
		r->next=f;
		flag=1;
	}
	else
	{
		//searching
		i=f;
		while(i->no!=num && i->next!=NULL)
		{
			j=i;
			i=i->next;
		}
		
		//Delte node from list into Middle
		if(i->no==num && i!=r)
		{
			j->next=i->next;
			flag=1;
		}
		
		//Delte node from list at the end
		if(i->no==num && i==r)
		{
			r=j;
			r->next=f;
			flag=1;
		}
	}
	
	if(flag==0)
	{
		printf("\n Value Not Found");
	}
	getch();
}
