package cqupt.nmid.home.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cqupt.nmid.home.constant.StatusCodeConstant;
import cqupt.nmid.home.model.json.ResponseJson;
import cqupt.nmid.home.util.LogUtil;

public class ExceptionHandler implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
            HttpServletResponse reponse, Object handler, Exception ex) {
        try {
            if(null==request||null==request.getHeader("Content-Type")){
                return htmlException(request, reponse, handler, ex);
            }else if( request.getHeader("Content-Type").indexOf("application/json") > -1 ){
                return jsonException(request, reponse, handler, ex);
            }else{
                return htmlException(request, reponse, handler, ex);
            }
        } catch (IOException e) {
            //记录日志
            LogUtil.error("异常拦截失败"+getTrace(e));
            throw new RuntimeException("异常拦截失败");
        }
    }
    
    /**
     * 返回json格式的错误信息
     * @return
     * @throws IOException 
     */
    private ModelAndView jsonException(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex) throws IOException{
        ResponseJson json=new ResponseJson();
        Gson gson=new Gson();
        StatusCodeConstant state=getExceptionState(ex);
        json.setCode(state.getCode());
        json.setMessage(state.getMessage());
        response.setCharacterEncoding("UTF-8");  
        response.getWriter().write(gson.toJson(json));
        return null;
    }
    /**
     * 返回html格式错误
     * @return
     */
    private ModelAndView htmlException(HttpServletRequest request,
            HttpServletResponse reponse, Object handler, Exception ex){
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", getTrace(ex));
        StatusCodeConstant state=getExceptionState(ex);
        model.put("message", state.getMessage());
        model.put("code", state.getCode());
        return new ModelAndView("error/error", model);  
        
    }
    /**
     * 获得错误码
     * @param ex
     * @return
     */
    private StatusCodeConstant getExceptionState(Exception ex) {
        if (isInnerException(ex))
            return ((CodeStateException) ex).getExceptionState();
        else
            return StatusCodeConstant.INTERNAL_SERVER_ERROR;
    }
    /*
     * 是否是内部错误 
     */
    private boolean isInnerException(Exception ex){
        return (ex instanceof CodeStateException);
    }
    /**
     * 得到错误堆栈信息
     * @param t
     * @return
     */
    private String getTrace(Throwable t) {
        StringWriter stringWriter= new StringWriter();
        PrintWriter writer= new PrintWriter(stringWriter);
        t.printStackTrace(writer);
        StringBuffer buffer= stringWriter.getBuffer();
        return buffer.toString();
    }

}
