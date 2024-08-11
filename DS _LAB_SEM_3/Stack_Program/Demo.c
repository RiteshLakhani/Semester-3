#include<stdio.h>

void push(void);
void display(void);
void pop(void);
void count(void);
void peep(void);
void update(void);


int a[5];
int top=-1;

main()
{
	int ch;
	
	do{
		
		
		printf("\n O for Exist: ");
		printf("\n 1 for Push: ");
		printf("\n 2 for Dispaly: ");
		printf("\n 3 for Pop: ");
		printf("\n 4 for Count:");
		printf("\n 5 for Check Number is Present Or Not");
		printf("\n 6 for update the Value: ");
		
		
		printf("\n Enter Choice: ");
		scanf("%d",&ch);
		
		switch(ch)
		{
			case 0 : 
					exit(1);
						
			case 1 :
						push();
						break;
						
			case 2 : 
						display();
						break;
						
			case 3 : 
						pop();
						break;
			
			case 4 : 
						count();
						break;
			
			case 5 :
						peep();
						break;
			
			case 6: 
						update();
						break;
			
			default: 	
						printf("Enter Valid Number");
		}
	}while(ch!=0);
	
	getch();
}

void push(void)
{
	if(top==4)
	{
		printf("\n Stack is Full");
	}
	else
	{
		top++;
		printf("\n Enter Value: ");
		scanf("%d",&a[top]);
	}
	getch();
}

void display(void)
{
	int i;
	if(top==-1)
	{
		printf("\n Stack is Empty: ");	
	}	
	else
	{
		for(i=top;i>=0;i--)
		{
			printf("\n %d",a[i]);
		}
	}
	getch();
}

void pop(void)
{
	if(top==-1)
	{
		printf("\n Stack is Empty");
	}
	else
	{
		top--;
	}
	getch();
}

void count(void)
{
	int count=0,i;
	if(top==-1)
	{
		printf("\n Stack is Empty");
	}
	else
	{	
		for(i=top;i>=0;i--)
		{
			count++;
		}
		printf("\n Total values:%d",count);
	}
	getch();
}

void peep(void)
{
	int n , i , flag=0;
	if(top==-1)
	{
		printf("\n Stack is Empty");
	}
	else
	{
		printf("\n Enter Value:");
		scanf("%d",&n);
		
		for(i=top;i>=0;i--)
		{
			if(a[i]==n)
			{
				flag = 1 ;
				break;
			}
		}
		if(flag==1)
		{
			printf("\n Enter Value is Found");
		}
		else
		{
			printf("\n Enter Value is Not Found");
		}
	}
	getch();
}

void update(void)
{
    int n, flag = 0, newVal, i;

    if (top == -1)
    {
        printf("\n Stack is empty");
    }
    else
    {
        printf("\n Enter Value: ");
        scanf("%d", &n);

        for (i = top; i >= 0; i--)
        {
            if (a[i] == n)
            {
                flag = 1;

                printf("\n Enter New Value to add: ");
                scanf("%d", &newVal);

                a[i] = newVal;
                break;
            }
        }
        
        if (flag == 0)
        {
            printf("\n Value not found...");
        }
    }
    getch();
}

