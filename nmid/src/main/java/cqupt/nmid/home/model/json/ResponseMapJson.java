package cqupt.nmid.home.model.json;

import java.util.HashMap;
import java.util.Map;

import cqupt.nmid.home.constant.StatusCodeConstant;

public class ResponseMapJson extends ResponseJson{
    private Map<String, Object> body=new HashMap<String, Object>();
    public ResponseMapJson() { }
    public ResponseMapJson(StatusCodeConstant state){
        super(state);
    }
    public void put(String key,Object value){
        body.put(key, value);
    }
    @Override
    public void setBody(Object body) {
        throw new UnsupportedOperationException("Unsupported,please use ResponseJson");
    }
    @Override
    public Object getBody() {
        return body;
    }
}
