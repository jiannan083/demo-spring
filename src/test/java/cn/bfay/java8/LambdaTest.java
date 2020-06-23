package cn.bfay.java8;

import cn.bfay.model.Employee;
import cn.bfay.model.Person;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Lambda.
 *
 * @author wangjiannan
 */
public class LambdaTest {

    //public static void main(String[] args) {
    //    Arrays.asList("a", "b", "c").forEach(e ->System.out.println(e));
    //}

    @Test
    public void testList() {
        List<String> datas = new ArrayList<>();
        datas.add("a");
        datas.add("b");
        datas.add("c");
        datas.add("ab");
        datas.add("ac");
        datas.add("bc");
        datas.add("abc");

        // 遍历
        //datas.forEach(e -> System.out.println(e));
        System.out.println("------------------");
        datas.forEach(e -> System.out.println(e + ","));
        System.out.println("------------------");
        datas.forEach(System.out::println);
        System.out.println("------------------");
        datas.forEach(e -> {
            if (e.equalsIgnoreCase("b")) {
                System.out.println(e);
            }
        });
        System.out.println("------------------");

        // 过滤
        datas.stream().filter(e -> e.contains("b")).forEach(System.out::println);
        System.out.println("------------------");
    }

    @Test
    public void testGroupingBy() {
        List<Person> persons = Lists.newArrayList();
        persons.add(Person.builder().id(1).name("apple").address("shanghai").build());
        persons.add(Person.builder().id(11).name("apple").address("shanghai").build());
        persons.add(Person.builder().id(2).name("apple").address("wuhan").build());
        persons.add(Person.builder().id(3).name("apple").address("nanjing").build());

        //Map<String, List<Person>> items = persons.stream().collect(Collectors.groupingBy(c -> c.getAddress()));
        Map<String, List<Person>> items = persons.stream().collect(Collectors.groupingBy(Person::getAddress));

        items.forEach((key, value) -> System.out.println("key:" + key + ",value:" + value));
    }

    @Test
    public void testMap() {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        System.out.println("---- 遍历map->>>>");
        items.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

        System.out.println("---- 打印出值大于30的map->>>>");
        //Map<String, Integer> resultMap = items.entrySet().stream().filter(c -> c.getValue() > 30).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        Map<String, Integer> resultMap = items.entrySet().stream().filter(c -> c.getValue() > 30).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        resultMap.forEach((key, value) -> System.out.println(key + "=" + value));

        System.out.println("---- 打印key=D的map->>>>");
        //Map<String, Integer> mapResults = items.entrySet().stream().filter(c -> c.getKey().equals("D")).collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
        Map<String, Integer> mapResults = items.entrySet().stream().filter(c -> c.getKey().equals("D")).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        mapResults.forEach((key, value) -> System.out.println(key + "=" + value));
    }

    @Test
    public void testEmployees() {
        List<Employee> employees = Arrays.asList(
                new Employee("Matt", 200, "New York"),
                new Employee("Steve", 100, "London"),
                new Employee("Carrie", 200, "New York"),
                new Employee("Peter", 200, "New York"),
                new Employee("Alec", 300, "London"),
                new Employee("Sarah", 400, "London"),
                new Employee("Rebecca", 500, "New York"),
                new Employee("Pat", 600, "New York"),
                new Employee("Tammy", 700, "New York"),
                new Employee("Fred", 800, "Tokyo")
        );

        //System.out.println("---- 打印出名字是Steve的员工信息->>>>");
        //employees.forEach(c -> {
        //    if (c.getName().equals("Steve")) {
        //        System.out.println(c);
        //    }
        //});

        //System.out.println("---- 找出年薪超过6000的员工->>>>");
        ////employees.stream().filter(c -> c.getSalary() >= 6000).forEach(c -> System.out.println(c));
        //employees.stream().filter(c -> c.getSalary() >= 6000).forEach(System.out::println);

        //System.out.println("---- 分组操作->>>>");
        //Map<String, List<Employee>> groupMap = employees.stream().collect(Collectors.groupingBy(Employee::getOffice));
        //System.out.println(groupMap);

        //System.out.println("---- List转化为Map->>>>");
        //Map<String, Object> map = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getOffice));
        //map.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

        //System.out.println("---- anyMatch->>>>");
        //boolean isMatch = employees.stream().anyMatch(employee -> employee.getOffice().equals("London111"));
        //System.out.println(isMatch);

        //System.out.println("---- allMatch->>>>");
        //boolean matched = employees.stream().allMatch(employee -> employee.getOffice().equals("London"));
        //System.out.println(matched);

        //System.out.println("---- 找出工资最高的->>>>");
        //Optional<Employee> employeeOptional = employees.stream().max(Comparator.comparingInt(Employee::getSalary));
        //System.out.println(employeeOptional);

        //System.out.println("---- 找出工资最少的->>>>");
        //Optional<Employee> employee = employees.stream().min(Comparator.comparingInt(Employee::getSalary));
        //System.out.println(employee);

        //System.out.println("---- 返回姓名列表->>>>");
        //List<String> names = employees.stream().map(Employee::getName).collect(Collectors.toList());
        //System.out.println(names);

        //List转化Map
        //Map<String, Employee> employeeMap1 = employees.stream().collect(Collectors.toMap((Employee::getName), (value -> value)));
        //employeeMap1.forEach((key, value) -> System.out.println(key + "=" + value));
        //
        // java.lang.IllegalStateException: Duplicate key Employee(name=Steve, salary=6000, office=London)
        // key重复
        //Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap((key -> key.getSalary()), (value -> value)));
        //employeeMap.forEach((key, value) -> System.out.println(key + "," + value));

        //System.out.println("---- 统计办公室是New York的个数->>>>");
        //long officeCount = employees.stream().filter(c -> c.getOffice().equals("New York")).count();
        //System.out.println(officeCount);

        //System.out.println("---- 统计工资大于6000的个数->>>>");
        //long salaryCount = employees.stream().filter(c -> c.getSalary() > 6000).count();
        //System.out.println(salaryCount);

        //System.out.println("---- List转化为Set->>>>");
        //Set<String> officeSet = employees.stream().map(Employee::getOffice).distinct().collect(Collectors.toSet());
        //System.out.println(officeSet);

        //System.out.println("---- List转化为Set->>>>");
        //Set<Integer> salarySet = employees.stream().map(Employee::getSalary).distinct().collect(Collectors.toSet());
        //System.out.println(salarySet);

        //System.out.println("---- 查找办公室地点是New York的员工->>>>");
        //Optional<Employee> optionals = employees.stream().filter(c -> c.getOffice().equals("New York")).findAny();
        //System.out.println(optionals);

        System.out.println("---- 查找办公室地点是New York的员工->>>>");
        employees = employees.stream().filter(c -> c.getOffice().equals("New Yorkaaaa")).collect(Collectors.toList());
        System.out.println(employees);

        //System.out.println("---- 按照工资的降序来列出员工信息->>>>");
        //List<Employee> sortSalaryEmployeeList = employees.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())).collect(Collectors.toList());
        //System.out.println(sortSalaryEmployeeList);

        //System.out.println("---- 姓名升序排序->>>>");
        //List<Employee> sortNameEmployeeList = employees.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        //System.out.println(sortNameEmployeeList);

        //System.out.println("---- 获取工资最高的前2条员工信息->>>>");
        //List<Employee> dispaly2EmployeeList = employees.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary())).limit(2).collect(Collectors.toList());
        //System.out.println(dispaly2EmployeeList);

        //System.out.println("---- 获取平均工资->>>>");
        //OptionalDouble averageSalary = employees.stream().mapToInt(Employee::getSalary).average();
        //System.out.println(averageSalary);

        //System.out.println("---- 获取工作地点的平均工资->>>>");
        //OptionalDouble optionalDouble = employees.stream().filter(c -> c.getOffice().equals("New York")).mapToInt(Employee::getSalary).average();
        //System.out.println(optionalDouble);

        //System.out.println("---- findFirst->>>>");
        //Optional<Employee> employeeOptional_ = employees.stream().filter(c -> c.getOffice().equals("New York")).findFirst();
        //System.out.println(employeeOptional_);

        //Optional<String> isOptional = Optional.ofNullable("hello");
        //System.out.println(isOptional.isPresent());
        //System.out.println(isOptional.get());
        //System.out.println(isOptional.orElse("0"));

        //System.out.println(">>>>>>>>>>>>");
        //Optional<String> optionalVal = Optional.of(null);
        // System.out.println(optionalVal);
        //Optional<String> optional = Optional.ofNullable("optional");
        //System.out.println(optional);
        //System.out.println(optional.isPresent());
        //System.out.println(optional.get());
        //System.out.println(optional.orElse("haha"));
        //System.out.println(">>>>>>>>>>>>");

        //System.out.println(">>>>>>Java8 Optional用法>>>>>>");
        //Optional<String> stringOptional = Optional.of("test");
        //System.out.println(stringOptional.get());
        //
        //System.out.println(">>>>>>>Optional>>>>>>>");
        //Optional<String> optional = Optional.of("hello");
        ////System.out.println(optional.isPresent());
        //System.out.println(optional.orElse(null));
    }


}
