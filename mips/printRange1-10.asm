 .text
    li $t0, 0 # temp var counter for loop
    li $t2, 10 # exit condition
    Loop:
        beq $t2, $t0, Exit #at 10 we go to Exit, defined below
        li  $v0, 1           # service 1 is print integer
   	move $a0, $t0
	syscall # load desired value into argument register $a0, using pseudo-op
        addi $t0, $t0, 1 #increment counter
        j Loop #jumps back to the top of loop
     
    Exit: #ends the program
        li $v0,10 #loads the service that exits
        syscall
     