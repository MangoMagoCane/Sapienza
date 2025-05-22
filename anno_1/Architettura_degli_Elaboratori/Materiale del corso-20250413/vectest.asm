.data
  vector: .word  1, 2, 3, 4, 5, 6, 7, 8, 9
  N:      .word  9
  sum:    .word  0

.text
main:
	lw	$t1, N
	la	$t0, vector
	sll	$t1, $t1, 2
	add 	$t1, $t1, $t0
	li	$t2, 0
loop:
	bge	$t0, $t1, end
	lw	$t3, ($t0)
	add 	$t2, $t2, $t3
	addi	$t0, $t0, 12
	j	loop	
end:
	sw	$t2, sum
	li	$v0, 1
	move	$a0, $t2
	syscall
	li	$v0, 10
	
