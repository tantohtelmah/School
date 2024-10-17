#include "q2.h"

/**
* main - main function
* @argc: number of arguments passed
* @argv: array of arguments passed
*
* Return: int
*/

int main(int argc, char *argv[])
{
	if (!argc == 2)
	{
		fprintf(stderr, "Usage: %s <arg1> <arg2>\n", argv);
	}

	const char *expression = argv;

	double result = evaluatePostfix(expression);

	printf("Result: %.2f\n", result);

	return (0);
}
