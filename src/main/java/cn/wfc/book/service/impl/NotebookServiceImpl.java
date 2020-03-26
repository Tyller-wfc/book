package cn.wfc.book.service.impl;

import cn.wfc.book.bean.User;
import cn.wfc.book.dao.NotebookDao;
import cn.wfc.book.dao.UserDao;
import cn.wfc.book.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookDao notebookDao;

    @Autowired
    private UserDao userDao;

    @Value("${context.pageSize}")
    private int pageSize;

    public List<Map<String, Object>> listNotebooks(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new RuntimeException("ID不能空");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        return notebookDao.findNotebooksByUserId(userId);
    }

    public List<Map<String, Object>>
    listNotebooks(
            String userId, Integer page)
            throws RuntimeException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new RuntimeException("ID不能空");
        }
        User user = userDao.findUserById(userId);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        if (page == null) {
            page = 0;
        }
        int start = page * pageSize;
        String table = "cn_notebook";
        return notebookDao.findNotebooksByPage(
                userId, start, pageSize, table);
    }
}
