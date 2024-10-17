#include <stdio.h>

/**
* main: Main Function

* Return: int
*/

int main(void)
{
	int a = 5, b = 10, c = 15;

	int *arr[] = {&a, &b, &c};

	printf("%d\n", **(arr + 1));
	return (0);
}
