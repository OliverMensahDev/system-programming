.data
	mess: .asciiz " Enter 10 numbers to be stored in the array. "
array: .space 40    #10 element integer array
    .globl main
    .text 
main:
    jal read
    b done
read:
    la $t0, 0   #count variable
    b readLoop
    jr $ra

readLoop:
    beq $t0, 40, read   #branch if equal to 40, 10 items
    li $v0, 4       #Print string
    la $a0, mess        #load prompt
    syscall
    li $v0, 5       #read int
    syscall 
    sw $v0, array       #store input in array ERROR HERE
    addi  $t0, $t0, 4   #add by 4 to count
    b readLoop
print:

done:
