package cn.java8.stream;

import com.google.common.collect.Lists;
import lombok.Synchronized;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.jboss.netty.channel.socket.http.HttpTunnelingServlet;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author kelai 2019-11-05 22:51
 */

public class StreamTest {

    ReentrantLock lock = new ReentrantLock();

    @Test
    public void filter() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        List set = map.entrySet().stream().filter(e -> e.getKey().equals("a")).collect(Collectors.toList());
        System.out.println(set);
    }

    @Test
    public void filterTest() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(200));
        }
        System.out.println();
        list.stream().filter(num -> num > 100).collect(Collectors.toList()).forEach((num) -> {
            System.out.print(num + " ");
        });
    }

    @Test
    public void flatMapTest() {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {4, 5, 6};
        List<int[]> result = Stream.of(arr1).flatMap(i -> Stream.of(arr2).filter(k -> (k + i) % 3 == 0).map(j -> new int[]{i, j})).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    public void distinct() {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {4, 2, 6};
        Stream.of(arr1, arr2)
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void sortedTest() {
        String s = "n z y c v f r f g t e b v e t";
        System.out.println(s.split(" "));
        Stream.of(s)
                .map(c -> c.split(""))
                .flatMap(ss -> Stream.of(ss))
                .sorted((cc1, cc2) -> cc1.compareTo(cc2))
                .forEach(cc3 -> System.out.print(cc3));
    }

    @Test
    public void PeekTest() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()).forEach(e -> System.out.println(e));
    }

    @Test
    public void ReduceATest() {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.stream().reduce(0, (a, b) -> a * b));
        System.out.println(integers.stream().reduce(0, (a, b) -> (a >= b) ? a : b));
    }

    @Test
    public void ReduceBTest() {
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        System.out.println(s1.reduce(new ArrayList<String>(),
                new BiFunction<ArrayList<String>, String, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> u, String s) {
                        u.add(s + "nzy");
                        return u;
                    }
                }, new BinaryOperator<ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> strings, ArrayList<String> strings2) {
                        return strings;
                    }
                }));
    }

    @Test
    public void ReduceCTest() {
        Stream<String> s1 = Stream.of("aa", "ab", "c", "ad");
        Predicate<String> predicate = t -> t.contains("a");
        s1.parallel().reduce(new ArrayList<String>(), new BiFunction<ArrayList<String>, String, ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> strings, String s) {
                        if (predicate.test(s)) {
                            strings.add(s);
                        }
                        return strings;
                    }
                },
                new BinaryOperator<ArrayList<String>>() {
                    @Override
                    public ArrayList<String> apply(ArrayList<String> strings, ArrayList<String> strings2) {
                        System.out.println(strings == strings2);
                        return strings;
                    }
                }).stream().forEach(System.out::println);
    }

    @Test
    public void ReduceDTest() {
        ArrayList<Integer> accResult_ = Stream.of(2, 3, 4, 5, 6)
                .parallel().reduce(Lists.newArrayList(1),
                        (acc, item) -> {
//                            lock.lock();
//                            long id = Thread.currentThread().getId();
//                            System.out.println("id:" + id +  ",acc before+ : " + acc);
//                            System.out.println("id:" + id +  ",item: " + item);
                            acc.add(item);
//                            System.out.println("id:" + id +  ",acc after+ : " + acc);
//                            lock.unlock();
                            return acc;
                        }, (acc, item) -> {
                            System.out.println("BinaryOperator");
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            acc.addAll(item);
                            System.out.println("item: " + item);
                            System.out.println("acc+ : " + acc);
                            System.out.println("--------");
                            return acc;
                        }
                );
        System.out.println("accResult_: " + accResult_);
        System.out.println(accResult_.size());

    }

    @Test
    public void ReduceTest() {
        int accResult_ = Stream.of(2, 3, 4)
                .parallel().reduce(1,
                        (acc, item) -> {
//                            System.out.println(acc);
//                            System.out.println(item);
//                            System.out.println("-------");
                            return acc + item;
                        }
                        , (acc, item) -> {
                            System.out.println(acc);
                            System.out.println(item);
                            int result = acc + item;
                            System.out.println(acc);
                            System.out.println(item);
                            return result;
                        }
                );
        System.out.println("accResult_: " + accResult_);
    }

    @Test
    public void maxTest() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 1; i < 11; i ++) {
            Student student = new Student(i, "student-" + 1, "male", 173.0F);
            studentList.add(student);
        }
        Student finalStudent = studentList.stream()
                .max(Comparator.comparing(student -> student.no))
                .get();
        System.out.println(finalStudent);
    }

    class Student {
        Integer no;
        String name;
        String sex;
        float height;

        public Student(int no, String name, String sex, float height) {
            this.no = no;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", height=" + height +
                    '}';
        }
    }
}
