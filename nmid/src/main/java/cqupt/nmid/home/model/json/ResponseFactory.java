package cqupt.nmid.home.model.json;

import org.springframework.stereotype.Component;

import cqupt.nmid.home.constant.StatusCodeConstant;

@Component("repsonseFactory")
public class ResponseFactory {
    
    public ResponseJson getResponseJsonInstance(StatusCodeConstant code){
        return new ResponseJson(code);
    }
    
    public ResponseMapJson getResponseMapJsonInstance(StatusCodeConstant code){
        return new ResponseMapJson(code);
    }
}
