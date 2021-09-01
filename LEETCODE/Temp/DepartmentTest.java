package Temp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jiangwentao
 * @date 2021/8/4
 * @detail
 */

public class DepartmentTest {
    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);

        List<Department> subDepartments = DepartmentTest.getSub(3, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * 要求：不能新增参数，不能增加static变量
     *
     * @param id
     * @return
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {
        //        allDepartment.forEach(e -> {
//            if (e.getPid() == id) {
//                res.add(e);
//                List<Department> tempDepartments = getSub(e.getId(), allDepartment);
//                if (tempDepartments.size() != 0) {
//                    res.addAll(tempDepartments);
//                }
//            }
//        });
        Map<Integer, List<Department>> dic = allDepartment.stream()
                .collect(Collectors.groupingBy(Department::getPid));
        List<Department> tempDeps = dic.get(id);
        List<Department> res = new ArrayList<>(tempDeps);
        List<Integer> pids = tempDeps.stream()
                .map(Department::getId).collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>(pids);
        while (!queue.isEmpty()) {
            Integer pid = queue.poll();
            List<Department> departments = dic.get(pid);
            if (departments != null) {
                res.addAll(departments);
                List<Integer> nxtPids = departments.stream()
                        .map(Department::getId).collect(Collectors.toList());
                queue.addAll(nxtPids);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
//        pids.forEach(e -> {
//            List<Department> temp = getTemp(e, dic);
//            res.addAll(temp);
//        });
//        return res;
    }
}

class Department {
    /**
     * id
     */
    private int id;
    /**
     * parent id
     */
    private int pid;
    /**
     * 名称
     */
    private String name;

    public Department(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
