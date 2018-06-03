.data 
	
	array: .word 10, 2, 9
	length: .word 3 
	sum: .word 0
	average: .word 0
	max: .word  0 
	messageSum: .asciiz "Sum "
	messageAvg: .asciiz "Average "
	newline: .asciiz "\n"
	
.text 
     main: 
	la $t0, array  #base address for array 
	li $t1, 0 #index 
	lw $t2 length 
	lw $t6 max
	li $t3, 0  #sum 
	sumLoop:
		lw $t4, ($t0)	#value at index 
		add $t3, $t3, $t4  #sum = sum + arra[i] 
		add $t1, $t1, 1 #increase index 
		add $t0, $t0, 4 #update address 
		blt $t1, $t2, sumLoop #if index is less than length 
	
	maxLoop:
		lw $t4, ($t0)	#value at index 
		slt $s0, $t6, $t4
	        bne $s0, $zero, updateMaxTrue 
		add $t1, $t1, 1 #increase index 
		add $t0, $t0, 4 #update address 
		blt $t1, $t2, sumLoop #if index is less than length 
	
	
		
	#load from register to memory
	sw $t3, sum 
	#display  sum
	li $v0, 4 
	la $a0, messageSum
	syscall 
	li $v0, 1
	move $a0, $t3
	syscall 
	
	#new line 
	li $v0, 4      
	la $a0, newline       
	syscall
	
	# display average 
	li $v0, 4 
	la $a0, messageAvg
	syscall 
	div $t5  $t3, $t2 
	sw $t5, average 
	li $v0, 1
	move $a0, $t5
	syscall 
	
	#terminate 
	li $v0, 10
	syscall 
	
	#display  max
	li $v0, 4 
	la $a0, messageSum
	syscall 
	li $v0, 1
	move $a0, $t6
	syscall 
	
	
	updateMaxTrue: 
		move $t6, $t4
	