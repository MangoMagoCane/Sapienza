.data

stringa:	.asciiz "33 30ini entrar1 @ 30nto "
stringa_r:	.asciiz "33 30ini entrar1 @ 30nto "
N:		.word 24
accapo:		.asciiz "\n"
.text
.globl main

###########################################################################
####	VERSIONE ITERATIVA
###########################################################################

# $a0 e $a1 = indici del primo e ultimo carattere
raggruppalettere:
	blt	$a0, $a1, ancora	# ancora caratteri da esaminare?
	jr	$ra
	
ancora:	# qui devo preservare $a0 e $ra su stack
   	subi	$sp, $sp, 8
   	sw	$ra, 0($sp)
   	sw	$a0, 4($sp)
   	
	lb	$a0, stringa($a0)	# leggo il primo carattere
	jal	is_lettera		# vedo se è una lettera

	# qui devo ripristinare $a0 e $ra da stack
   	lw	$ra, 0($sp)
   	lw	$a0, 4($sp)
   	addi	$sp, $sp, 8

	beqz	$v0, scambia		# se non lo è lo scambio con l’ultimo
	addi	$a0, $a0, 1		# altrimenti la prima è una lettera x cui avanzo $a0
	j	raggruppalettere	# continuo
scambia:
	lb	$t0, stringa($a0)	# leggo il primo carattere
	lb	$t1, stringa($a1)	# leggo l’ultimo carattere
	sb	$t0, stringa($a1)	# lo sostituisco col primo
	sb	$t1, stringa($a0)	# sostituisco il secondo al I°
	subi	$a1, $a1, 1		# diminuisco il secondo indice
	j	raggruppalettere	# continuo

###########################################################################
####	VERSIONE RICORSIVA
###########################################################################

raggruppalettere_r: 
	# $a0, $a1 indici del primo e ultimo carattere
	blt	$a0, $a1, caso_ric	# non sono finiti i caratteri?
	jr	$ra			# caso base, nulla da fare

caso_ric:
   	# qui devo preservare $a0 e $ra su stack
	subi	$sp, $sp, 8
	sw	$ra, 0($sp)
	sw	$a0, 4($sp)

	lb	$a0, stringa_r($a0)	# leggo il primo carattere
	jal	is_lettera		# vedo se è una lettera
	lw	$a0, 4($sp)		# recupero $a0 che serve dopo
	beqz	$v0, scambia_r		# se non lo è scambio con l’ultimo
	addi	$a0, $a0, 1		# la prima è una lettera e avanzo
	jal	raggruppalettere_r	# continuo con chiamata ricorsiva

	# qui devo ripristinare $a0 e $ra da stack
	lw	$ra, 0($sp)
	lw	$a0, 4($sp)
	addi	$sp, $sp, 8
	
	jr	$ra

scambia_r:
	lb	$t0, stringa_r($a0)	# leggo il primo carattere
	lb	$t1, stringa_r($a1)	# leggo l’ultimo carattere
	sb	$t0, stringa_r($a1)	# lo sostituisco col primo
	sb	$t1, stringa_r($a0)	# sostituisco il secondo al I°
	subi	$a1, $a1, 1		# diminuisco il secondo indice
	jal	raggruppalettere	# continuo

	#qui devo ripristinare $ra e $a0
	lw	$ra, 0($sp)
	lw	$a0, 4($sp)
	addi	$sp, $sp, 8

	jr	$ra

###########################################################################

# $a0 = lettera da eseminare
is_lettera:
	sge	$t0, $a0, 'a'		# se il carattere è compreso tra ‘a’
	sle	$t1, $a0, 'z'		# e ‘z’ è una lettera
	sge	$t2, $a0, 'A'		# oppure tra ‘A’
	sle	$t3, $a0, 'Z'		# e ‘Z’
	and	$t0, $t0, $t1
	and	$t1, $t2, $t3
	or	$v0, $t0, $t1		# allora è una lettare
	jr	$ra
	
###########################################################################

main:
	# raggruppo le lettere
	li $a0, 0
	lw $a1, N
	jal raggruppalettere
	
	# stampo la stringa
	la $a0, stringa
	li $v0, 4
	syscall

	# stampo un accapo
	la $a0, accapo
	li $v0, 4
	syscall

	# raggruppo le lettere
	li $a0, 0
	lw $a1, N
	jal raggruppalettere_r

	# stampo la stringa
	la $a0, stringa
	li $v0, 4
	syscall

	# fine del programma
	li $v0, 10
	syscall

###########################################################################
