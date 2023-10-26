package com.example.rxjava;

class Employee2 {
    private String name;
    private int salary;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }

    public Employee2(String name, int salary){
        this.name = name;
        this.salary = salary;
    }
}
