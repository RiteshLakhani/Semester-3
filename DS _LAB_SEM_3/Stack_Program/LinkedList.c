#include<stdio.h>

struct node{
	int no;
	struct node *next;
}*f=NULL,*r=NULL;

void insert(void);
void display(void);
void del(void);
void sort(void);

main()
{
	int ch;
	
	do
	{
		printf("\n 0 for Exist:");
		printf("\n 1 for Insert:");
		printf("\n 2 for Display:");
		printf("\n 3 for Delete: ");
		printf("\n 4 for SSorting");
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
			
			case 4:
					sort();
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
		r->next=NULL;
	}
	else
	{
		r->next=n;
		r=n;
		r->next=NULL;
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
	 	for(i=f;i!=NULL;i=i->next)
		{
			printf(" %d",i->no);
			printf("\n");
		}
	}
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
			r->next=NULL;
			flag=1;
		}
	}
	
	if(flag==0)
	{
		printf("\n Value Not Found");
	}
	getch();
}

void sort()
{
	struct node *i;
	struct node *j;
	int temp;
	int swapped;
	
	if (f == NULL && r == NULL) 
	{
        printf("\n List Is Empty");
    }
    
    do
    {
    	swapped=0;
    	i=f;
    	
    	while(i->next!=NULL)
    	{
    		j=i->next;
    		
    		if(i->no > j->no)
    		{
    			temp = i->no;
                i->no = j->no;
                j->no = temp;
                swapped = 1;
			}
			i = i->next;
		}
	}while(swapped);
}
