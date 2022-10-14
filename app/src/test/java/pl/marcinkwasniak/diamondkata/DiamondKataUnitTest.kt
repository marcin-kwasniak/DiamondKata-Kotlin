package pl.marcinkwasniak.diamondkata

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.assertj.core.api.Assertions.assertThat

class DiamondKataUnitTest {

    @ParameterizedTest
    @CsvSource(
        "A",
        "B",
        "C",
        "H",
        "Z"
    )
    fun `given target letter when render then expect result with proper line count`(target: Char) {
        // Given
        val diamondKata = DiamondKata()
        val diff = target - DiamondKata.PEAK
        val expectedSize = 1 + diff * 2

        // When
        val diamond = diamondKata.render(target)
        print(diamond)

        // Then
       assertThat(diamond).hasLineCount(expectedSize)
    }
}