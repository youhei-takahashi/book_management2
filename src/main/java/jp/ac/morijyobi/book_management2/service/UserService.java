package jp.ac.morijyobi.book_management2.service;

import jp.ac.morijyobi.book_management2.bean.entity.User;
import jp.ac.morijyobi.book_management2.bean.form.UserForm;

public interface UserService {
    User registerUser(UserForm userForm);
}
