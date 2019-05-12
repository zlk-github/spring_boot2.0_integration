package com.interceptor.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**desc：登录信息session拦截器
 * @author  zhoulk
 * date: 2019/5/5 0005
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

    /**
     * preHandle是请求执行前执行,返回true执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * postHandler是请求结束执行的，但只有preHandle方法返回true的时候才会执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    /**
     * afterCompletion是视图渲染完成后才执行，同样需要preHandle返回true，该方法通常用于清理资源等工作
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    /**
     * preHandle是请求执行前执行,返回true执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
        HttpSession session = request.getSession(true);

        String[] allowUrls = {"/user/login","/user/valicode","/user/loginOut"};
        if(StringUtils.isNoneBlank(requestUrl)){
            for(String url:allowUrls){
                if(requestUrl.equals(url)){
                    return true;
                }
            }
        }

        if (session != null && session.getAttribute(SessionUtils.SESSION_USER) != null) {
            logger.info(session.getAttribute(SessionUtils.SESSION_USER)+"当前有效！");
            return true;
        } else {
             *//*
         	 PrintWriter printWriter = response.getWriter();
             printWriter.write("{code:9,message:\"请重新登录！\"}");
             *//*
            ResultInfo result = new ResultInfo(9,"请重新登录！");
            String jsonObjectStr = JSONObject.toJSONString(result);
            returnJson(request,response,jsonObjectStr);
            logger.info(SessionUtils.SESSION_USER+"已失效！");
            return false;
        }
    }

    private void returnJson(HttpServletRequest request,HttpServletResponse response, String json) throws Exception{
    	*//*response.setHeader("Access-Control-Allow-Origin",  request.getHeader("Origin"));
		response.addHeader("Access-Control-Allow-Credentials", "true");*//*
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            logger.error("response error",e);
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }*/
}
