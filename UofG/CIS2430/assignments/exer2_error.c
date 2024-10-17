int main(void)
{
	int A[5] = {1, 3, 7, 4, 0};
	int *P, *pA; //change here 

	int i, x, y;

	//Set pointer to the base address of array
	pA = A;//change here
	// Assign A[1] to x and y
	x = *(pA + 1);change here
	A++;//removed
	y = *(A + 1);//change here
	printf("x = \t%d", x);
	printf("y = \t%d", y);
	//Set every pointer to one array element
	for (i = 0; i < 5; i++)
	{
		P[i] = &A[i];//change here
	}
	//print array elements using pointers
	for (i = 0; i < 5; i++)
	{
		printf("\t%d", *P[i]);//change here
	}
	return (0);
}
