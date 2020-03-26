package cn.wfc.book.service;

import java.util.List;
import java.util.Map;

public interface NotebookService {
    List<Map<String, Object>> listNotebooks(String userId);

    List<Map<String, Object>> listNotebooks(String userId, Integer page);
}
