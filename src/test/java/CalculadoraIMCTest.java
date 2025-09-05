import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.calculadoraimc.CalculadoraIMC;

public class CalculadoraIMCTest {

    private final CalculadoraIMC calculadora = new CalculadoraIMC();

    @Test
    public void testClassificacaoAbaixoDoPeso() {
        assertEquals("Abaixo do peso", calculadora.classificarIMC(18.4));
    }

    @Test
    public void testClassificacaoNormal() {
        assertEquals("Normal", calculadora.classificarIMC(22.0));
    }

    @Test
    public void testClassificacaoSobrepeso() {
        assertEquals("Sobrepeso", calculadora.classificarIMC(27.5));
    }

    @Test
    public void testClassificacaoObesidade() {
        assertEquals("Obesidade", calculadora.classificarIMC(35.0));
    }

    @Test
    public void testBordaClassificacaoAbaixoDoPeso() {
        assertEquals("Abaixo do peso", calculadora.classificarIMC(18.49));
    }

    @Test
    public void testBordaClassificacaoNormal() {
        assertEquals("Normal", calculadora.classificarIMC(18.5));
        assertEquals("Normal", calculadora.classificarIMC(24.89));
    }

    @Test
    public void testBordaClassificacaoSobrepeso() {
        assertEquals("Sobrepeso", calculadora.classificarIMC(24.9));
        assertEquals("Sobrepeso", calculadora.classificarIMC(29.89));
    }

    @Test
    public void testBordaClassificacaoObesidade() {
        assertEquals("Obesidade", calculadora.classificarIMC(29.9));
    }

    @Test
    public void testCalcularIMCComAlturaZeroOuNegativa() {
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularIMC(70, 0));
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class,
                () -> calculadora.calcularIMC(70, -1.75));
    }
}