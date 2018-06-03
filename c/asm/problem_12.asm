#name: Oliver Mensah
#studentId: 41582018
#assignment: practical 7 problem 12
#date : 21/04/17


.data
hexDec0to9:		.byte		0x3f,0x6,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x67


.text
.globl 		main
main:
	sb   	$t4,0xFFFF0010		#left value of segment in register
	sb   	$t4,0xFFFF0011		#right value of segment in register
	li	$t3,0			#left counter
	li	$t6,1			#right counter
	li      $t8, 0
	li      $t9, 0
	move	$t0,$t8		       #show  left value
	move	$t2,$t9		       #show right value
	

leftDisplay:
	move	$s0,$t3		      #move from to s0
	jal 	rightDisplay	      #checking for limit 
	jal     leftValues
	add	$t3,$t3,1             #incerease  counter of left segment by 1
	li	$v0, 32               #produce 1 second interval
	li	$a0, 1000s
	syscall                     
	bge	$t6,11,exit           #exit program if upper digit limit
	j       leftDisplay
		
rightDisplay:
	blt	$t3,10,return		#if lower digit is not 9 yet, return
	move	$s1,$t6			
	move	$t7,$ra		       #keep track of where you should loop back
	jal     rightValues
	add	$t6,$t6,1		#increase value by 1
	li	$t3,0			#set t3 to 0 so that lower digit is reset to 0
	move	$s0,$t3			#store value to dispay as left value
	jr   $t7                       #return to leftDisplay
	
return:
	jr   $ra
	
exit:
	sb   	$t4,0xFFFF0010         #reseting both numbers to 0
	sb   	$t4,0xFFFF0011
	li	$v0, 10
	syscall
	
leftValues:	
	la   $t1,hexDec0to9		#ead from array, hexDec0to9
	add  $t1,$t1,$s0		#add value to be displayed
	lb   $t0,($t1)			#read values from array
	sb   $t0,0xFFFF0010		#store $t0
	jr   $ra
	
rightValues:
	la   $t5,hexDec0to9		#read from array, hexDec0to9
	add  $t5,$t5,$s1		#add value to be displayed
	lb   $t2,($t5)			#read values from array 
	sb   $t2,0xFFFF0011		#store to t2
	jr   $ra
