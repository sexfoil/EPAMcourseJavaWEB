package model;

import model.entity.Good;

import java.util.ArrayList;

public class ShopModel {

    private ArrayList<Department> departments;
    private String[] departmentLacations;

    public ShopModel() {
        departments = new ArrayList();
    }

    private void initData() {
        departmentLacations = new String[] {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
        departments.add(new Department("Adidas", departmentLacations[0]));
        departments.add(new Department("Reebok", departmentLacations[4]));
    }

    protected class Department<T extends Good> {
        private String name;
        private String location;
        private ArrayList<T> goods;

        public Department(String name, String location) {
            this.name = name;
            this.location = location;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public ArrayList<T> getGoods() {
            return goods;
        }

        public void setGoods(ArrayList<T> goods) {
            this.goods = goods;
        }
    }



}
