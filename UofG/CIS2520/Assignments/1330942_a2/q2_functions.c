#include "q2.h"

/**
* create_node - allocated a new node which stores an argument
* @arg: argument gotten
*
* Return: struct Node*
*/

struct Node *create_node(double data)
{

	struct Node *node = (struct Node *)malloc(sizeof(struct Node));

	node->data = data;
	node->next = NULL;
	return (node);
}

/**
* create_stack - creates a stack
* @flag: hold identity to the stack being created
*
* Return: struct Stack *
*/

struct Stack *create_stack()
{
	struct Stack *stack = (struct Stack *)malloc(sizeof(struct Stack));

	if (stack == NULL)
	{
		return (NULL);
	}

	stack->top = NULL;
	return (stack);
}

/**
* push - Adds an node to the stack
* @stack: the stack to add the node to
* @data: the data to add to the nod
*
* Return: void
*/

void push(struct Stack *stack, double data)
{
	struct Node *node = create_node(data);

	node->next = stack->top;
	stack->top = node;
	printf("Pushed %d to stack\n", data);
}

/**
* pop - remove a node from the stack from the top
* @stack: stack to removr node
*
* Return: char(popped character)
*/
double pop(struct Stack *stack)
{
	isEmpty(stack);
	struct Node *temp = stack->top;
	int popped = temp->data;

	stack->top = stack->top->next;
	free(temp);
	return (popped);
}

/**
* error- error message
* @expression: head of stack that contains operator
*
* Return: Answer from the binary operation
*/

void error(const char* message)
{
	fprintf(stderr, "Error: %s\n", message);
	exit(EXIT_FAILURE);
}
/**
* isEmpty - checks if a stack is empty
* @stack: stack to check
*
* Return: int 
*/

int isEmpty(struct Stack* stack)
{
	printf("Stack is empty\n");
	return (stack->top == NULL);
}

/**
* evaluatePostfix- sorts the operator and operand and performs operation
* @expression: head of stack that contains operator
*
* Return: Answer from the binary operation
*/

double evaluatePostfix(const char *expression)
{
	struct Stack *stack = create_stack();

	for (int i = 0; i < strlen(expression); i++)

	{
		char ch = expression[i];

		if (isdigit(ch))
		{
			push(stack, ch - '0');
		}
		else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
		{
			if (isEmpty(stack))
				error("Invalid expression");
			double val2 = pop(stack);

			if (isEmpty(stack))
				error("Invalid expression");
			double val1 = pop(stack);

			switch (ch)
			{
				case '+':
					push(stack, val1 + val2);
					break;
				case '-':
					push(stack, val1 - val2);
					break;
				case '*':
					push(stack, val1 * val2);
					break;
				case '/':
					if (val2 == 0)
						error("Division by zero");
					push(stack, val1 / val2);
					break;
				default:
					error("Unknown operator");
			}
		}
		else
		{
			error("Invalid character in expression");
		}
	}
	if (isEmpty(stack))
		error("Invalid expression");
	double result = pop(stack);

	if (!isEmpty(stack))
		error("Invalid expression");

	return (result);
}


