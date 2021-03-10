package pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class DepartmentConverter implements Converter<String, Department> {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department convert(String s) {
        return departmentDao.findById(Long.parseLong(s));
    }
}
