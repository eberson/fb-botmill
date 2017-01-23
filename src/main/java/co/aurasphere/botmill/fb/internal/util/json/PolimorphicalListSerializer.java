package co.aurasphere.botmill.fb.internal.util.json;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class PolimorphicalListSerializer<T> implements JsonSerializer<List<T>>{
	public JsonElement serialize(List<T> source, Type typeOfSource, JsonSerializationContext context) {
		if (source == null){
			return null;
		}
		
		JsonArray array = new JsonArray();
		
		for(T item : source){
			array.add(context.serialize(item, item.getClass()));
		}
		
		return array;
	}
}
