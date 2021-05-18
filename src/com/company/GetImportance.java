package com.company;

import java.util.*;

public class GetImportance {

    public static void main(String[] args) {
        // int[] arr = {5,2,3};
        // int target = 10;

        System.out.println("Hello Worlds");
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> eMap = new HashMap<>(employees.size());
        for (Employee employee : employees) {
            eMap.put(employee.id, employee);
        }
        Employee request = eMap.get(id);
        if (request == null) {
            return 0;
        }
        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        queue.add(request);
        while (!queue.isEmpty()) {
            Employee handle = queue.poll();
            sum+=handle.importance;
            if(handle.subordinates!= null && !handle.subordinates.isEmpty()){
                for(int n : handle.subordinates){
                    queue.offer(eMap.get(n));
                }
            }
        }

        return sum;
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
}
