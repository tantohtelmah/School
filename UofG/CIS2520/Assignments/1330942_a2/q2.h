#ifndef Q2_H
#define Q2_H

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>


/**
 * Node: structure to hold a node for an element in the stack
 * @data: data in the node
 * @next: pointer to the next node (linking)
 * 
 * 
 */

struct Node {
    double data;
    struct Node* next;
};

/**
 * Stack: structure to hold a stack
 * @top: pointer to the top of the stack
 * 
 */

struct Stack {
    struct Node* top;
};

/**
 * enum stacks - stacks to be created
 * @ARG: stack contains the arguments gotten from the command line (top node contains last argument)
 * @OPERATOR: stack contains operators gotten from the ARG stack
 * @OPERAND: stack contains operands gotten from the ARG stack
 * @ANS: stores intergers ready from operations
 *
 * Description: stacks to be created
 */
typedef enum stacks
{
	ARG,
	OPERATOR,
	OPERAND,
	ANS
} stacks;

//Functions

void print_stack(struct Stack *stack);
int pop(struct Stack *stack);
void push(stack_t *stack, int data);
stack_t *create_stack(stacks flag);
node_t *create_node(char arg);
int isEmpty(struct Stack* stack);
double evaluatePostfix(const char *expression);
void error(const char* message);

#endif /* Q2_H */
