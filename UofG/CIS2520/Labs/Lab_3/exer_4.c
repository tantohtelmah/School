#include <stdio.h>
#include <stdlib.h>


struct Node
{
	int data;

	struct Node *prev;
	struct Node *next;
};


struct Node *createNode(int data)
{
	struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));

	if (newNode == NULL)
		return (NULL);

	newNode->data = data;
	newNode->prev = NULL;
	newNode->next = NULL;

	return (newNode);
}

void printlist(struct Node *node)
{
	while (node != NULL)
	{
		printf("%d -> ", node->data);
		node = node->next;
	}
	printf("NULL\n");
}

void deleteNodeEnd(struct Node *prevNode)
{
	if (prevNode == NULL)
		return;
	prevNode->next = NULL;
}

int findMax(struct Node* head)
{
	if (head == NULL)
	{
		printf("The list is empty.\n");
		return (-1);
	}

	int max = head->data;

	struct Node *current = head->next;

	while (current != NULL)
	{
		if (current->data > max)
		{
			max = current->data;
		}
		current = current->next;
	}

	return (max);
}

int main(void)
{
	struct Node *head = createNode(4);

	head->prev = NULL;
	head->next = createNode(6);
	head->next->prev = head;

	head->next->next = createNode(8);
	head->next->next->prev = head->next;

	head->next->next->next = createNode(1);
	head->next->next->next->prev = head->next->next;

	printlist(head);

	deleteNodeEnd(head->next->next);
	printlist(head);
	printf("%d ", findMax(head));

	struct Node *temp;

	while (head != NULL)
	{
		temp = head;
		head = head->next;
		free(temp);
	}

}



