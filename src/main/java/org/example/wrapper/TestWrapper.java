package org.example.wrapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

public abstract class TestWrapper implements BaseWrapper {

	public abstract EasyRandomParameters getEasyRandomParameters();

	private final EasyRandom easyRandom = new EasyRandom(getEasyRandomParameters());

	@Override
	public <T> T random(Class<T> type) {
		return easyRandom.nextObject(type);
	}

	@Override
	public <T> T random(Class<T> type, Map<String, Object> fieldValues) {
		T obj = easyRandom.nextObject(type);
		fieldValues.forEach((key, value) -> {
			try {
				setFieldValue(obj, key, value);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
		return obj;
	}

	@Override
	public <T> List<T> randomListOf(Class<T> type, int size) {
		return easyRandom.objects(type, size)
				.collect(Collectors.toList());
	}

	@Override
	public <K, V> Map<K, V> randomMapOf(Class<K> keyType, Class<V> valueType, int size) {
		Map<K, V> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			map.put(random(keyType), random(valueType));
		}
		return map;
	}

	private void setFieldValue(Object obj, String fieldName, Object newValue) throws Exception {
		var field = obj.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(obj, newValue);
	}
}
