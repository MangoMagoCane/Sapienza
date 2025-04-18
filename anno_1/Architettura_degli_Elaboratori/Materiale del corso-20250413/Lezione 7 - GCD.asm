.text
.globl main	# necessario per far partire il programma da 'main' (se MARS ha il settaggio giusto)

#################################################################

GCD_r:
	bne	$a0, $a1, x_diverso_y_r
	# caso base
	move	$v0, $a0	# GCD(x, x) = x
	jr	$ra
x_diverso_y_r:	# caso_ricorsivo
	subi	$sp, $sp, 4
	sw	$ra, 0($sp)
	bgt	$a0, $a1, x_maggiore_y_r
	sub	$a1, $a1, $a0
	jal	GCD_r		# GCD(x, y-x)
	j	esci_r
x_maggiore_y_r:
	move	$v0, $a0
	move	$a0, $a1
	move	$a1, $v0
	jal	GCD_r		# GCD(y, x)
esci_r:
	lw	$ra, 0($sp)
	addi	$sp, $sp, 4
	jr	$ra

#################################################################

GCD_i:
	bne	$a0, $a1, x_diverso_y_i
	# caso base
	move	$v0, $a0		# GCD(x, x) = x
	jr	$ra
x_diverso_y_i:
 	bgt	$a0, $a1, x_maggiore_y_i
	sub	$a1, $a1, $a0
	j	GCD_i		# GCD(x, y-x)
x_maggiore_y_i:
	move	$v0, $a0
	move	$a0, $a1
	move	$a1, $v0
	j	GCD_i		# GCD(y, x)

#################################################################
main:
	# calcolo il GCD ricorsivamente
	li $a0, 120
	li $a1, 75
	jal GCD_r
	move $a0, $v0
	li $v0, 1
	syscall

	# stampo un accapo
	la $a0, accapo
	li $v0, 4
	syscall

	# calcolo il GCD iterativamente
	li $a0, 120
	li $a1, 75
	jal GCD_i
	move $a0, $v0
	li $v0, 1
	syscall

	# fine del programma
	li $v0, 10
	syscall

.data
accapo:	.asciiz "\n"
#################################################################
