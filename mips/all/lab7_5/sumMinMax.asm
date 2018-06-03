#name: Oliver Mensah
#assignment: practical 7 problem 5
#date: November	15, 2017

.data
    prompt: .asciiz "Number of Items in Array  "
    getNumber: .asciiz "Enter a number  "
    enterNumberToGetIndex: "Enter Number To Get Index "
    iterator: .word 0
    newline: .asciiz "\n"
    maxPrint: .asciiz "The max value is "
    sumPrint: .asciiz "The sum is "
    minPrint: "The min Value is "
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
        	beq $t1, $t2, sum
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
        
        	
       # working with sum value			
        sub $t2 $t2, 1
        move $t1 $t2
        li $t5 , 0  #sum	        	
       sum:	beq $t1,-1, printSum 
    		lw  $t4,0($t3)                    
    		add $t5, $t5, $t4
    		subi  $t3,$t3,4 
    		subi $t1,$t1, 1 
    		j sum   		
    	
     printSum: 
     	li $v0, 4     
	la $a0, sumPrint       
	syscall
      	li $v0, 1
	move $a0, $t5
	syscall 
	
	li $v0, 4       # you can call it your way as well with addi 
	la $a0, newline       # load address of the string
	syscall

# working with max value
    li $6, 0  #max
    add $t2, $t2, 1
    max: 	
    		beq $t1,$t2, printMax
    		lw  $t4,0($t3) 
    		sle $t0, $t6, $t4 
    		beq $t0, 1, reassignMax                 
    		addi  $t3,$t3,4 
     		addi $t1,$t1, 1 
      		j max  
  
        	
   reassignMax:
      move $t6, $t4
      addi  $t3,$t3,4 
      addi $t1,$t1, 1 
      j max  	  
      
  printMax:
  	li $v0, 4     
	la $a0, maxPrint    
	syscall
	li $v0, 1
	move $a0, $t6
	syscall
	
	li $v0, 4       # you can call it your way as well with addi 
	la $a0, newline       # load address of the string
	syscall


  # working with min value
   sub $t2 $t2, 1
   move $t1 $t2
   lw  $t7,0($t3)  #min
   min: 	
    		beq $t1,-1, printMin
    		lw  $t4,0($t3) 
    		sle $t0, $t4, $t7
    		beq $t0, 1, reassignMin              
    		subi  $t3,$t3,4 
     		subi  $t1,$t1, 1 
      		j min 
  
        	
   reassignMin:
       move $t7, $t4
       subi  $t3,$t3,4 
       subi  $t1,$t1, 1 
      j min	  
      
      
  printMin:
  	li $v0, 4     
	la $a0, minPrint    
	syscall
	li $v0, 1
	move $a0, $t7
	syscall 
	
	
