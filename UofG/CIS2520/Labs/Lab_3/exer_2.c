#include <stdio.h>
#include <stdlib.h>

struct Node
{
	int data;

	struct Node *next;
};

struct Node *createNode(int data)
{

	struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

	newNode->data = data;
	newNode->next = NULL;
	return (newNode);
}

void insertAfter(struct Node *prevNode, int data)
{

	if (prevNode == NULL)
	{
		printf("The given previous node cannot be NULL\n");
		return;
	}
	struct Node *newNode = createNode(data);

	newNode->next = prevNode->next;
	prevNode->next = newNode;
}

void printList(struct Node *node)
{
	while (node != NULL)
	{
		printf("%d -> ", node->data);
		node = node->next;
	}
	printf("NULL\n");
}

void fun(struct Node *start)
{
	if (start == NULL)
		return;
	printf("%d ", start->data);
	if (start->next != NULL)
	{
		fun(start->next->next);
	}
	printf("%d", start->data);
}


int main(void)
{
	struct Node *head = createNode(1);

	head->next = createNode(2);
	head->next->next = createNode(3);
	head->next->next->next = createNode(4);
	head->next->next->next->next = createNode(5);
	head->next->next->next->next->next = createNode(6);

	printf("Original linked list: ");
	printList(head);

	fun(head);
	printf("\n");


	insertAfter(head->next->next, 5);

	printf("Updated linked list: ");
	printList(head);


	struct Node *temp;

	while (head != NULL)
	{
		temp = head;
		head = head->next;
		free(temp);
	}
}
