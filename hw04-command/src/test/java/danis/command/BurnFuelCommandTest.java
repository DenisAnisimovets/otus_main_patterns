package danis.command;

import danis.domain.FuelBurnable;
import danis.exception.CommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

@DisplayName("Класс сжигания топлива BurnFuelCommand должен")
class BurnFuelCommandTest {
    private FuelBurnable fuelBurnable;
    private BurnFuelCommand burnFuelCommand;

    @BeforeEach
    void setUp() {
        fuelBurnable = mock(FuelBurnable.class);
        burnFuelCommand = new BurnFuelCommand(fuelBurnable);
    }

    @DisplayName("Сжигать топливо с уровня 10 на уровень 8 при скорости сжигания равной 2")
    @Test
    public void shouldBurnFuelToCorrectLevel() {
        when(fuelBurnable.getFuelLevel()).thenReturn(10);
        when(fuelBurnable.getFuelBurnVelocity()).thenReturn(2);
        burnFuelCommand.execute();

        verify(fuelBurnable, times(1)).setFuelLevel(eq(8));
    }

    @DisplayName("Бросать исключение при попытке сжечь топливо недостаточного уровня")
    @Test
    public void shouldThrowExceptionWhenNotEnoughFuelToBurn() {
        when(fuelBurnable.getFuelLevel()).thenReturn(1);
        when(fuelBurnable.getFuelBurnVelocity()).thenReturn(2);
        assertThatThrownBy(() -> {
            burnFuelCommand.execute();
        }).isInstanceOf(CommandException.class).hasMessageContaining("Not enough fuel");
    }
}