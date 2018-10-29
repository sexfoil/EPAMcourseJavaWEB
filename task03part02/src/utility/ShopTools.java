package utility;

import model.ShopModel;

public class ShopTools {

    private ShopModel model;

    public ShopTools(ShopModel model) {
        this.model = model;
    }

    public boolean createDepartment(String[] data) {
        return !model.isFull() && model.addDepartment(data);
    }

    public boolean deleteDepartment(String name) {
        return !model.isEmpty() && model.removeDepartment(name);
    }

    public boolean swapDepartments(String[] names) {
        return model.swapDepartments(names);
    }

    public boolean isDepartmentExist(String name) {
        return model.getDepartmentIndex(name) >= 0;
    }
}
