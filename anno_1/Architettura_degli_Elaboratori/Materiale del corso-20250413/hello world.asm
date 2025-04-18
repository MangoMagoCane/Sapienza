.data
str:		.asciiz "Hello, world"

.text
main:
	li $v0, 4
	la $a0, str
	syscall
	add $a0, $a0, 4
	syscall
	li $v0, 10
	syscall