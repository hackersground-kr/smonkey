package com.project.smonkey.domain.smonkey.utils

internal data class Level(
    val level: Int,
    val targetPoint: Int,
)

internal val SMonkeyLevel: List<Level> = listOf(
    Level(1, -12000),
    Level(2, -7200),
    Level(3, -5760),
    Level(4, -4320),
    Level(5, -3360),
    Level(6, -2400),
    Level(7, -1440),
    Level(8, -720),
    Level(9, -240),
    Level(10, 10),
    Level(11, 60),
    Level(12, 120),
    Level(13, 240),
    Level(14, 360),
    Level(15, 480),
    Level(16, 600),
    Level(17, 720),
    Level(18, 960),
    Level(19, 1440),
    Level(20, 1920),
    Level(21, 2400),
    Level(22, 3600),
    Level(23, 4800),
    Level(24, 6000),
    Level(25, 7200),
    Level(26, 9600),
    Level(27, 12000),
    Level(28, 14400),
    Level(29, 19200),
    Level(30, 24000),
)
