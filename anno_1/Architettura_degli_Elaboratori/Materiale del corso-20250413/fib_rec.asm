.data
N:        .word   45
spc:      .ascii  " "
nl:       .ascii "\n"
vec:      .word   0:45

.text
.globl main

main:
    lw    $s0, N
    li    $s1, 1
    sw    $s1, vec
    sw    $s1, vec+4
    li    $s1, 0
    lb    $s2, spc
    lb    $s3, nl
loop:
    bgt   $s1, $s0, end
    move  $a0, $s1
    li    $v0, 1
    syscall
    move  $s4, $a0
    move  $a0, $s2
    li    $v0, 11
    syscall
    move  $a0, $s4
    jal   fib
    move  $a0, $v0
    li    $v0,  1
    syscall
    move  $a0, $s3
    li    $v0, 11
    syscall
    addi  $s1, $s1, 1
    j     loop
end:
    li    $v0, 10
    syscall

fib:
    subi  $sp, $sp, 20
    sw    $ra, 0($sp)
    sw    $a0, 4($sp)
    sw    $v1, 8($sp)
    sw    $t0, 12($sp)
    sw    $t1, 16($sp)
    sll   $t0, $a0, 2
    la    $t1, vec
    add   $t0, $t0, $t1
    lw    $t1, ($t0)
    bgtz  $t1, base_case
    sub   $a0, $a0, 1
    jal   fib
    move  $v1, $v0
    sub   $a0, $a0, 1
    jal   fib
    add   $v0, $v0, $v1
    sw    $v0, ($t0)
    lw    $ra, 0($sp)
    lw    $a0, 4($sp)
    lw    $v1, 8($sp)
    lw    $t0, 12($sp)
    lw    $t1, 16($sp)
    addi  $sp, $sp, 20
    jr    $ra
base_case:
    move  $v0, $t1
    lw    $ra, 0($sp)
    lw    $a0, 4($sp)
    lw    $v1, 8($sp)
    lw    $t0, 12($sp)
    lw    $t1, 16($sp)
    addi  $sp, $sp, 20
    jr    $ra
