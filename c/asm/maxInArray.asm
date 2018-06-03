        .data 
theArray: .space 20   #10 element integer array
prompt: .asciiz " Enter 5 be stored in the array. "
finish: .asciiz "You have finish, lets find their sum , max, min"
    .globl main
    .text 
main:
 la $v0, sendMessage

sendMessage:
      la    $a0,prompt         # prompt user for input
      li    $v0,4
      syscall
   
    
readInputs:
    li $v0, 5       #read int
    syscall 
    move  $t0,$v0
    sw    $t5, theArray($t0)  # ...and stores the result
    addi  $t0, $t0, 4         # Moves to next "element" of theArray
    blt   $t0, 20,readInputs      # If not past the end of theArray, repeat
    jr    $ra
    
