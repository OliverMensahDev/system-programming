#name: Oliver Mensah
#assignment: practical 7 problem 9
#date: November	22, 2017


.data
    prompt: .asciiz "Number of Items in Array  "
    getNumber: .asciiz "Enter a number  "
    enterNumberToGetIndex: "Enter Number To Get Index "
    iterator: .word 0
.text

    main:
        #print prompt
        la $a0 prompt
        li $v0 4
        syscall

        #get int
        li $v0 5
        syscall
        
        #number of items
        move $t2, $v0

        #allocate space at $a
        sll $a0 $t2 2 
        li  $v0 9
        syscall 
        
        move $t0, $a0
        move $t4, $v0
        
        #index and number of item
        lw $t1, iterator
        fillArray: 
        	beq $t1, $t2, getIndex
        	sll $t3, $t1 , 2  
        	addu $t3, $t3, $t4
        	la $a0 getNumber
        	li $v0 4
        	syscall
	  
        	#get int
        	li $v0 5
        	syscall
        	
        	sw $v0, 0($t3) 
        	addi $t1,$t1, 1
        	j fillArray
        	
        getIndex:
        	la $a0 enterNumberToGetIndex
        	li $v0 4
        	syscall
        	#get int
        	li $v0 5
        	syscall
        	
        	move $t5, $v0
        	sub $t2 $t2, 1
        	move $t1 $t2
        	        	
       Loop:	
       		
    		lw  $t4,0($t3)                        
    		seq  $t6, $t5, $t4
    		beq $t6, 1, print
    		subi  $t3,$t3,4 
    		subi $t1,$t1, 1 
    		j Loop    		
    	
     print: 
      	li $v0, 1
	move $a0, $t1
	syscall 
    exit: 
      
      
