////////////////////////////////////////////////   PROBLEM     ///////////////////////////////////////////////////////////////////////

Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.

Input:
First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of which contains length of linked list and next line contains elements of the nodes of linked list.

Output:
Reorder it as explained above.

User Task:
The task is to complete the function reorderList() which should reorder the list as required.

Constraints:
1 <= T <= 200
1 <= N <= 200

Example:
Input:

2
3
1 2 3
4
1 7 3 4

Output:
1 3 2
1 4 7 3


///////////////////////////////////////////////   HELPER FUNCTION    ///////////////////////////////////////////////////////////////////////
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;
/* Linked list Node */
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
void reorderList(struct Node* head) ;
/* Function to create a new Node with given data */
struct Node *newNode(int data)
{
    struct Node *new_Node = new Node(data);
    new_Node->data = data;
    new_Node->next = NULL;
    return new_Node;
}
void printList(struct Node *Node)
{
    while(Node != NULL)
    {
        printf("%d ", Node->data);
        Node = Node->next;
    }
    printf(" ");
}
void freeList(struct Node *head)
{
	struct Node* temp;
    while(head != NULL)
    {

        temp=head;
        head = head->next;
        free(temp);
    }

}
int main(void)
{
   int t,n,m,i,x;

   cin>>t;
   while(t--)
   {
	   struct Node* temp,*head;
	    cin>>n;
	    cin>>x;
	    head=new Node(x);
	    temp=head;
	    for(i=0;i<n-1;i++)
	    {
			cin>>x;
			temp->next=new Node(x);
			temp=temp->next;
			}

		reorderList(head);
	    printList(head);
        freeList(head);
   }
   return 0;
}





///////////////////////////////////////////////////MAIN FUCTION////////////////////////////////////////////////////////////////
void reorderList(Node* head)
{

   Node* slow=head;
    int f=0,len=0;
    Node* nh=NULL;
    Node* temp=NULL;
    Node* fast=head;
    Node* head2=NULL;
    Node*pre=NULL;
    Node* curr;
    curr=head;
    if(head->next==NULL)
    {
        return;
    }
    if((head->next)->next == NULL )
    {
        return;
    }
    while(curr!=NULL)
    {
        len++;
        curr=curr->next;
    }

    if(len%2==0)
    {
       while((fast->next)->next!=NULL)
       {
        pre=slow;
        slow=slow->next;
        fast=(fast->next)->next;
       }
      if(fast->next!=NULL)
      {
        pre=slow;
        slow=slow->next;
        fast=fast->next;
      }
    }else{
        while(fast->next!=NULL)
       {
         pre=slow;
         slow=slow->next;
         fast=(fast->next)->next;
       }
    }

    pre->next=NULL;
    pre=NULL;
    head2=slow;
    while(head2->next!=NULL)
    {
        temp=head2->next;
        head2->next=pre;
        pre=head2;

        head2=temp;
    }
     head2->next=pre;

    while(head!=NULL && head2!=NULL)
    {
        if(f==0)
        {
            f=1;
            if(nh==NULL)
            {
                nh=curr=head;
                head=head->next;
            }else{
                curr->next=head;
                curr=curr->next;
                head=head->next;
            }

        }else{
            curr->next=head2;
            curr=curr->next;
            head2=head2->next;
            f=0;
        }
    }

    while(head2!=NULL)
    {
        curr->next=head2;
        curr=curr->next;
        head2=head2->next;
    }
    head=nh;
}
