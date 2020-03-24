package cn.wfc.book.bean;

import org.springframework.stereotype.Component;

@Component
public class Result {
    private Integer state;
    private Object data;

    public Result() {
        this.state = 0;
    }

    public Result(Object data) {
        this.state = 0;
        this.data = data;
    }

    public Result(Integer state,Object data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
