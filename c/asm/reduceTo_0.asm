# Program to reduce a number to 0

# Registers used:

# $t0 - used to hold the entered number
# $v0 - syscall parameter and return value.
# $a0 - syscall parameter.

.text

main:

## Get value from user, put into $t0.

li $v0, 5 # load syscall read_int into $v0.

syscall # make the syscall.

move $t0, $v0 # move the number read into $t0.

LOOP:    
    beq $t0, 0, EXIT
    sub $t0, $t0, 1
    
EXIT:

## Print out $t2.

move $a0, $t0 # move the number to print into $a0.

li $v0, 1 # load syscall print_int into $v0.

syscall # make the syscall.

## exit the program.

li $v0, 10 # syscall code 10 is for exit.

syscall # make the syscall.

