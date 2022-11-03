package org.example.wrapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BaseWrapper {

	/**
	 * Generate a randomly filled object based on provided parameters.
	 *
	 * @param type - type of object that should be created.
	 * @return randomly generated object.
	 */
	<T> T random(Class<T> type);

	/**
	 * Generate a randomly filled object based on provided parameters with specified fields.
	 *
	 * @param type        - type of object that should be created.
	 * @param fieldValues - Map of: key - object field name, value - object field value.
	 * @return generated object with specified fields.
	 */
	<T> T random(Class<T> type, Map<String, Object> fieldValues);

	/**
	 * Generate a {@link List} with randomly filled objects.
	 *
	 * @param type - type of objects that should be created.
	 * @param size - list size.
	 * @return a list of generated objects.
	 */
	<T> List<T> randomListOf(Class<T> type, int size);

	/**
	 * Generate a {@link Set} with randomly filled objects.
	 *
	 * @param type - type of objects that should be created.
	 * @param size - set size.
	 * @return a set of generated objects.
	 */
	<T> Set<T> randomSetOf(Class<T> type, int size);

	/**
	 * Generate a {@link Map} with randomly filled objects.
	 *
	 * @param keyType   - type of key.
	 * @param valueType - type of value.
	 * @param size      - map size.
	 * @return a map of generated objects.
	 */
	<K, V> Map<K, V> randomMapOf(Class<K> keyType, Class<V> valueType, int size);
}