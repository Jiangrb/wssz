package java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class Test {

	public static void main(String[] args) {

		List<Object[]> items = Lists.newArrayList();
		Object object = null;
		Object[] objects = new Object[10];
		Object[] objects1 = new Object[10];
		for (int i = 0; i < 10; i++) {
			object = new Student(i, "xiaoming" + i);
			objects[i] = object;
		}
		items.add(objects);
		for (int i = 10; i < 20; i++) {
			object = new Student(i, "xiaoming" + i);
			objects1[i] = object;
		}
		items.add(objects1);

		List<Student> students = Lists.newArrayList(//
				new Student(0, "xiaojiji"), //
				new Student(1, "xiaojiji1"), //
				new Student(2, "xiaojiji2"), //
				new Student(3, "xiaojiji3")//
		);

		Map<Object, Object> maps = Maps.newHashMap();
		Map<Integer, String> maps2 = Maps.newHashMap();

		// maps = items.stream().collect(Collectors.toMap(o -> o[0], o ->
		// o[1]));

		// maps2 = Maps.toMap(maps.keySet(), maps);
		// maps2 = items.stream().collect(Collectors.toMap(o -> ow[0], o ->
		// o[1]));
		maps = students.stream().collect(Collectors.toMap(o -> o.getId(), o -> o.getName()));

	}

}
