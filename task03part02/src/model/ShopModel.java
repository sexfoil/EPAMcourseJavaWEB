package model;

import model.entity.Good;

import java.util.Arrays;
import java.util.Comparator;

public class ShopModel {

    public static final String[] DEPARTMENT_LOCATIONS = new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    private int shopCapacity;
    private boolean isFull;
    private boolean isEmpty;
    private Department[] departments;

    public ShopModel() {
        initData();
    }

    private void initData() {
        shopCapacity = DEPARTMENT_LOCATIONS.length;
        departments = new Department[shopCapacity];
        isEmpty = true;
        isFull = false;
    }

    public int getAmountOfDepartments() {
        int amount = 0;
        for (Department department : departments) {
            if (department != null) {
                amount++;
            }
        }
        return amount;
    }

    public Department[] getListOfDepartments(boolean toBeSorted) {
        Department[] copy = Arrays.copyOf(departments, departments.length);
        if (toBeSorted) {
            Arrays.sort(copy, new Comparator<Department>() {
                @Override
                public int compare(Department d1, Department d2) {
                    if (d1 == null && d2 == null) {
                        return 0;
                    } else if (d2 == null) {
                        return -1;
                    } else if (d1 == null) {
                        return 1;
                    } else {
                        return d1.name.compareTo(d2.name);
                    }
                }
            });
        }
        return copy;
    }

    public boolean addDepartment(String[] data) {
        Department newDepartment = new Department(data[0], data.length > 1 ? Integer.parseInt(data[1]) : 10);
        return addDepartment(newDepartment);
    }

    public boolean addDepartment(Department department) {
        if (!isFull) {
            int emptyLocation = getEmptyPlaceIndex();
            if (emptyLocation >= 0) {
                departments[emptyLocation] = department;
                isFull = !(getAmountOfDepartments() < shopCapacity);
                isEmpty = false;
                return true;
            }
        }
        return false;
    }

    public boolean removeDepartment(String name) {
        if (!isEmpty) {
            int deleteIndex = getDepartmentIndex(name);
            if (deleteIndex >= 0) {
                departments[deleteIndex] = null;
                isEmpty = !(getAmountOfDepartments() > 0);
                isFull = false;
                return true;
            }
        }
        return false;
    }

    public boolean swapDepartments(String[] names) {
        if (names.length > 1) {
            int indexDepartment1 = getDepartmentIndex(names[0]);
            int indexDepartment2 = getDepartmentIndex(names[1]);
            if (!(indexDepartment1 < 0 || indexDepartment2 < 0)) {
                Department temp = departments[indexDepartment1];
                departments[indexDepartment1] = departments[indexDepartment2];
                departments[indexDepartment2] = temp;
                departments[indexDepartment1].location = DEPARTMENT_LOCATIONS[indexDepartment1];
                departments[indexDepartment2].location = DEPARTMENT_LOCATIONS[indexDepartment2];
                return true;
            }
        }
        return false;
    }

    public int getDepartmentIndex(String name) {
        for (int index = 0; index < departments.length; index++) {
            if (departments[index] != null && departments[index].getName().equals(name)) {
                return index;
            }
        }
        return -1;
    }

    private int getEmptyPlaceIndex() {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public Good[] getGoodsOfDepartment(String nameDepartment) {
        int index = getDepartmentIndex(nameDepartment);
        return index < 0 ? null : departments[index].getGoods();
    }

    public Good[] getSortedGoodsOfDepartment(String nameDepartment, Comparator comparator) {
        int index = getDepartmentIndex(nameDepartment);
        Good[] sortedGoods = Arrays.copyOf(departments[index].goods, departments[index].goods.length);
        Arrays.sort(sortedGoods, comparator);
        return sortedGoods;
    }

    public boolean addGoodToDepartment(String nameDepartment, String[] goodData) {
        int index = getDepartmentIndex(nameDepartment);
        Department current = departments[index];
        Good newGood = new Good(goodData[0], Double.parseDouble(goodData[1]));
        return current.addGood(newGood);

    }

    public boolean removeGoodFromDepartment(String nameDepartment, String goodName) {
        int index = getDepartmentIndex(nameDepartment);
        Department current = departments[index];
        Good delGood = null;
        for (Good g : current.goods) {
            if (g != null && g.getName().equals(goodName)) {
                delGood = g;
                break;
            }
        }
        return current.removeGood(delGood);

    }

    public boolean replaceGoodToAnotherDepartment(String goodName, String fromDepartment, String toDepartment) {
        int indexFrom = getDepartmentIndex(fromDepartment);
        int goodIndex;
        if ((goodIndex = departments[indexFrom].isGoodExist(goodName)) >= 0) {
            int indexTo = getDepartmentIndex(toDepartment);
            departments[indexTo].addGood(departments[indexFrom].goods[goodIndex]);
            departments[indexFrom].removeGood(departments[indexFrom].goods[goodIndex]);
            return true;
        }
        return false;
    }

    public boolean isDepartmentFull(String name) {
        int index = getDepartmentIndex(name);
        return !(departments[index].currentEmptySlot < departments[index].departmentCapacity);
    }

    public int getShopCapacity() {
        return shopCapacity;
    }

    public boolean isFull() {
        return isFull;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    protected class Department {
        private String name;
        private String location;
        private int departmentCapacity;
        private int currentEmptySlot;
        private Good[] goods;

        public Department(String name, int departmentCapacity) {
            this.name = name;
            this.departmentCapacity = departmentCapacity;
            this.location = DEPARTMENT_LOCATIONS[getEmptyPlaceIndex()];
            goods = new Good[departmentCapacity];
            currentEmptySlot = 0;
        }

        public boolean addGood(Good good) {
            if (currentEmptySlot < departmentCapacity) {
                goods[currentEmptySlot] = good;
                currentEmptySlot++;
                return true;
            }
            return false;
        }

        public boolean removeGood(Good good) {
            if (currentEmptySlot > 0 && good != null) {
                int delIndex = -1;
                for (int i = 0; i < goods.length; i++) {
                    if (goods[i] == null) {
                        break;
                    }
                    if (good.equals(goods[i])) {
                        delIndex = i;
                        break;
                    }
                }
                if (delIndex >= 0) {
                    for (int i = delIndex; i < goods.length - 1; i++) {
                        goods[i] = goods[i + 1];
                    }
                    goods[--currentEmptySlot] = null;
                    return true;
                }
            }
            return false;
        }

        public int isGoodExist(String name) {
            for (int i = 0; i < goods.length; i++) {
                if (goods[i] != null && goods[i].getName().equals(name)) {
                    return i;
                }
            }
            return -1;
        }


        @Override
        public String toString() {
            return String.format(" Department '%s' located in '%s'.", name, location);
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

        public int getDepartmentCapacity() {
            return departmentCapacity;
        }

        public Good[] getGoods() {
            return goods;
        }
    }
}
