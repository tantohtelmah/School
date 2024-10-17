#include <stdio.h>
#include <stdlib.h>

/* Implementing a queue with singly list */

struct queueNode
{
	int data;
	struct  queueNode *next;
};

struct queue
{
	struct queueNode *front;
	struct queueNode *rear;
};

struct queueNode *createQueueNode(int data)
{
	struct queueNode node = (struct queueNode *)malloc(sizeof(struct queueNode));

	if (node == NULL)
	{
		return (NULL);
	}

	node->data = data;
	node->next = NULL;

	return (node);
}

struct queue *createQueue(struct queueNode **front, struct queueNode **rear)
{
	struct queue queueList = (struct queue *)malloc(sizeof(struct queue));

	if (queueList == NULL)
	{
		return (NULL);
	}
	queueList->front = *front;
	queueList->rear = *front;
}

struct queue *enqueue(struct queue **queueList, struct queueNode **insertNode)
{
	if (queueList == NUll || insertNode == NUll)
	{
		return (NULL);
	}

	if (queueList->front == NULL && queueList->rear == NULL)
	{
		queueList->front = insertNode;
		queueList->rear = insertNode;
	}

	return (queueList->rear->next = insertNode);
}

void printList(struct queue **list)
{
	if (*list == NULL)
	{
		printf("The list is empty");
		return;
	}

	while (*list)
	{
		printf("%d ->", *list->front->data);
		*list->front->next = *list->front;
	}
}

int main(void)
{

	struct queue list = createQueue();

	struct queueNode node1 = createQueueNode(5);
	struct queueNode node2 = createQueueNode(5);
	struct queueNode node3 = createQueueNode(5);
	struct queueNode node4 = createQueueNode(5);
	struct queueNode node5 = createQueueNode(5);

	enqueue(list, node1);
	enqueue(list, node2);
	enqueue(list, node3);
	enqueue(list, node4);
	enqueue(list, node5);

	printList(list);

	while (list)
	{
		free(list->front);
		list->front = list->front->next;
	}
	free(list);
}