
.data
stringa:	.asciiz "33 trent1ni 3ntr4r0no @ Trent0"
accapo:		.asciiz "\n"

.text
.globl main

###########################################################################################

	# torna true ($s1=1) se $a1 è nell’intervallo [$a2, $a3]
	# NOTA per semplificare uso registri diversi da quelli di contalettere
	# così devo preservare meno cose (possibilmente solo $ra)
is_between: 
	li	$s1, 0			# NO (0)
	blt	$a1, $a2, NO		# se $a0 è minore di $a1 ? 0
	bgt	$a1, $a3, NO		# se $a0 è maggiore di $a2 ? 0
	li	$s1, 1			# altrimenti SI (1)
NO:	jr	$ra			# registri modificati: $s1 e $ra

###########################################################################################

	# $a0 puntatore al primo carattere della stringa
contalettere:
	subi	$sp, $sp, 8		# alloco 1 word x preservare $ra e $a1
	sw	$ra, 0($sp)		# salvo $ra
	sw	$a1, 4($sp)		# salvo $a1
	lb	$a1, ($a0)		# leggo il primo carattere
	bnez	$a1, ancora		# se non è 0 fine str ? casi ricorsivi
	li	$v0, 0			# numero di lettere
	li	$v1, 0			# numero di cifre
	li	$s0, 0			# numero di altri caratteri
	j	fine_ricorsione		# metto i ripristini tutti assieme
ancora:
	addi	$a0, $a0, 1
	jal	contalettere		# conto il resto delle lettere
	# analizzo il primo carattere per sapere dove sommare 1
	li	$a2, 'a'		# estremo inferiore
	li	$a3, 'z' 		# estremo superiore
	jal	is_between		# è una lettera minuscola?
	beqz	$s1, non_minuscola	# se non lo è vado avanti
	addi	$v0, $v0, 1		# se lo è sommo 1 al n° di lettere
	j	fine_ricorsione		# i ripristini sono tutti assieme
non_minuscola:
	li	$a2, 'A'		# estremo inferiore
	li	$a3, 'Z' 		# estremo superiore
	jal	is_between		# è una lettera maiuscola?
	beqz	$s1, non_lettera	# se non lo è vado avanti
	addi	$v0, $v0, 1		# se lo è sommo 1 al n° di lettere
	j	fine_ricorsione		# i ripristini sono tutti assieme
non_lettera:
	li	$a2, '0'		# estremo inferiore
	li	$a3, '9' 		# estremo superiore
	jal	is_between		# è una cifra?
	beqz	$s1, altro		# se non lo è vado avanti
	addi	$v1, $v1, 1		# se lo è sommo 1 al n° di cifre
	j	fine_ricorsione		# i ripristini sono tutti assieme
altro:
	addi	$s0, $s0, 1		# sommo 1 al n° di altre lettere

fine_ricorsione:
	lw	$ra, 0($sp)		# ripristino $ra
	lw	$a1, 4($sp)		# ripristino $a1
	addi	$sp, $sp, 8		# disalloco le 2 word
	jr	$ra

##################################################################################

main:
	la $a0, stringa
	jal contalettere

	move $a0, $v0
	li   $v0, 1
	syscall
	
	la   $a0, accapo
	li   $v0, 4
	syscall

	move $a0, $v1
	li   $v0, 1
	syscall

	la   $a0, accapo
	li   $v0, 4
	syscall

	move $a0, $s0
	li   $v0, 1
	syscall

	li   $v0, 10
	syscall
		