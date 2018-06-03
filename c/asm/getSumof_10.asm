# Program to 
# Registers used:

# t0 - used to hold the result.

# t1 - used to hold the constant 1.

# v0 - syscall parameter.

main: # SPIM starts execution at main.

li $t0, 0  # load 0 into $t1.
loop: ble $t0, 10 , body # while ( $to < 10) goto body
body: addi $t0, $t0, 1 # (in loop) a = a + 1
j loop # end loop, repeat

move $a0, $t0 # move the number to print into $a0.
li $v0, 1 # load syscall print_int into $v0.
syscall # make the syscall.
 
Exit: #ends the program
    li $v0,10 #loads the service that exits
    syscall