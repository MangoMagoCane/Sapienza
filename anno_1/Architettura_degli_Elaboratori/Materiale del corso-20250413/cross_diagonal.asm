.data
    matrix2D: .word 0:49
    dim:      .word 7
.text
main:
    la    $t0, matrix2D
    lw    $t1, dim
    move  $t5, $t1
    li    $t2, 0
    mul   $t3, $t1, $t1
    sll   $t3, $t3, 2
    add   $t3, $t3, $t0
    addi  $t1, $t1, 1
    sll   $t1, $t1, 2
    move  $t4, $t3
    sll   $t5, $t5, 2
    sub   $t4, $t4, $t5
loop:
    bge   $t0, $t3, end_loop
    lw    $t5, ($t0)
    add   $t2, $t2, $t5
    beq   $t0, $t4, end_cond
    lw    $t5, ($t4)
    add   $t2, $t2, $t5
end_cond:
    add   $t0, $t0, $t1
    sub   $t4, $t4, $t1
    addi  $t4, $t4, 8
    j     loop
end_loop:
    li    $v0, 1
    move  $a0, $t2
    syscall
    li    $v0, 10
    syscall
    jal   end_loop
