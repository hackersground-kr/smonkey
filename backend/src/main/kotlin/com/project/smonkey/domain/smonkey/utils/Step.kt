package com.project.smonkey.domain.smonkey.utils

internal data class NoSmokingStep(
    val step: Int,
    val minLevel: Int,
)

internal val NoSmokingSteps: List<NoSmokingStep> = listOf(
    NoSmokingStep(1, 1),
    NoSmokingStep(2, 6),
    NoSmokingStep(3, 11),
    NoSmokingStep(4, 16),
    NoSmokingStep(5, 21),
    NoSmokingStep(6, 26),
)
