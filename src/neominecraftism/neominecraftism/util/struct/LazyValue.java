package neominecraftism.neominecraftism.util.struct;

import java.util.function.Supplier;

/**
 * A holder for a lazy value. Initializes the value only when first getting the value.
 * 
 * @author David Ma
 *
 * @param <T> The type of the held value.
 */
public class LazyValue<T> {
	
	private Supplier<T> valueSupplier;
	private T cachedValue;
	
	private LazyValue(Supplier<T> valueSupplier) {
		this.valueSupplier = valueSupplier;
	}
	
	public static <V> LazyValue<V> of(Supplier<V> valueSupplier) {
		return new LazyValue<>(valueSupplier);
	}
	
	public T get() {
		if (this.cachedValue == null) {
			this.cachedValue = this.valueSupplier.get();
		}
		
		return this.cachedValue;
	}
}
