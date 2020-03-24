package cn.wfc.book.dao;

import cn.wfc.book.bean.Notebook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface NotebookDao {
    List<Map<String, Object>>
    findNotebooksByUserId(
            String userId);

    int countNotebookById(String notebookId);

    List<Map<String, Object>>
    findNotebooksByPage(
            @Param("userId") String userId,
            @Param("start") int start,
            @Param("pageSize") int pageSize,
            @Param("table") String table);
}
