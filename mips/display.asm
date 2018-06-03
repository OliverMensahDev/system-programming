#name: Oliver Mensah
#assignment: practical 7 problem 12
#date: November	29, 2017

.data
sslookup:		.byte		0x3f,0x6,0x5b,0x4f,0x66,0x6d,0x7d,0x07,0x7f,0x67
on_exit:		.asciiz 	"Done"
initial_count:		.byte		63 

.text
.globl 		main
main:
	lb   	$t4,initial_count	
	sb   	$t4,0xFFFF0010		
	sb   	$t4,0xFFFF0011		
	li	$t3,0			
	li	$t6,1			
	move	$t0,$zero		
	move	$t2,$zero		
	

lowerdigit:
	move	$s0,$t3			
	jal 	upperdigit
	jal	lower_num		
	add	$t3,$t3,1
	li	$v0, 32
	li	$a0, 1000
	syscall
	bge	$t6,11,exit
	j lowerdigit
		
upperdigit:
	blt	$t3,10,return		
	move	$s1,$t6			
	jal	upper_num		
	add	$t6,$t6,1
	li	$t3,0			
	move	$s0,$t3			
	jr   $t7
	
return:
	jr   $ra
	
exit:
	sb   	$t4,0xFFFF0010
	sb   	$t4,0xFFFF0011
	li	$v0, 4
	la	$a0, on_exit
	syscall
	li	$v0, 10
	syscall
	
lower_num:	
	la   $t1,sslookup		
	add  $t1,$t1,$s0		
	lb   $t0,($t1)			
	sb   $t0,0xFFFF0010		
	jr   $ra
	
upper_num:
	la   $t5,sslookup		#read the address of the lookup array
	add  $t5,$t5,$s1		#add the number to be displayed (in $s0) to the address
	lb   $t2,($t5)			#using the address, read the code from the array to $
	sb   $t2,0xFFFF0011		#write $t2 
	jr   $ra
