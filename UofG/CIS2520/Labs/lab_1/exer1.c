#include <stdio.h>

/**
* main; main function

* Return: int
*/

int main(void)
{
	int a = 5;

	int *ptr = &a;

	*ptr += 10;
	printf("%d %d\n", a, *ptr);
	return (0);
}
