package com.itranswarp.learnjava;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();

		// 添加元素，key值不会重复，并且每个放入的key-value不保证顺序性
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("three", 4); // 放入重复的key会被最后一个放入的key-value替代

		System.out.println(map);

		// 通过key查找元素
		System.out.println(map.get("three"));

		// 遍历Map
		for (String key : map.keySet())
			System.out.println(key + " -> " + map.get(key));

		// 同时遍历key和value: Map.Entry
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey() + " ");
			System.out.println(entry.getValue());
		}
	}
}
