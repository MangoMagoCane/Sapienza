.text
  la   $t0, numeri
  lw   $t1, length
  sll  $t1, $t1, 2
  add  $t1, $t1, $t0
  li   $a0, 0
while:
  bge $t0, $t1, end
  lw $t3, ($t0)
  add $a0, $a0, $t3
  add $t0, $t0, 4
  j while
end:
  li $v0, 1
  syscall
  li $v0, 10
  syscall
  
.data
numeri: .word 0, 7, 11
length: 	.word 3