#include<stdio.h>

struct student 
{
	int rno;
	int per;	
};

main()
{
	struct student s1;
	struct student *p;
	p=&s1;
	
	printf("\n Enter Student Roll No: ");
	scanf("%d",&p->rno);
	
	printf("\n Enter Student Percentage: ");
	scanf("%d",&p->per);
	
		printf("\n %d",p->rno);	
	printf("\n %d",p->per);
	
	getch();
}
