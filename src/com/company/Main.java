package com.company;

import com.company.Employee.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("Printing from Runnable")).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);


        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });
//        for (Employee employee: employees){
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
            //new Thread(() -> System.out.println(employee.getAge())).start();


////        Collections.sort(employees, new Comparator<Employee>() {
////            @Override
////            public int compare(Employee employee1, Employee employee2) {
////                return employee1.getName().compareTo(employee2.getName());
////            }
////        });
//
//        Collections.sort(employees, (employee1, employee2) ->
//                employee1.getName().compareTo(employee2.getName()));
//
//        for (Employee employee : employees) {
//            System.out.println(employee.getName());
//        }
//
////        String sillyString = doStringStuff(new UpperContact() {
////            @Override
////            public String upperAndContact(String s1, String s2) {
////             return s1.toUpperCase() + s2.toUpperCase();
////            }
////        }, employees.get(0).getName(), employees.get(1).getName());
////        System.out.println(sillyString);
//
//        UpperContact uc = ( s1,  s2) -> {
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
//
//        String sillyString = doStringStuff(uc,employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    public final static String doStringStuff(UpperContact uc, String s1, String s2) {
        return uc.upperAndContact(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    interface UpperContact {
        public String upperAndContact(String s1, String s2);
    }
}

class AnotherClass {
    public String doSomething() {
//        UpperContact uc = (s1, s2) -> {
//            System.out.println("Lambda expressions class is:" + getClass().getSimpleName());
//            String result = s1.toUpperCase() + s2.toUpperCase();
//            return result;
//        };
        int i = 0;
        UpperContact uc = (s1, s2) -> {
            System.out.println("The lambda expressions class is " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };
//            UpperContact uc = new UpperContact() {
//                @Override
//                public String upperAndContact(String s1, String s2) {
//                    return s1.toUpperCase() + s2.toUpperCase();
//                }
//            };
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());


        return Main.doStringStuff(uc, "String1", "String2");
//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperContact() {
//            @Override
//            public String upperAndContact(String s1, String s2) {
//                System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }

    public void printValue() {

        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("The Value is " + number);
        };
        new Thread(r).start();
    }
}