.data 
	prompt: .asciiz "Enter a number:  "
	message: .asciiz "Your entered -  "
	exitingCondValue: .word 0
	newline: .asciiz "\n"
.text 
	main: 
		#load word 
	lw $t1, exitingCondValue
	#prompt user 
	li $v0, 4
	la $a0, prompt
	syscall 
	
	#get user data 
	li $v0, 5 
	syscall
	
	
	#store the result 
	move $t0, $v0
	
	#display message
	li $v0, 4 
	la $a0, message
	syscall 
	
	#print the number to screen 
	li $v0, 1
	move $a0, $t0
	syscall 
	
	#store the result 
	move $t0, $a0
	
	li $v0, 4       # you can call it your way as well with addi 
	la $a0, newline       # load address of the string
	syscall
	
	Loop:
        	beq $t0, $t1, Exit # we go to Exit, defined below
        	li  $v0, 1           # service 1 is print integer
   		move $a0, $t0
		syscall # load desired value into argument register $a0, using pseudo-op
        	subi $t0, $t0, 1 #increment counter
        	j Loop #jumps back to the top of loop
     
    Exit: #ends the program
        li $v0,10 #loads the service that exits
        syscall
     
	
