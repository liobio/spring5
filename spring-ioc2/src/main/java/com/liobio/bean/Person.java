package com.liobio.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    private Car car;
    private List<Book> books;
    private Map<String,Object> map;
    private Properties properties;


    public Person(String lastName, Integer age, String gender, String email, Car car, List<Book> books, Map<String, Object> map, Properties properties) {
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.car = car;
        this.books = books;
        this.map = map;
        this.properties = properties;
        System.out.println("Person调用了有参构造====");
    }

    public Person(Car car) {
        this.car = car;
        System.out.println("可以为Person的car赋值的有参构造器被调用了====");
    }

    public Person() {
        System.out.println("Person调用了无参构造====");
    }
    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", car=" + car +
                ", books=" + books +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        System.out.println("调用了Person setlastname方法===="+lastName);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
