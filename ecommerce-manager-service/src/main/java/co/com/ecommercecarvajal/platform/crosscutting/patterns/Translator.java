package co.com.ecommercecarvajal.platform.crosscutting.patterns;

/**
 * Patron de diseno Translator
 * @param <I> Objeto de Entrada
 * @param <O> Objeto de Salida
 */

@FunctionalInterface
public interface Translator<I, O> {

    O translate(final I input);
}
