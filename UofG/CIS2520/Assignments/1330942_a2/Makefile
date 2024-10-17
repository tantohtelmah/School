# -*- Makefile -*-

#target: dependencies
#	action

# Compiler
CC = gcc

# Flags
CFLAGS = -Wall -std=c99 -pedantic
LFLAGS =

# Source files
SRCS = q1.c q1_functions.c

# Header files
HDRS = q1.h

# Object files
OBJS = $(SRCS:.c=.o)

# Executable
EXEC = a2q1

# Default target
all: $(EXEC)

# Compile object files
%.o: %.c $(HDRS)
	$(CC) $(CFLAGS) -c $< -o $@

# Link object files
$(EXEC): $(OBJS)
	$(CC) $(LFLAGS) $(OBJS) -o $@

# Clean
clean:
	rm -f *.o $(EXEC)

# Run
run: $(EXEC)
	./$(EXEC)

# Dependencies
q1.o: q1.h
q1_functions.o: q1.h
