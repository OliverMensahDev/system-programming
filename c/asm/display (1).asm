#name: Simon Baaman Suuk
#studentID: 63362017
#assignment: practical 7 problem 12
#date: 09/12/2016

.data
sslookup:		.byte		0x3f,0x6,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x67
on_exit:		.asciiz 	"Done"
initial_count:		.byte		63 #initializes 7-segment display to 0

.text
.globl 		main
main:
	lb   	$t4,initial_count	#t4 initializes the display
	sb   	$t4,0xFFFF0010		#initialize lower digit to zero
	sb   	$t4,0xFFFF0011		#initialize upper digit to zero
	li	$t3,0			#t3 tracks that the number will be displayed as the lower digit
	li	$t6,1			#t6 tracks that the number will be displayed as the upper digit
	move	$t0,$zero		#t0 displays number as lower digit
	move	$t2,$zero		#t2 displays number as upper digit
	

lowerdigit:
	#move value of t3 to s0 to be used by lower_num procedure
	move	$s0,$t3			
	#check to see if lower digit is 9
	jal 	upperdigit
	#display value as lower digit
	jal	lower_num		
	#update value to be displayed by 1
	add	$t3,$t3,1
	#produce 1 second interval
	li	$v0, 32
	li	$a0, 1000
	syscall
	#exit program if upper digit reaches 9
	bge	$t6,11,exit
	#loop back
	j lowerdigit
		
upperdigit:
	#if lower digit is not 9 yet, return
	blt	$t3,10,return		
	#move value of t6 to s1 to be used by lower_num procedure
	move	$s1,$t6			
	#keep track of where you should loop back
	move	$t7,$ra			
	#displays value as upper digit
	jal	upper_num		
	#increase value by 1
	add	$t6,$t6,1
	#set t3 to 0 so that lower digit is reset to 0
	li	$t3,0			
	#store value to dispay as lower digit
	move	$s0,$t3			
	#return to lowerdigit
	jr   $t7
	
return:
	jr   $ra
	
exit:
	#reset both numbers to 0
	sb   	$t4,0xFFFF0010
	sb   	$t4,0xFFFF0011
	#prompt user that program has completed
	li	$v0, 4
	la	$a0, on_exit
	syscall
	#exit
	li	$v0, 10
	syscall
	
lower_num:	
	la   $t1,sslookup		#read the address of the lookup array
	add  $t1,$t1,$s0		#add the number to be displayed (in $s0) to the address
	lb   $t0,($t1)			#using the address, read the code from the array to $
	sb   $t0,0xFFFF0010		#write $t0 
	jr   $ra
	
upper_num:
	la   $t5,sslookup		#read the address of the lookup array
	add  $t5,$t5,$s1		#add the number to be displayed (in $s0) to the address
	lb   $t2,($t5)			#using the address, read the code from the array to $
	sb   $t2,0xFFFF0011		#write $t2 
	jr   $ra
